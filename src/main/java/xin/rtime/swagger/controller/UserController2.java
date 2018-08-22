package xin.rtime.swagger.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;
import xin.rtime.swagger.model.JsonResult;
import xin.rtime.swagger.model.User2;

@RestController
@RequestMapping("/swaggerUsers")
public class UserController2 {

	// 创建线程安全的Map
	static Map<Integer, User2> users = Collections.synchronizedMap(new HashMap<Integer, User2>());

	/**
	 * 根据ID查询用户
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
	@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
	@RequestMapping(value = "User2/{id}", method = RequestMethod.GET)
	public ResponseEntity<JsonResult> getUser2ById(@PathVariable(value = "id") Integer id) {
		JsonResult r = new JsonResult();
		try {
			User2 User2 = users.get(id);
			r.setResult(User2);
			r.setStatus("ok");
		} catch (Exception e) {
			r.setResult(e.getClass().getName() + ":" + e.getMessage());
			r.setStatus("error");
			e.printStackTrace();
		}
		return ResponseEntity.ok(r);
	}

	/**
	 * 查询用户列表
	 * 
	 * @return
	 */
	@ApiOperation(value = "获取用户列表", notes = "获取用户列表")
	@RequestMapping(value = "User2s", method = RequestMethod.GET)
	public ResponseEntity<JsonResult> getUser2List() {
		JsonResult r = new JsonResult();
		try {
			List<User2> User2List = new ArrayList<User2>(users.values());
			r.setResult(User2List);
			r.setStatus("ok");
		} catch (Exception e) {
			r.setResult(e.getClass().getName() + ":" + e.getMessage());
			r.setStatus("error");
			e.printStackTrace();
		}
		return ResponseEntity.ok(r);
	}

	/**
	 * 添加用户
	 * 
	 * @param User2
	 * @return
	 */
	@ApiOperation(value = "创建用户", notes = "根据User2对象创建用户")
	@ApiImplicitParam(name = "User2", value = "用户详细实体User2", required = true, dataType = "User2")
	@RequestMapping(value = "User2", method = RequestMethod.POST)
	public ResponseEntity<JsonResult> add(@RequestBody User2 User2) {
		JsonResult r = new JsonResult();
		try {
			users.put(User2.getId(), User2);
			r.setResult(User2.getId());
			r.setStatus("ok");
		} catch (Exception e) {
			r.setResult(e.getClass().getName() + ":" + e.getMessage());
			r.setStatus("error");

			e.printStackTrace();
		}
		return ResponseEntity.ok(r);
	}

	/**
	 * 根据id删除用户
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "删除用户", notes = "根据url的id来指定删除用户")
	@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", paramType = "path")
	@RequestMapping(value = "User2/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<JsonResult> delete(@PathVariable(value = "id") Integer id) {
		JsonResult r = new JsonResult();
		try {
			users.remove(id);
			r.setResult(id);
			r.setStatus("ok");
		} catch (Exception e) {
			r.setResult(e.getClass().getName() + ":" + e.getMessage());
			r.setStatus("error");

			e.printStackTrace();
		}
		return ResponseEntity.ok(r);
	}

	/**
	 * 根据id修改用户信息
	 * 
	 * @param User2
	 * @return
	 */
	@ApiOperation(value = "更新信息", notes = "根据url的id来指定更新用户信息")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", paramType = "path"),
			@ApiImplicitParam(name = "User2", value = "用户实体User2", required = true, dataType = "User2") })
	@RequestMapping(value = "User2/{id}", method = RequestMethod.PUT)
	public ResponseEntity<JsonResult> update(@PathVariable("id") Integer id, @RequestBody User2 User2) {
		JsonResult r = new JsonResult();
		try {
			User2 u = users.get(id);
			u.setUsername(User2.getUsername());
			u.setAge(User2.getAge());
			users.put(id, u);
			r.setResult(u);
			r.setStatus("ok");
		} catch (Exception e) {
			r.setResult(e.getClass().getName() + ":" + e.getMessage());
			r.setStatus("error");

			e.printStackTrace();
		}
		return ResponseEntity.ok(r);
	}

	@ApiIgnore // 使用该注解忽略这个API
	@RequestMapping(value = "/hi", method = RequestMethod.GET)
	public String jsonTest() {
		return " hi you!";
	}
}