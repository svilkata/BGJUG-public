package org.example;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class Publisher {
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = null;
        Channel channel = null;

        try {
            ConnectionFactory connectionFactory = new ConnectionFactory();
            connectionFactory.setHost("localhost"); //by default on port 15672
            connection = connectionFactory.newConnection();
            channel = connection.createChannel();

            channel.exchangeDeclare("name_exchange", "direct"); //created only once on the RabbitMQ server
            channel.queueDeclare("name_queue", false, false, false, null);
            channel.queueBind("name_queue", "name_exchange", "routing_key_test");

            channel.basicPublish("name_exchange", "routing_key_test", null,
                    "Hello RabbitMQ from Java client".getBytes(StandardCharsets.UTF_8));
        } finally {
            if (channel != null) {
                channel.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
