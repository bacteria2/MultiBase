package com.multi.message;

import com.multi.message.kafka.SimpleProducerFactory;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import com.multi.message.kafka.SimpleConsumerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author shepard.xia
 * @date 2017年03月28日
 * @description input useage
 */
@Configuration
public class MessageConfiguration {

    @Autowired
    @Qualifier("propertiesFactory")
    private Properties props;


    @Bean
    public KafkaProducer<String,String> kafkaProducer() throws Exception {

        return new SimpleProducerFactory(kafkaPropertiesInit()).getObject();
    }

    @Bean
    public KafkaConsumer<String,String> kafkaConsumer() throws Exception {

        return new SimpleConsumerFactory(kafkaPropertiesInit()).getObject();
    }

    private Map<String, Object> kafkaPropertiesInit(){
        Map<String,Object> kafkaConfig=new HashMap<>();
        kafkaConfig.put("bootstrap.servers",props.get("kafka.bootstrap_servers"));
        kafkaConfig.put("key.serializer",props.get("kafka.key_serializer"));
        kafkaConfig.put("value.serializer",props.get("kafka.value_serializer"));
        kafkaConfig.put("value.deserializer",props.get("kafka.value_deserializer"));
        kafkaConfig.put("key.deserializer",props.get("kafka.key_deserializer"));
        kafkaConfig.put("group.id","consumer-1");
        return kafkaConfig;
    }

}
