package xin.rtime.actuator.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * 
 * Chapter13 自定义健康端点
 *
 */
@Component("MyHealthIndicator1")
public class MyHealthIndicator implements HealthIndicator {

	private static final String VERSION = "v1.0.0";

	@Override
	public Health health() {
		int code = check();
		if (code != 0) {
			Health.down().withDetail("code", code).withDetail("version", VERSION).build();
		}
		return Health.up().withDetail("code", code).withDetail("version", VERSION).up().build();
	}

	private int check() {
		return 0;
	}
}
