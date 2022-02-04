package com.github.fabriciolfj.springsqs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageSender {

    private final MessageChannel messageChannel;
    private final ObjectMapper objectMapper;

    public void send(final Person person) {
        try {
            var json = objectMapper.writeValueAsString(person);
            var payload = MessageBuilder.withPayload(json)
                    .setHeader("send", "app")
                    .build();

            messageChannel.send(payload);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
