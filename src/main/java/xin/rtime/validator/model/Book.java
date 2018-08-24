package xin.rtime.validator.model;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Book {

    private Integer id;
    @NotBlank(message = "name 不允许为空")
    @Length(min = 2, max = 10, message = "name 长度必须在 {min} - {max} 之间")
    private String name;
    @NotNull(message = "price 不允许为空")
    @DecimalMin(value = "0.1", message = "价格不能低于 {value}")
    private BigDecimal price;
    
}
