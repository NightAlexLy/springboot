package xin.rtime.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 *
 *  Chapter6&Chapter7  Mybatis Model
 *
 */
@Getter
@Setter
@Table(name = "t_user")
public class User3 implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String password;
	
	public User3() {}
	public User3(String username, String password) {
		this.username = username;
		this.password = password;
	}

}
