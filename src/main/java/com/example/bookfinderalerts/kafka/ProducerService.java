package com.example.bookfinderalerts.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    private static String topic = "books";
    private static Logger logger = LoggerFactory.getLogger(ProducerService.class);

    @Autowired
    private KafkaTemplate<String,Object> template;

    public void sendMessage(String topic,Object message)
    {
        template.send(topic, message);
        logger.info(String.format("### -> Producer sends message -> %s", message));
        logger.info("### Producer sends message [{}]", message);
        template.flush();
    }
}
