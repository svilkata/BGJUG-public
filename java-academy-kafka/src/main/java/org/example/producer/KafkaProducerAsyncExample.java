package org.example.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class KafkaProducerAsyncExample {
    public static void main(String[] args) {
        // Kafka broker address. Replace 'localhost:9092' with your Kafka broker's address.
        String bootstrapServers = "localhost:29092";

        // Kafka topic to which messages will be sent. Replace 'your_topic' with your desired topic name.
        String topic = "your_topic";

        // Create Kafka producer configuration
        Properties properties = new Properties();
        properties.put("bootstrap.servers", bootstrapServers);
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        // Create Kafka producer instance
        Producer<String, String> producer = new KafkaProducer<>(properties);

        // Produce a message to the specified topic
        String messageToSend = "your_message";
        produceMessage(producer, topic, messageToSend);

        // Close the producer to release resources
        producer.close();
    }

    private static void produceMessage(Producer<String, String> producer, String topic, String message) {
        try {
            // Produce message to the topic
            producer.send(new ProducerRecord<>(topic, message), (metadata, exception) -> {
                if (exception == null) {
                    System.out.println("Message sent successfully - Topic: " +
                            metadata.topic() + ", Partition: " + metadata.partition() +
                            ", Offset: " + metadata.offset());
                } else {
                    System.err.println("Error sending message: " + exception.getMessage());
                }
            });
            System.out.println("Produced message: " + message);

        } catch (Exception e) {
            System.err.println("Error producing message: " + e.getMessage());
        }
    }
}
