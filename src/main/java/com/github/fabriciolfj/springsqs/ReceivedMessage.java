package com.github.fabriciolfj.springsqs;

import io.awspring.cloud.messaging.listener.SqsMessageDeletionPolicy;
import io.awspring.cloud.messaging.listener.annotation.SqsListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ReceivedMessage {

    @SqsListener(value = "test", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void receiveMessage(String msg) {
        log.info("Received: {}", msg);
    }
}
