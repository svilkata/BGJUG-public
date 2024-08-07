package bg.jug.academy.rabbitmq.examples;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Publisher {

	public static void main(String[] args) throws IOException, TimeoutException {
		
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
			
			channel.basicPublish("example_exchange", "test", null, 
					"Hello RabbitMQ from Java client (second run) !".getBytes(Charset.forName("UTF-8")));
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
