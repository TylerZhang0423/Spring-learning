package com.tyler.service.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @ Author     :tyler
 * @ Date       :2020/9/21
 * @ Time       :10:22 下午
 */
@Getter
@Setter
public class OrderModel {
    //String类型的交易号（订单号）
    //201812023349823723 一般可以以时间开头，后面每一位都有特殊含义
    private String id;


    //用户id，哪个用户下的单
    private Integer userId;

    //商品id，买的哪个商品
    private Integer itemId;

    //购买的数量
    private Integer amount;

    //购买的金额（商品下单时的单价X数量）
    //商品的价格是浮动的，后期价格会改变，但创建订单时的价格是不随后期实际价格改变的
    //因此这里需要一个额外字段，存下单时的价格，即使后期实际价格变化，查询这个订单时，价格是当时的价格
    //若promoId非空，则是秒杀时订单金额
    private BigDecimal orderPrice;

    //创建订单时商品的单价，如果promoId非空，则是秒杀单价
    private BigDecimal itemPrice;

    //若非空，则表示以秒杀方式下单
    private Integer promoId;


}
