package xin.rtime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 *   示例24 ：
 *   
 *      Spring boot 与  liquibase 整合
 *      
 *   引入依赖：
 *   
 *	    <dependency>
 *	        <groupId>org.liquibase</groupId>
 *	        <artifactId>liquibase-core</artifactId>
 *	    </dependency>
 *
 *
 */
@SpringBootApplication
public class Chapter24Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter24Application.class, args);
	}

}
