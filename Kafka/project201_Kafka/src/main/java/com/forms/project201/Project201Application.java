package com.forms.project201;

import java.util.Properties;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Project201Application {

	public static void main(String[] args) {
		
		String boostrapServers="127.0.0.1:9092";
		Properties props = new Properties();
		props.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,boostrapServers);
		props.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, io.confluent.kafka.serializers.KafkaAvroSerializer.class);
		props.put("schema.registry.url", "http://localhost:8080");
		KafkaProducer producer = new KafkaProducer(props);

		String key = "key1";
		String userSchema = "{\"type\":\"record\"," +
		                    "\"name\":\"myrecord\"," +
		                    "\"fields\":[{\"name\":\"f1\",\"type\":\"string\"}]}";
		Schema.Parser parser = new Schema.Parser();
		Schema schema = parser.parse(userSchema);
		GenericRecord avroRecord = new GenericData.Record(schema);
		avroRecord.put("f1", "value1");

		ProducerRecord<Object, Object> record = new ProducerRecord<>("topic1", key, avroRecord);
		try {
		  producer.send(record);
		  System.out.println("Record: "+record);
		} catch(SerializationException e) {
		  System.out.println("Error is serialization:"+e.getMessage()+" reson:"+e.getCause());
		}
		
		// When you're finished producing records, you can flush the producer to ensure it has all been written to Kafka and
		// then close the producer to free its resources.
		finally {
		  producer.flush();
		  producer.close();
		}
		
		SpringApplication.run(Project201Application.class, args);
	}

}
