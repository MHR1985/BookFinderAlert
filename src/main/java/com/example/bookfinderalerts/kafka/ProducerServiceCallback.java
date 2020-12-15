package com.example.bookfinderalerts.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class ProducerServiceCallback {

    private static String topic = "books";
    private static Logger logger = LoggerFactory.getLogger(ProducerService.class);

    @Autowired
    private KafkaTemplate<String,Object> template;

    public void sendMessageCallBack(String topic, Object message)
    {
        ListenableFuture<SendResult<String, Object>> future = template.send(topic, message);

        future.addCallback(new ListenableFutureCallback<SendResult<String, Object>>()
        {
            @Override
            public void onSuccess(SendResult<String, Object> result)
            {
                logger.info("### Producer sends message [{}]", message);
                logger.info("$$$ Message [{}] delivered to partition [{}] with offset [{}]",
                        message, result.getRecordMetadata().partition(), result.getRecordMetadata().offset());
            }

            @Override
            public void onFailure(Throwable ex)
            {
                logger.warn("$$$ Unable to deliver message [{}], with exception {}", message, ex.getMessage());
            }
        });
    }

}
