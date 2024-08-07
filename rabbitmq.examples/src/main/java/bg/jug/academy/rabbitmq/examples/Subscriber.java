package bg.jug.academy.rabbitmq.examples;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;
import com.rabbitmq.client.AMQP.BasicProperties;

public class Subscriber {

	public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
		
		Connection connection = null;
		Channel channel = null;
		
		try {
			ConnectionFactory connectionFactory = new ConnectionFactory();
			connectionFactory.setHost("localhost");
			connection = connectionFactory.newConnection();
			channel = connection.createChannel();
			
//			channel.exchangeDeclare("example_exchange", "direct");
			channel.queueDeclare("example_queue", false, false, false, null);
			channel.queueBind("example_queue", "example_exchange", "test");
			
			while(true) {
				channel.basicConsume("example_queue", true, new DefaultConsumer(channel) {
					@Override
					public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties,
							byte[] body) throws IOException {
						System.out.println(new String(body));
					}
				});
				Thread.sleep(3000);
			}
		} finally {
			if(channel != null) {
				channel.close();
			}
			if(connection != null) {
				connection.close();
			}
		}
		
	}
	
}
