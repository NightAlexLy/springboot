package xin.rtime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 *   示例22 ：
 *   
 *      Spring boot 与  Shiro[安全框架]  整合
 *      
 *   引入依赖：
 *    	<shiro.version>1.4.0</shiro.version>
 *   
 *	    <dependency>
 *	        <groupId>org.apache.shiro</groupId>
 *	        <artifactId>shiro-core</artifactId>
 *	        <version>${shiro.version}</version>
 *	    </dependency>
 *	    <dependency>
 *	        <groupId>org.apache.shiro</groupId>
 *	        <artifactId>shiro-spring</artifactId>
 *	        <version>${shiro.version}</version>
 *	    </dependency>
 *	    <dependency>
 *	        <groupId>org.apache.shiro</groupId>
 *	        <artifactId>shiro-ehcache</artifactId>
 *	        <version>${shiro.version}</version>
 *	    </dependency>
 *
 *
 */
@SpringBootApplication
public class Chapter22Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter22Application.class, args);
	}
	
}
