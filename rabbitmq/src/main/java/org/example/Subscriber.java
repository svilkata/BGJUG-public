package org.example;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Subscriber {
    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
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

            while (true) {
                channel.basicConsume("name_queue", true, new DefaultConsumer(channel) {
                    @Override
                    public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                        // super.handleDelivery(consumerTag, envelope, properties, body);  no-op no work to do
                        System.out.println(new String(body));
                    }
                });

                Thread.sleep(3000);
            }
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
