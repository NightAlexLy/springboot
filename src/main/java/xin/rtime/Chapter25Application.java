package xin.rtime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 *   示例23 ：
 *   
 *      Spring boot 限流
 *      
 *   引入依赖：
 *   
 *	    <dependency>
 *	        <groupId>org.springframework.boot</groupId>
 *	        <artifactId>spring-boot-starter-web</artifactId>
 *	    </dependency>
 *
 *
 */
@SpringBootApplication
public class Chapter25Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter25Application.class, args);
	}
	
}
