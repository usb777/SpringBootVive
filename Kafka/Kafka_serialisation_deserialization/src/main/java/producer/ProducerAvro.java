package main.java.producer;

import org.apache.avro.generic.GenericDatumWriter;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.BinaryEncoder;
import org.apache.avro.io.EncoderFactory;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class ProducerAvro {

    public static void main(String[] args) throws IOException {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.ByteArraySerializer");

        KafkaProducer<String, byte[]> producer = new KafkaProducer<>(props);

// Define Avro schema
        Schema avroSchema = new Schema.Parser().parse(new File("src/main/resources/avrik.avsc"));

// Your event object
        GenericRecord avroEvent = new GenericData.Record(avroSchema);
        avroEvent.put("field1", "value134");
        avroEvent.put("field2", 42);

// Serialize the Avro-encoded event
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        BinaryEncoder encoder = EncoderFactory.get().binaryEncoder(baos, null);
        org.apache.avro.io.DatumWriter<GenericRecord> writer = new GenericDatumWriter<>(avroSchema);
        writer.write(avroEvent, encoder);
        encoder.flush();

        ProducerRecord<String, byte[]> avroRecord = new ProducerRecord<>("avro-topic", baos.toByteArray());

// Send the record to Kafka
        producer.send(avroRecord);

// Close the producer when done
        producer.close();
    }
}
