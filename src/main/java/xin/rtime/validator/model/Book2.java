package xin.rtime.validator.model;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import xin.rtime.validator.annotation.model.Groups;

/**
 * 
 * Chapter18 分组校验
 *
 */
public class Book2 {

	@NotNull(message = "id 不能为空", groups = Groups.Update.class)
    private Integer id;
    @NotBlank(message = "name 不允许为空", groups = Groups.Default.class)
    private String name;
    @NotNull(message = "price 不允许为空", groups = Groups.Default.class)
    private BigDecimal price;
}
