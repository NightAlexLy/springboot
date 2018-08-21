package xin.rtime.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import xin.rtime.model.User3;

/**
 * Chapter6 的 示例Mapper
 * 
 *   暂时只实现了insert和findByUsername方法，
 *    
 *      基础CRUD有两种方式：
 *      
 *         1. 通过注解的方式
 *         2. 通过XML的方式（建议这种，可配置化）
 */
@Mapper
public interface UserMapper {

	 /**
     * 根据用户名查询用户结果集
     *
     * @param username 用户名
     * @return 查询结果
     */
    @Select("SELECT * FROM t_user WHERE username = #{username}")
    List<User3> findByUsername(@Param("username") String username);

    /**
     * 保存用户信息
     *
     * @param user 用户信息
     * @return 成功 1 失败 0
     */
    int insert(User3 user);
}
