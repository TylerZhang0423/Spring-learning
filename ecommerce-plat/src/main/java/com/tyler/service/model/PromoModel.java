package com.tyler.service.model;

import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;

import java.math.BigDecimal;

/**
 * @ Author     :tyler
 * @ Date       :2020/9/26
 * @ Time       :9:09 下午
 */
@Getter
@Setter
public class PromoModel {
    //id
    private Integer id;

    //秒杀活动状态 1 还未开始 2 进行中 3 已经结束
    private Integer status;


    //秒杀活动名称
    private String promoName;

    //秒杀活动开始时间
    //使用joda-time针对时间日期处理的库
    private DateTime startTime;

    //秒杀活动结束时间
    //使用joda-time针对时间日期处理的库
    private DateTime endTime;

    //秒杀活动的适用商品
    private Integer itemId;

    //秒杀活动的商品价格
    private BigDecimal promoItemPrice;
}
