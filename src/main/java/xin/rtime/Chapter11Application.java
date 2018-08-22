package xin.rtime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 *   示例11 ：
 *   
 *      Spring boot 与  RabbitMQ 集成
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
public class Chapter11Application {

	
	public static void main(String[] args) {
		SpringApplication.run(Chapter11Application.class, args);
	}
}
