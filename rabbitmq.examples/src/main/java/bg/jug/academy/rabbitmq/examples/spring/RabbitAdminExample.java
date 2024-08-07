package bg.jug.academy.rabbitmq.examples.spring;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;

public class RabbitAdminExample {
	
	public static void main(String[] args) {
		
		CachingConnectionFactory factory = new CachingConnectionFactory();
		factory.setHost("localhost");
		RabbitAdmin rabbitAdmin = new RabbitAdmin(factory);
		Queue queue = new Queue("rabbit_admin_queue");
		DirectExchange exchange = new DirectExchange("rabbit_admin_exchange");
		rabbitAdmin.declareQueue(queue);
		rabbitAdmin.declareExchange(exchange);
		rabbitAdmin.declareBinding(BindingBuilder.bind(queue).to(exchange)
				.with("test"));
		
//		TopicExchange exchange = new TopicExchange("sample-topic-exchange");
//		admin.declareExchange(exchange);
//		admin.declareBinding(BindingBuilder.bind(queue).to(exchange)
//				.with("sample-key"));

	}
	
}
