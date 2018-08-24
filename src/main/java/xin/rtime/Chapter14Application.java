package xin.rtime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import de.codecentric.boot.admin.server.config.AdminServerProperties;
import de.codecentric.boot.admin.server.config.EnableAdminServer;

/**
 * 
 *   示例14 ：
 *   
 *      Spring boot 与  spring-boot-admin 集成 
 *      
 *      
 *   引入依赖：
 *   
 *		<!-- 服务端：带UI界面 -->
 *		<dependency>
 *		    <groupId>de.codecentric</groupId>
 *		    <artifactId>spring-boot-admin-starter-server</artifactId>
 *		    <version>2.0.0</version>
 *		</dependency>
 *		<!-- 客户端包 -->
 *		<dependency>
 *		    <groupId>de.codecentric</groupId>
 *		    <artifactId>spring-boot-admin-starter-client</artifactId>
 *		    <version>2.0.0</version>
 *		</dependency>
 *		<!-- 安全认证 -->
 *		<dependency>
 *		    <groupId>org.springframework.boot</groupId>
 *		    <artifactId>spring-boot-starter-security</artifactId>
 *		</dependency>
 *		<!-- 在管理界面中与 JMX-beans 进行交互所需要被依赖的 JAR -->
 *		<dependency>
 *		    <groupId>org.jolokia</groupId>
 *		    <artifactId>jolokia-core</artifactId>
 *		</dependency>
 *
 *         
 */
@SpringBootApplication
@EnableAdminServer
public class Chapter14Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter14Application.class, args);
	}
	
    /**
     * dev 环境加载
     */
    @Profile("dev")
    @Configuration
    public static class SecurityPermitAllConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests().anyRequest().permitAll()
                    .and().csrf().disable();
        }
    }

    /**
     * chapter14 环境加载
     */
    @Profile("chapter14")
    @Configuration
    public static class SecuritySecureConfig extends WebSecurityConfigurerAdapter {
        private String adminContextPath;
        
        public SecuritySecureConfig() {
		}

		@Autowired
        public SecuritySecureConfig(AdminServerProperties adminServerProperties) {
            this.adminContextPath = adminServerProperties.getContextPath();
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
            successHandler.setTargetUrlParameter("redirectTo");

            if(adminContextPath != null && adminContextPath.length() != 0) {
            	http.authorizeRequests()
                .antMatchers(adminContextPath + "/assets/**").permitAll()
                .antMatchers(adminContextPath + "/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage(adminContextPath + "/login").successHandler(successHandler).and()
                .logout().logoutUrl(adminContextPath + "/logout").and()
                .httpBasic().and()
                .csrf().disable();
            }
        }
    }
}
