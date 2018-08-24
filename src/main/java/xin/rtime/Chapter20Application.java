package xin.rtime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 *   示例20 ：
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
public class Chapter20Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter20Application.class, args);
	}

}
