package bg.jug.academy.rabbitmq.examples.spring;

import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RabbitAdminSpringExample {

	public static void main(String[] args) {

		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"configuration.xml");
		RabbitAdmin admin = context.getBean(RabbitAdmin.class);
	}

}
