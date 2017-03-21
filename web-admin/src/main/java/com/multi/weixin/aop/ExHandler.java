package com.multi.weixin.aop;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author multi.xia
 * @date 2016年12月09日
 * @description input useage
 */
@ControllerAdvice(basePackages = "com.multi.weixin" )
public class ExHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handler(Exception e){
        return "{\"error\":\"error\",\"msg\":\""+e.getLocalizedMessage()+"\"}";
    }
    @InitBinder
    public void binder(){

    }

    @ModelAttribute
    public void model(){

    }

}
