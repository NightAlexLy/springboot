package xin.rtime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xin.rtime.model.User;
import xin.rtime.service.UserService;

/**
 * 
 *   示例9 ：
 *   
 *      Spring boot 与  Cache 集成
 *      
 *      
 *   引入依赖：
 *   
 *   	<dependency>
 *    		<groupId>org.springframework.boot</groupId>
 *    		<artifactId>spring-boot-starter-data-redis</artifactId>
 *		</dependency>
 *		<dependency>
 *    		<groupId>org.apache.commons</groupId>
 *    		<artifactId>commons-pool2</artifactId>
 *		</dependency>
 *
 */
@RestController
@SpringBootApplication
@EnableCaching
@RequestMapping("/chapter9")
public class Chapter9Application {

	private final UserService userService;
	
	@Autowired
	public Chapter9Application(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/getUser/{id}")
	public User getObject(@PathVariable Long id) {
		return userService.get(id);
	}
	
	@PostMapping("/setUser")
	public void setObject(@RequestBody User user) {
		userService.saveOrUpdate(user);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Chapter9Application.class, args);
	}
}
