package com.multi.message.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.beans.factory.FactoryBean;

import java.util.Map;

/**
 * @author shepard.xia
 * @date 2017年03月28日
 * @description input useage
 */
public class SimpleProducerFactory implements FactoryBean<KafkaProducer<String, String>> {

    private Map<String, Object> prop;


    public SimpleProducerFactory(Map<String, Object> prop) {
        this.prop = prop;
    }

    @Override
    public KafkaProducer<String, String> getObject() throws Exception {
        return new KafkaProducer<>(prop);
    }

    @Override
    public Class<?> getObjectType() {
        return KafkaProducer.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
