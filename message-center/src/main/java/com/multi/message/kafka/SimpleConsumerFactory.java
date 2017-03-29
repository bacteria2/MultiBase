package com.multi.message.kafka;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.beans.factory.FactoryBean;

import java.util.Map;

/**
 * @author shepard.xia
 * @date 2017年03月28日
 * @description input useage
 */
public class SimpleConsumerFactory implements FactoryBean<KafkaConsumer<String, String>> {

    private Map<String, Object> prop;


    public SimpleConsumerFactory(Map<String, Object> prop) {
        this.prop = prop;
    }

    @Override
    public KafkaConsumer<String, String> getObject() throws Exception {
        return new KafkaConsumer<>(prop);
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
