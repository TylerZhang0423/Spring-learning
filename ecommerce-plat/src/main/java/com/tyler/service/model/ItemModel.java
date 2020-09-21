package com.tyler.service.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @ Author     :tyler
 * @ Date       :2020/9/20
 * @ Time       :2:06 下午
 */
@Getter
@Setter
public class ItemModel {
    private Integer id;

    @NotBlank(message = "商品名称不能为空")
    private String title;

    @NotNull(message = "商品价格不能为空")
    @Min(value = 0, message = "商品价格必须大于0")
    private BigDecimal price;

    @NotNull(message = "库存必须填写")
    private Integer stock;

    @NotNull(message = "商品描述不能为空")
    private String description;

    private Integer sales;

    @NotNull(message = "商品图片信息不能为空")
    private String imgUrl;
}
