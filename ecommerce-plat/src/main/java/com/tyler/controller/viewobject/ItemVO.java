package com.tyler.controller.viewobject;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * @ Author     :tyler
 * @ Date       :2020/9/20
 * @ Time       :10:27 下午
 */
@Getter
@Setter
@ToString
public class ItemVO {
    private Integer id;

    private String title;

    private BigDecimal price;

    private Integer stock;

    private String description;

    private Integer sales;

    private String imgUrl;

    //记录商品的秒杀状态，0：没有秒杀活动，1：秒杀活动待开始，2：秒杀活动正在进行
    private Integer promoStatus;

    //秒杀活动价格
    private BigDecimal promoPrice;

    //秒杀活动id
    private Integer promoId;

    //秒杀活动开始时间，进行倒计时展示等
    private String startTime;
}
