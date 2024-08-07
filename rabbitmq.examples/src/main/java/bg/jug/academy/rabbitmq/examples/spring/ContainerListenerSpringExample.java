package bg.jug.academy.rabbitmq.examples.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContainerListenerSpringExample {

	public void receiveMessage(String message) {
		System.out.println("Message received: " + message);
	}
	
	public static void main(String[] args) {
		AbstractApplicationContext context =
		        new ClassPathXmlApplicationContext("configuration.xml");
	}
}
