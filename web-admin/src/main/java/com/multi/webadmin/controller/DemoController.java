package com.multi.webadmin.controller;


import com.google.common.collect.ImmutableMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by IonCannon on 2016/11/19.
 */
@RestController
public class DemoController {
    @RequestMapping("show")
    public Map demoShow() {
        return ImmutableMap.of("test1","1","test2","2");
    }


    @RequestMapping("index")
    public String index() {
        return "{\"path\":\"index\"}";
    }



}
