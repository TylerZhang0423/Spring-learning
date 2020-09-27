package com.tyler.controller;

import com.tyler.error.BusinessException;
import com.tyler.error.EmBusinessError;
import com.tyler.response.CommonReturnType;
import com.tyler.service.OrderService;
import com.tyler.service.model.UserModel;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @ Author     :tyler
 * @ Date       :2020/9/23
 * @ Time       :9:14 下午
 */
@Controller("order")
@RequestMapping("/order")
@CrossOrigin(origins = {"*"},allowCredentials = "true")
public class OrderController extends BaseController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private HttpServletRequest httpServletRequest;

    private static Logger LOGGER = Logger.getLogger(OrderController.class);


    //封装下单请求，接收商品id和数量
    @RequestMapping(value = "/createorder",method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType createOrder(@RequestParam(name = "itemId") Integer itemId,
                                        @RequestParam(name = "amount") Integer amount,
                                        @RequestParam(name = "promoId",required = false) Integer promoId) throws BusinessException {

        //从session中拿出登录标记
        Boolean isLogin = (Boolean) httpServletRequest.getSession().getAttribute("IS_LOGIN");

        if(isLogin==null || !isLogin.booleanValue()){
            throw new BusinessException(EmBusinessError.USER_NOT_LOGIN);
        }

        //获取用户登录信息
        UserModel userModel = (UserModel) httpServletRequest.getSession().getAttribute("LOGIN_USER");
        LOGGER.info("userModel : " + userModel.toString());

        orderService.createOrder(userModel.getId(), itemId, amount);

        return CommonReturnType.create(null);

    }

}
