package xin.rtime;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import xin.rtime.model.User2;
import xin.rtime.repository.UserRepository;

/**
 * 
 *  chapter5 示例验证
 *  
 *  Unable to start web server; nested exception is org.springframework.context.ApplicationContextException:
 *  Unable to start ServletWebServerApplicationContext due to missing ServletWebServerFactory bean.
 *   
 *  解决办法：https://www.cnblogs.com/gudi/p/8711606.html
 *   
 *
 */
@EnableAutoConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Chapter5ApplicationTests.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Chapter5ApplicationTests {

	private static final Logger log = LoggerFactory.getLogger(Chapter5ApplicationTests.class);

	@Autowired
	private UserRepository userRepository;

	@Test
	public void test1() throws Exception {
		final User2 user = userRepository.save(new User2("u1", "p1"));
		log.info("[添加成功] - [{}]", user);
		final List<User2> u1 = userRepository.findAllByUsername("u1");
		log.info("[条件查询] - [{}]", u1);
		Pageable pageable = PageRequest.of(0, 10, Sort.by(Sort.Order.desc("username")));
		final Page<User2> users = userRepository.findAll(pageable);
		log.info("[分页+排序+查询所有] - [{}]", users.getContent());
		userRepository.findById(users.getContent().get(0).getId()).ifPresent(user1 -> log.info("[主键查询] - [{}]", user1));
		final User2 edit = userRepository.save(new User2(user.getId(), "修改后的ui", "修改后的p1"));
		log.info("[修改成功] - [{}]", edit);
		userRepository.deleteById(user.getId());
		log.info("[删除主键为 {} 成功] - [{}]", user.getId());
	}
}
