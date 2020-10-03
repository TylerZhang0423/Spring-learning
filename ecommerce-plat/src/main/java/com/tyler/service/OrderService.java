package com.tyler.service;

import com.tyler.error.BusinessException;
import com.tyler.service.model.OrderModel;

/**
 * @ Author     :tyler
 * @ Date       :2020/9/23
 * @ Time       :7:12 下午
 */
public interface OrderService {
    OrderModel createOrder(Integer userId, Integer itemId, Integer promoId, Integer amount) throws BusinessException;
}
