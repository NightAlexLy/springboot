package xin.rtime.rabbitmq.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * Chapter11 Model
 *
 */
@Getter
@Setter
@ToString
public class Book implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	
	
}
