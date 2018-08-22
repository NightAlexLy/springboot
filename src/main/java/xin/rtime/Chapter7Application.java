package xin.rtime;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import xin.rtime.mapper.UserMapper2;
import xin.rtime.model.User3;

/**
 * 
 *   示例7 ：
 *   
 *      Spring boot 与  Mybatis-Mapper 集成
 *      
 *   引入依赖：
 *   
 *   <!-- 分页插件
 *	     文档地址：https://github.com/pagehelper/Mybatis-PageHelper/blob/master/wikis/zh/HowToUse.md -->
 *	  <dependency>
 *	      <groupId>com.github.pagehelper</groupId>
 *	      <artifactId>pagehelper-spring-boot-starter</artifactId>
 *	      <version>1.2.5</version>
 *	  </dependency>
 *
 *   简单的PageInfo分页示例
 *
 */
@RestController
@SpringBootApplication
@RequestMapping("/chapter7")
public class Chapter7Application {

	private final UserMapper2 userMapper2;
	
	@Autowired
	public Chapter7Application(UserMapper2 userMapper2) {
		this.userMapper2 = userMapper2;
	}
	
	@GetMapping("/pageInfo")
	public List<User3> pageInfo(int pageSize,int pageNum) {
		/*PageInfo<User3> userPageInfo = new PageInfo<>(userMapper2.selectAll());
		userPageInfo.setPageSize(pageSize);
		userPageInfo.setPageNum(pageNum);*/
		PageInfo<User3> userPageInfo = PageHelper.startPage(pageNum, pageSize)
				.setOrderBy("").doSelectPageInfo(() -> this.userMapper2.selectAll());
		return userPageInfo.getList();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Chapter7Application.class, args);
	}
}
