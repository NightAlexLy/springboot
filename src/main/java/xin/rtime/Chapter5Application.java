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

import xin.rtime.model.User2;
import xin.rtime.repository.UserRepository;

/**
 *   示例5：
 *   
 *       spring boot 与  spring-data-jpa(hibernate) 整合
 *       
 *   依赖：
 *   
 *   	<!-- Spring JDBC 的依赖包，使用 spring-boot-starter-jdbc 或 spring-boot-starter-data-jpa 将会自动获得HikariCP依赖 -->
 *	 	<dependency>
 *   		 <groupId>org.springframework.boot</groupId>
 *   		 <artifactId>spring-boot-starter-data-jpa</artifactId>
 *		</dependency>
 *  
 *   spring.jpa.hibernate.ddl-auto=update
 *   
 *   ddl-auto 的几个属性
 *   
 *   	create： 每次运行程序时，都会重新创建表，故而数据会丢失
 *		create-drop： 每次运行程序时会先创建表结构，然后待程序结束时清空表
 *		upadte： 每次运行程序，没有表时会创建表，如果对象发生改变会更新表结构，原有数据不会清空，只会更新（推荐使用）
 *		validate： 运行程序会校验数据与数据库的字段类型是否相同，字段不同会报错
 *  
 *   关于Model自增主键的几个选项：
 *   
 *  	TABLE： 使用一个特定的数据库表格来保存主键
 *  	SEQUENCE： 根据底层数据库的序列来生成主键，条件是数据库支持序列。这个值要与generator一起使用，generator 指定生成主键使用的生成器（可能是orcale中自己编写的序列）。
 *  	IDENTITY： 主键由数据库自动生成（主要是支持自动增长的数据库，如mysql）
 *  	AUTO： 主键由程序控制，也是GenerationType的默认值。
 *
 */
@RestController
@SpringBootApplication
@RequestMapping("/users2")
public class Chapter5Application {

	private final UserRepository userRepository;
	
	@Autowired
	public Chapter5Application(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
    @GetMapping
    public List<User2> queryUsers() {
    	return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User2 getUser(@PathVariable Long id) {
    	return userRepository.findById(id).get();
    }

    @DeleteMapping("/{id}")
    public void delUser(@PathVariable Long id) {
    	userRepository.deleteById(id);
    }

    @PostMapping
    public Long addUser(@RequestBody User2 user) {
    	User2 saveUser = userRepository.save(user);
    	return saveUser.getId();
    }

    @PutMapping("/{id}")
    public void editUser(@PathVariable Long id, @RequestBody User2 user) {
    	user.setId(id);
    	userRepository.save(user);
    }
    
    public static void main(String[] args) {
        SpringApplication.run(Chapter5Application.class, args);
    }	
	
}
