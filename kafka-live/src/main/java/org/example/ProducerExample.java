package org.example;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class ProducerExample {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:29092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization");
        properties.put("value.serializer", "org.apache.kafka.common.serialization");

        Producer<String, String> producer = new KafkaProducer<>(properties);

        producer.send(new ProducerRecord<>("bgjug", "KafkaKey", "Welcome to Kafka"));
        producer.close();
    }
}