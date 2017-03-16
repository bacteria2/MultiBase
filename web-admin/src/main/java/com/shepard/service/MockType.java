package com.shepard.service;

import com.google.common.base.Utf8;
import com.google.common.io.ByteSource;
import com.google.common.io.CharSource;
import com.google.common.io.Files;
import com.sun.xml.internal.stream.writers.XMLOutputSource;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author shepard.xia
 * @date 2017年02月13日
 * @description input useage
 */
public enum MockType {
    SingleManu(new IMockData<ByteSource>() {
        @Override
        public ByteSource mock()  {
            try {
                Path mockDataPath=Paths.get(MockType.class.getClassLoader().getResource("").toURI()).resolve("mockData/single.xml");
                return Files.asByteSource(mockDataPath.toFile());
            } catch (URISyntaxException e) {
                e.printStackTrace();
                return null;
            }
        }
    });

    private IMockData mockData;

    public IMockData getIMockData() {
        return this.mockData;
    }

    MockType(IMockData mockData) {
        this.mockData=mockData;
    }
}
