package xin.rtime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xin.rtime.mapper.UserMapper;
import xin.rtime.model.User3;

/**
 * 
 *   示例6 ： 
 *   
 *      Spring boot 与  mybatis 集成
 *      
 *   引入依赖：
 *   
 *       <dependency>
 *    		<groupId>org.mybatis.spring.boot</groupId>
 *    		<artifactId>mybatis-spring-boot-starter</artifactId>
 *   		<version>1.3.2</version>
 *		 </dependency>
 *
 */
@RestController
@SpringBootApplication
@RequestMapping("/chapter6")
public class Chapter6Application {

	private final UserMapper userMapper;
	
	@Autowired
	public Chapter6Application(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
    @PostMapping
    public int addUser(@RequestBody User3 user) {
    	return userMapper.insert(user);
    }
    
	public static void main(String[] args) {
		SpringApplication.run(Chapter6Application.class, args);
	}
}


