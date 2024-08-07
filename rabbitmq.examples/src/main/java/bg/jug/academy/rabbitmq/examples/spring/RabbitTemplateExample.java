package bg.jug.academy.rabbitmq.examples.spring;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class RabbitTemplateExample {

	public static void main(String[] args) {

		CachingConnectionFactory factory = new CachingConnectionFactory();
		factory.setHost("localhost");
		RabbitTemplate template = new RabbitTemplate(factory);
		template.convertAndSend("rabbit_admin_exchange", "test", 
				"Message from RabbitTemplate instance !");
	}
	
}
