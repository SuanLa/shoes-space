package com.shoes.products.controller;//package com.shoes.products.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.apache.rocketmq.common.message.Message;
//import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
//import org.apache.rocketmq.spring.core.RocketMQListener;
//import org.springframework.stereotype.Component;
//
//@Component
//@RocketMQMessageListener(topic = "product-topic", consumerGroup = "my-consumer-group")
//public class RocketMQConsumer implements RocketMQListener<Message> {
//    ObjectMapper objectMapper = new ObjectMapper();
//
//    @Override
//    public void onMessage(Message message) {
//        // 处理接收到的消息
//        System.out.println("Received message: " + message);
//
//
//    }
//}
