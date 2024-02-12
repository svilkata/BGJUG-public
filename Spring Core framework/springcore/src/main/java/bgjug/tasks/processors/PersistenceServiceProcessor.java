package bgjug.tasks.processors;

@org.springframework.stereotype.Component
public class PersistenceServiceProcessor implements org.springframework.beans.factory.config.BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws org.springframework.beans.BeansException {

        System.out.println("persistence bean initialized");

        return org.springframework.beans.factory.config.BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
