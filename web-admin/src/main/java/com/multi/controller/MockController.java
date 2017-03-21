package com.multi.controller;

import com.google.common.io.ByteSource;
import com.multi.service.MockType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author multi.xia
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
