package xin.rtime.prop;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:my2.properties")
@ConfigurationProperties(prefix = "my2")
public class MyProperties2 {

	private int age;
	private String name;
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MyProperties2 [age=");
		builder.append(age);
		builder.append(", name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}
}
