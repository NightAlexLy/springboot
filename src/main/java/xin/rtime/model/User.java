package xin.rtime.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * Chapter 4 JdbcTemplate model
 */
@Getter
@Setter
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8150275276859257942L;
	
	private Long id;
	private String username;
	private String password;
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public User() {
	}
	
}
