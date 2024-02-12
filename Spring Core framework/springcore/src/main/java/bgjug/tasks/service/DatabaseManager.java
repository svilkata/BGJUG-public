package bgjug.tasks.service;

@org.springframework.stereotype.Component
public class DatabaseManager {

    @org.springframework.beans.factory.annotation.Autowired
    private bg.jug.academy.string.demo.model.PersistenceService persistenceService;

    public void execute(){
        persistenceService.execute();
    }
}
