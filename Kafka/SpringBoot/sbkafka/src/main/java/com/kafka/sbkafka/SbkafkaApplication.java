package com.kafka.sbkafka;

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
