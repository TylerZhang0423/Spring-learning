package com.tyler.service;

import com.tyler.service.model.PromoModel;

/**
 * @ Author     :tyler
 * @ Date       :2020/9/26
 * @ Time       :9:25 下午
 */
public interface PromoService {
    //根据商品id获取该商品秒杀信息
    PromoModel getPromoByItemId(Integer itemId);

}
