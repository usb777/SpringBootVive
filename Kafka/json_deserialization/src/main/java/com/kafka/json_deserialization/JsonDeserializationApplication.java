package com.kafka.json_deserialization;

import com.kafka.json_deserialization.producer.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JsonDeserializationApplication {
	private static final Logger log = LoggerFactory.getLogger(KafkaProducer.class);
	public static void main(String[] args) {
		SpringApplication.run(JsonDeserializationApplication.class, args);
		log.info("Application started");
	}

}
