package xin.rtime.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xin.rtime.model.User2;

/**
 * chapter5 JPA Repository
 *  
 *   针对User2操作
 *   
 *   创建UserRepository数据访问层接口，需要继承JpaRepository<T,K>，
 *   第一个泛型参数是实体对象的名称，第二个是主键类型。
 *   只需要这样简单的配置，该UserRepository就拥常用的CRUD功能，paRepository本身就包含了常用功能。
 *   剩下的查询我们按照规范写接口即可，
 *   JPA支持@Query注解写HQL，也支持findAllByUsername这种根据字段名命名的方式
 */
@Repository
public interface UserRepository extends JpaRepository<User2, Long> {
	
	/**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return 查询结果
     */
    List<User2> findAllByUsername(String username);
    
}
