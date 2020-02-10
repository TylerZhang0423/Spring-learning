package com.ecommerceproject.controller;

import com.alibaba.druid.sql.ast.expr.SQLCaseExpr;
import com.ecommerceproject.controller.viewobject.ItemVO;
import com.ecommerceproject.error.BusinessException;
import com.ecommerceproject.response.CommonReturnType;
import com.ecommerceproject.service.ItemService;
import com.ecommerceproject.service.model.ItemModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Controller("/item")
@RequestMapping("/item")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class ItemController extends BaseController{

    @Autowired
    private ItemService itemService;

    //创建商品的controller
    @RequestMapping(value = "/create", method = {RequestMethod.POST}, consumes = {CONTENT_TYPE_FORMED})
    @ResponseBody
    public CommonReturnType createItem (@RequestParam(name = "title") String title,
                                        @RequestParam(name = "description") String description,
                                        @RequestParam(name = "price") BigDecimal price,
                                        @RequestParam(name = "stock") Integer stock,
                                        @RequestParam(name = "imgUrl") String imgUrl) throws BusinessException {
        //封装service请求用来创建商品
        ItemModel itemModel = new ItemModel();
        itemModel.setTitle(title);
        itemModel.setDescription(description);
        itemModel.setPrice(price);
        itemModel.setStock(stock);
        itemModel.setImgUrl(imgUrl);

        ItemModel itemModelForReturn = itemService.createItem(itemModel);
        ItemVO itemVO = convertVOFromModel(itemModelForReturn);

        return CommonReturnType.create(itemVO);
    }


    //商品详情页浏览
    @RequestMapping(value = "/get", method = {RequestMethod.GET})
    @ResponseBody
    public CommonReturnType getItem(@RequestParam(name = "id") Integer id) {
        ItemModel itemModel = itemService.getItemById(id);

        ItemVO itemVO = convertVOFromModel(itemModel);

        return CommonReturnType.create(itemVO);
    }


    private ItemVO convertVOFromModel(ItemModel itemModel) {
        if (itemModel==null) {
            return null;
        }
        ItemVO itemVO = new ItemVO();
        BeanUtils.copyProperties(itemModel, itemVO);
        return itemVO;
    }
}
