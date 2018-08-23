package xin.rtime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 *   示例12 ：
 *   
 *      Spring boot 与  RabbitMQ 集成 [延迟消息]
 *      
 *      
 *   引入依赖：
 *   
 *    	<dependency>
 *    	    <groupId>org.springframework.boot</groupId>
 *    	    <artifactId>spring-boot-starter-amqp</artifactId>
 *    	</dependency>
 *   	<dependency>
 *     		<groupId>com.alibaba</groupId>
 *     	    <artifactId>fastjson</artifactId>
 *          <version>1.2.46</version>
 *    	</dependency>
 *
 *         
 */
@SpringBootApplication
public class Chapter12Application {

	
	public static void main(String[] args) {
		SpringApplication.run(Chapter12Application.class, args);
	}
}
