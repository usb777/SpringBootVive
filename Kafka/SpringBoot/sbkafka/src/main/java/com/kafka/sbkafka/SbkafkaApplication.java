package com.kafka.sbkafka;

// based on https://www.javaguides.net/2022/05/spring-boot-kafka-producer-consumer-example-tutorial.html

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class SbkafkaApplication {
	static Logger log = Logger.getLogger(SbkafkaApplication.class.getName());
	public static void main(String[] args) {
		log.info("Kafka Project");
		SpringApplication.run(SbkafkaApplication.class, args);
	}

}
