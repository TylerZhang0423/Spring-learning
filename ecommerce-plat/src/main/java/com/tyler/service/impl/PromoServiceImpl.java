package com.tyler.service.impl;

import com.tyler.dao.PromoDOMapper;
import com.tyler.dataobject.PromoDO;
import com.tyler.service.PromoService;
import com.tyler.service.model.PromoModel;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @ Author     :tyler
 * @ Date       :2020/9/26
 * @ Time       :9:25 下午
 */
@Service
public class PromoServiceImpl implements PromoService {

    @Autowired
    PromoDOMapper promoDOMapper;

    @Override
    public PromoModel getPromoByItemId(Integer itemId) {
        //获取对应商品的秒杀活动信息
        PromoDO promoDO = promoDOMapper.selectByItemId(itemId);

        //将Do转换成Model
        PromoModel promoModel = convertFromPromoDo(promoDO);

        //如果promoModel为null，没有该商品的秒杀活动
        if(promoModel==null){
            return null;
        }

        //判断当前时间和秒杀开始时间的关系
        //开始时间在当前时间之后
        if(promoModel.getStartTime().isAfterNow()){
            //秒杀还未开始
            promoModel.setStatus(1);
            System.out.println("status : " + promoModel.getStatus());
        }else if(promoModel.getEndTime().isBeforeNow()){
            //秒杀已经结束
            promoModel.setStatus(3);
            System.out.println("status : " + promoModel.getStatus());
        }else{
            //秒杀正在进行
            promoModel.setStatus(2);
            System.out.println("status : " + promoModel.getStatus());
        }



        return promoModel;
    }

    private PromoModel convertFromPromoDo(PromoDO promoDO){

        if(promoDO ==null){
            return null;
        }

        PromoModel promoModel = new PromoModel();
        BeanUtils.copyProperties(promoDO,promoModel);
        //单独这是价格的
        promoModel.setPromoItemPrice(new BigDecimal(promoDO.getPromoItemPrice()));
        //单独设置时间，mysql是sql.date,model是joda-date
        promoModel.setStartTime(new DateTime(promoDO.getStartTime()));
        promoModel.setEndTime(new DateTime(promoDO.getEndTime()));

        return promoModel;

    }
}
