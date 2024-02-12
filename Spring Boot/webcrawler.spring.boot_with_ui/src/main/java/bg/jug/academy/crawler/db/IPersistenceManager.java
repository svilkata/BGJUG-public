package bg.jug.academy.crawler.db;

public interface IPersistenceManager {

	void init();
	
	void executeUpdate(String query);
	
}
