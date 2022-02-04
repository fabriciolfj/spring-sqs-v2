package com.github.fabriciolfj.springsqs;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import io.awspring.cloud.messaging.core.QueueMessageChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.MessageChannel;

@SpringBootApplication
public class SpringSqsApplication {

	private static final String QUEUE = "https://sqs.us-east-2.amazonaws.com/882275682131/test";

	@Autowired
	private AmazonSQSAsync amazonSQSAsync;

	@Bean
	public MessageChannel messageChannel() {
		return new QueueMessageChannel(amazonSQSAsync, QUEUE);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringSqsApplication.class, args);
	}

}
