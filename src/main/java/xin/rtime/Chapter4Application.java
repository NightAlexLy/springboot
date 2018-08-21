package xin.rtime;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xin.rtime.model.User;
import xin.rtime.service.Chapter4Service;

/**
 *  示例4：
 *   
 *      spring boot 与 spring JdbcTemplate 整合
 *      
 *   依赖：
 *    	<!-- Spring JDBC 的依赖包，使用 spring-boot-starter-jdbc 或 spring-boot-starter-data-jpa 将会自动获得HikariCP依赖 -->
 * 		<dependency>
 * 		    <groupId>org.springframework.boot</groupId>
 * 		    <artifactId>spring-boot-starter-jdbc</artifactId>
 * 		</dependency>
 * 		<!-- MYSQL包 -->
 * 		<dependency>
 * 		    <groupId>mysql</groupId>
 * 		    <artifactId>mysql-connector-java</artifactId>
 * 		</dependency>
 *     
 *   前置环境构建
 *   
 *     创建示例表：
 *     
 *     CREATE TABLE `t_user` (
 *  	`id` int(8) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
 *  	`username` varchar(50) NOT NULL COMMENT '用户名',
 * 		`password` varchar(50) NOT NULL COMMENT '密码',
 *  	PRIMARY KEY (`id`)
 * 		) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';
 *
 *   参考： Chapter4Service
 *      
 *      
 */
@RestController
@SpringBootApplication
@RequestMapping("/users")
public class Chapter4Application {

	private final Chapter4Service chapter4Service;
	
	@Autowired
	public Chapter4Application(Chapter4Service chapter4Service) {
		this.chapter4Service = chapter4Service;
	}
	
    @GetMapping
    public List<User> queryUsers() {
    	return chapter4Service.queryUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
    	return chapter4Service.getUser(id);
    }

    @DeleteMapping("/{id}")
    public int delUser(@PathVariable Long id) {
    	return chapter4Service.delUser(id);
    }

    @PostMapping
    public int addUser(@RequestBody User user) {
    	return chapter4Service.addUser(user);
    }


    @PutMapping("/{id}")
    public int editUser(@PathVariable Long id, @RequestBody User user) {
    	return chapter4Service.editUser(id,user);
    }
    
    public static void main(String[] args) {
        SpringApplication.run(Chapter4Application.class, args);
    }
	
}
