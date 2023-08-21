package com.kafka.json_deserialization.consumer;


import com.kafka.json_deserialization.payload.User;

import com.kafka.json_deserialization.utils.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafKaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafKaConsumer.class);

    @KafkaListener(topics = AppConstants.TOPIC_NAME,
            groupId = AppConstants.GROUP_ID)
    public void consume(User data){
        LOGGER.info(String.format("Message received -> %s", data.toString()));
    }
}