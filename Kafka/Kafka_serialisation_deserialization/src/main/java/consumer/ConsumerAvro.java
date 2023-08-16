package main.java.consumer;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.io.BinaryDecoder;
import org.apache.avro.io.DecoderFactory;
import java.util.logging.Logger;


public class ConsumerAvro {
    static Logger log = Logger.getLogger(ConsumerAvro.class.getName());

    public static void main(String[] args) throws IOException {
        log.info("Hello world");
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.ByteArrayDeserializer");
        props.put("group.id", "your-group");

        Consumer<String, byte[]> consumer = new KafkaConsumer<>(props);

// Subscribe to the topic
        consumer.subscribe(Collections.singletonList("avro-topic"));
        Schema avroSchema = new Schema.Parser().parse(new File("src/main/resources/avrik.avsc"));
        while (true) {
            ConsumerRecords<String, byte[]> records = consumer.poll(Duration.ofMillis(100));

            // Process received records
            for (ConsumerRecord<String, byte[]> record : records) {
                byte[] avroBytes = record.value();

                // Deserialize Avro-encoded byte array
                BinaryDecoder decoder = DecoderFactory.get().binaryDecoder(avroBytes, null);
                GenericDatumReader<GenericRecord> reader = new GenericDatumReader<>(avroSchema);
                GenericRecord avroEvent = reader.read(null, decoder);

                // Process the avroEvent
                String field1Value = avroEvent.get("field1").toString();
                int field2Value = (int) avroEvent.get("field2");
                // Process the fields as needed
                System.out.println("VAlue = "+field1Value);
                System.out.println("VAlue = "+field2Value);
            }
        }
// Close the consumer when done

    }
}
