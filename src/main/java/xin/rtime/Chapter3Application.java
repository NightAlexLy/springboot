package xin.rtime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 示例3：
 * 
 *   springboot 与 Thymeleaf 整合
 *   
 *   依赖：
 *   <dependency>
 * 	   <groupId>org.springframework.boot</groupId>
 *     <artifactId>spring-boot-starter-thymeleaf</artifactId>
 *    </dependency>
 *   
 *   thymeleaf的默认文件目录： src/main/resources/templates
 *   
 *      修改icon： src/main/static/favicon.ico 
 *      
 *   关于thymeleaf的配置：
 *   
 *       # thymeleaf相关配置参数 (ThymeleafAutoConfiguration)
 *			spring.thymeleaf.prefix=classpath:/templates/
 *			spring.thymeleaf.suffix=.html
 *			spring.thymeleaf.mode=HTML5
 *			spring.thymeleaf.encoding=UTF-8
 *			spring.thymeleaf.content-type=text/html # ;charset=<encoding> is added
 *			spring.thymeleaf.cache=true # set to false for hot refresh
 *
 */
@RestController
@SpringBootApplication
@RequestMapping("/chapter3")
public class Chapter3Application {

    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView();
        // 设置跳转的视图 默认映射到 src/main/resources/templates/{viewName}.html
        view.setViewName("index");
        // 设置属性
        view.addObject("title", "test");
        view.addObject("desc", "test");
        Author author = new Author();
        author.setAge(22);
        author.setEmail("aaaaa@qq.com");
        author.setName("AAAA");
        view.addObject("author", author);
        return view;
    }

    @GetMapping("/index1")
    public String index1(HttpServletRequest request) {
        // TODO 与上面的写法不同，但是结果一致。
        // 设置属性
        request.setAttribute("title", "test");
        request.setAttribute("desc", "test");
        Author author = new Author();
        author.setAge(22);
        author.setEmail("aaaaa@qq.com");
        author.setName("AAAA");
        request.setAttribute("author", author);
        // 返回的 index 默认映射到 src/main/resources/templates/xxxx.html
        return "index";
    }
    
	public static void main(String[] args) {
        SpringApplication.run(Chapter3Application.class, args);
    }
    
    class Author {
        private int age;
        private String name;
        private String email;
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
    	
    }

}
