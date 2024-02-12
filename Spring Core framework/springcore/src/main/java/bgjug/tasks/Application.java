package bgjug.tasks;


import bgjug.tasks.config.DatabaseConfiguration;
import org.example.service.PersistenceManager;
import org.example.service.WebServicePersistenceManager;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {


        org.springframework.context.annotation.AnnotationConfigApplicationContext context =
                new org.springframework.context.annotation.AnnotationConfigApplicationContext(DatabaseConfiguration.class);
        context.getBean(bg.jug.academy.string.demo.model.DatabaseManager.class);

//        createApplicationUsingAnnotationContext(args);
    }

    private static void createApplicationUsingAnnotationContext(String[] args) {
        String location = args[0]; // db, file
        String message = args[1];

//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("org.example");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class.getPackage().getName());
        PersistenceManager manager = context.getBean(location, PersistenceManager.class);
        PersistenceManager manager2 = context.getBean(location, PersistenceManager.class);
        manager.save(message);

        context.getBean(WebServicePersistenceManager.class);

        BeanDefinition definition = context.getBeanFactory().getBeanDefinition(location);
        System.out.println(definition);
        System.out.println(System.identityHashCode(manager)); //връща id-то на обекта от Java HEAP паметта
        System.out.println(System.identityHashCode(manager2));

        manager.save(message);

        context.close();
    }
}
