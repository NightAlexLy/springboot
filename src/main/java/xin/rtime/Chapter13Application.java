package xin.rtime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.endpoint.condition.ConditionalOnEnabledEndpoint;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import xin.rtime.actuator.endpoint.MyEndPoint;

/**
 * 
 *   示例13 ：
 *   
 *      Spring boot 与  actuator 集成 
 *      
 *      
 *   引入依赖：
 *   
 * 		<dependency>
 *    		<groupId>org.springframework.boot</groupId>
 *    		<artifactId>spring-boot-starter-actuator</artifactId>
 *		</dependency>
 *
 *         
 */

@SpringBootApplication
public class Chapter13Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter13Application.class, args);
	}
	
    @Configuration
    static class MyEndpointConfiguration {
        @Bean
        @ConditionalOnMissingBean
        @ConditionalOnEnabledEndpoint
        public MyEndPoint myEndPoint() {
            return new MyEndPoint();
        }
    }
}
