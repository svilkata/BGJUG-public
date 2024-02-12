package bgjug.tasks.config;

@org.springframework.context.annotation.Configuration
public class DatabaseConfiguration {

    @org.springframework.context.annotation.Bean
    bg.jug.academy.string.demo.model.DatabaseManager createBean(){
        return new bg.jug.academy.string.demo.model.DatabaseManager();
    }
}
