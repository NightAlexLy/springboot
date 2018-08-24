package xin.rtime.validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import xin.rtime.validator.annotation.DateTime;

/**
 * 
 *  Chapter18 自定义校验器
 *
 */
public class DateTimeValidator implements ConstraintValidator<DateTime, String> {

	private DateTime dateTime;

	@Override
	public void initialize(DateTime dateTime) {
		this.dateTime = dateTime;
	}

	/**
	 *  如果 value 为空则不进行格式验证，为空验证可以使用 @NotBlank
	 *   @NotNull @NotEmpty 等注解来进行控制，职责分离
	 */
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		if (value == null) {
			return true;
		}
		String format = dateTime.format();
		if (value.length() != format.length()) {
			return false;
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		try {
			simpleDateFormat.parse(value);
		} catch (ParseException e) {
			return false;
		}
		return true;
	}

}
