package com.shepard.controller;

import com.google.common.io.ByteSource;
import com.shepard.service.MockType;
import com.sun.deploy.net.HttpResponse;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author shepard.xia
 * @date 2017年02月13日
 * @description input useage
 */
@Controller
public class MockController {
    @RequestMapping(value = "singleManu4search",produces = "text/xml")
    public void singleManu4search(HttpServletResponse response) throws IOException {
        ByteSource byteSource=(ByteSource)MockType.SingleManu.getIMockData().mock();
        byteSource.copyTo(response.getOutputStream());
    }
}
