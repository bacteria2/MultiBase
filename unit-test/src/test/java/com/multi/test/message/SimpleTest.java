package com.multi.test.message;


import com.multi.test.BaseTest;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * @author shepard.xia
 * @date 2017年03月28日
 * @description input useage
 */
public class SimpleTest extends BaseTest {

    @Autowired
    KafkaProducer<String, String> producer;

    @Autowired
    KafkaConsumer<String, String> consumer;

    private CountDownLatch latch = new CountDownLatch(1);


    @Test
    public void producerTest() {
        ExecutorService service = Executors.newSingleThreadExecutor();


        consumer.subscribe(Arrays.asList("test01"));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records)
                System.out.println(String.format("offset = %d, key = %s, value = %s\n", record.offset(), record.key(), record.value()));

        }
    }

    @Test
    public void setProducer() {
        for (int i = 0; i < 99; i++) {
            producer.send(new ProducerRecord<>("test01", "testMsg" + i));
        }
        System.out.println("done");
    }


}