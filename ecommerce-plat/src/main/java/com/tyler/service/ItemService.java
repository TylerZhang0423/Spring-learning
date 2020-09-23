package com.tyler.service;

import com.tyler.error.BusinessException;
import com.tyler.service.model.ItemModel;

import java.util.List;

/**
 * @ Author     :tyler
 * @ Date       :2020/9/20
 * @ Time       :4:49 下午
 */
public interface ItemService {
    //创建商品
    ItemModel createItem(ItemModel itemModel) throws BusinessException;

    //商品列表浏览
    List<ItemModel> listItem();

    //商品详情浏览
    ItemModel getItemById(Integer id);

    //库存扣减
    boolean decreaseStock(Integer itemId, Integer amount) throws BusinessException;

    //销量增加
    void increaseSales(Integer itemId, Integer amount) throws BusinessException;
}
