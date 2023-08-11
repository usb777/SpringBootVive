import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class Producer1 {

	public static void main(String[] args) {
		
		System.out.println("Hello Kafkych!");
		String boostrapServers="127.0.0.1:9092";
		Properties props = new Properties();
		props.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,boostrapServers);
		props.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
		props.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
		
		KafkaProducer<String, String> first_producer = new KafkaProducer<String, String>(props);
		ProducerRecord<String,String> record = new ProducerRecord<String,String>("dzen_topic","hreno-Kafka777");
		
		first_producer.send(record);
		first_producer.flush();
		first_producer.close();
		
	}

}
