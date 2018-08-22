package xin.rtime.swagger.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ApiModel
@ToString
public class User implements Serializable {

    private static final long serialVersionUID = 8655851615465363473L;

    private Long id;
    @ApiModelProperty("用户名")
    private String username;
    @ApiModelProperty("密码")
    private String password;
	public User() {}
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	public User(Long id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}
    
}