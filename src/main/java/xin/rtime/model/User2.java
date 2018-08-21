package xin.rtime.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

/**
 * Chapter 5 JPA model
 */
@Entity(name = "t_user")
@Getter
@Setter
public class User2 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 自增策略
	 *  TABLE： 使用一个特定的数据库表格来保存主键
	 *  SEQUENCE： 根据底层数据库的序列来生成主键，条件是数据库支持序列。这个值要与generator一起使用，generator 指定生成主键使用的生成器（可能是orcale中自己编写的序列）。
	 *  IDENTITY： 主键由数据库自动生成（主要是支持自动增长的数据库，如mysql）
	 *  AUTO： 主键由程序控制，也是GenerationType的默认值。
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String password;
	
	/**
	 * 不需要映射
	 */
	@Transient
	private String email;

	public User2() { }
	public User2(String username, String password) {
		this.username = username;
		this.password = password;
	}
	public User2(Long id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}
	
}
