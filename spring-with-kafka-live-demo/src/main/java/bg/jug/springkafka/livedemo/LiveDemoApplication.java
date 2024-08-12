package bg.jug.springkafka.livedemo;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
@RequiredArgsConstructor
public class LiveDemoApplication implements CommandLineRunner {

	private final KafkaTemplate<String, String> kafkaTemplate; //injecting it

	private final KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry; //injecting it

	public static void main(String[] args) {
		SpringApplication.run(LiveDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		for (int i = 0; i < 25_000_000; i++) {
//			kafkaTemplate.send("welcometokafka", "When is next Java beer in Plovdiv?");
//		}
		kafkaListenerEndpointRegistry.getListenerContainer("bgjug").start();
	}
}
