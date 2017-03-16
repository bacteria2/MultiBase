package com.shepard.controller;

import com.google.common.collect.ImmutableMap;
import com.shepard.service.MockType;
import org.dom4j.Document;
import org.dom4j.Element;
import org.springframework.cglib.beans.ImmutableBean;
import org.springframework.stereotype.Controller;
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





}
