package xin.rtime.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 *  chapter8  User缓存对象
 */
@Getter
@Setter
public class UserCache implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String username;
	private String password;
	public UserCache() {}
	public UserCache(Long id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}
	
}
