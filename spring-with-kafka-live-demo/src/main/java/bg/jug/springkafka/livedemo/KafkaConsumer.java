package bg.jug.springkafka.livedemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaConsumer {

//    @KafkaListener(topics = "welcometokafka", groupId = "application", concurrency = "3")
//    @KafkaListener(topics = "welcometokafka", groupId = "application")
    @KafkaListener(id = "bgjug", topics = "welcometokafka", groupId = "application", autoStartup = "false")
    public void listen(String data) {
        log.info(data);
    }
}
