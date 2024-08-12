package org.example.consumer;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Collection;
import java.util.Collections;
import java.util.Properties;

public class KafkaConsumerHandleRebalanceExample {

    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerHandleRebalanceExample.class);

    public static void main(String[] args) {
        // Kafka broker address. Replace 'localhost:9092' with your Kafka broker's address.
        String bootstrapServers = "localhost:29092";

        // Kafka topic from which messages will be consumed. Replace 'your_topic' with your desired topic name.
        String topic = "your_topic";

        // Create Kafka consumer configuration
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "your_group_id"); // Set a unique group ID for the consumer
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());

        // Create Kafka consumer instance
        Consumer<String, String> consumer = new KafkaConsumer<>(properties);

        // Subscribe to the topic
        consumer.subscribe(Collections.singletonList(topic), new HandleRebalance() );

        // Poll for messages
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));

            records.forEach(record -> {
                logger.info("Consumed message - Topic: {}, Partition: {}, Offset: {}, Key: {}, Value: {}",
                        record.topic(), record.partition(), record.offset(), record.key(), record.value());
            });
        }
    }
}

class HandleRebalance implements ConsumerRebalanceListener {

    private static final Logger logger = LoggerFactory.getLogger(HandleRebalance.class);

    @Override
    public void onPartitionsRevoked(Collection<TopicPartition> partitions) {
        logger.info("Partitions Revoked {}", partitions.toString());
    }

    @Override
    public void onPartitionsAssigned(Collection<TopicPartition> partitions) {
        logger.info("Partitions Assigned {}", partitions.toString());
    }

    @Override
    public void onPartitionsLost(Collection<TopicPartition> partitions) {
        logger.info("Partitions Lost {}", partitions.toString());
    }
}