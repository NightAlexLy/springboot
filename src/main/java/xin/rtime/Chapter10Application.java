package xin.rtime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 *   示例10 ：
 *   
 *      Spring boot 与  Swagger 集成
 *      
 *      
 *   引入依赖：
 *   
 *		<dependency>
 *		    <groupId>com.battcn</groupId>
 *		    <artifactId>swagger-spring-boot-starter</artifactId>
 *		    <version>2.0.7-RELEASE</version>
 *		</dependency>
 *
 *   QA：
 *      1. 访问swagger-ui.html报404错误
 *         
 *         可能是没有访问到服务（参考ServletContextConfig配置）
 *         
 *      2. 访问swagger-uihtml报405错误
 *      
 *          检查`Controller`是否都加入了`@RequestMapping`注解     
 *         
 */
@SpringBootApplication
public class Chapter10Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Chapter10Application.class, args);
	}

}
