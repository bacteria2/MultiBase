package com.multi.service;

import com.google.common.io.ByteSource;
import com.google.common.io.Files;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author multi.xia
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
