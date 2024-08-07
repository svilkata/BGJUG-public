package bg.jug.academy.rabbitmq.examples.spring;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;

public class RabbitLIstenerExample {

	public static void main(String[] args) {

		CachingConnectionFactory factory = new CachingConnectionFactory();
		factory.setHost("localhost");

		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(factory);
		Object listener = new Object() {
			public void handleMessage(String message) {
				System.out.println("Message received: " + message);
			}
		};
		MessageListenerAdapter adapter = new MessageListenerAdapter(listener);
		container.setMessageListener(adapter);
		container.setQueueNames("rabbit_admin_queue", "test");
		container.start();

	}

}
