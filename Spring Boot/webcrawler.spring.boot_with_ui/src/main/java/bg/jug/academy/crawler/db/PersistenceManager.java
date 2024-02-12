package bg.jug.academy.crawler.db;

import bg.jug.academy.crawler.ApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.lang.reflect.Field;
import java.util.Base64;
import java.util.logging.Logger;

public class PersistenceManager implements IPersistenceManager
	/* ,InitializingBean, DisposableBean */ {
	
	private static final Logger LOGGER = Logger.getLogger(PersistenceManager.class.getName());
	
	@Autowired
	private ApplicationProperties properties;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@PostConstruct
	public void init() {
		LOGGER.info("Initializing database ...");
	}
	
	@PreDestroy
	public void destroy() {
		LOGGER.info("Closing connection to database ...");
	}
	
	public void executeUpdate(String query) {
		jdbcTemplate.update(query);
	}
	
	public static String generateInsertQuery(Object entity) throws IllegalArgumentException, IllegalAccessException {
		
		String table = entity.getClass().getSimpleName().toLowerCase();
		
		StringBuilder query = new StringBuilder("insert into ");
		query.append(table).append("(");

		Field[] fields = entity.getClass().getDeclaredFields();
		for(int index = 0; index < fields.length; index++) {
			Field field = fields[index];
			field.setAccessible(true);
			if(!"id".equals(field.getName())) {
				query.append(field.getName());
				if(index != fields.length - 1) {
					query.append(",");
				}
			}
		}
		query.append(") values (");
		
		for(int index = 0; index < fields.length; index++) {
			Field field = fields[index];
			if(!"id".equals(field.getName())) {
				if(field.get(entity) == null) {
					query.append("NULL");
				} else {
					if("html".equals(field.getName())) {
						
						String value = Base64.getEncoder().encodeToString(field.get(entity).toString().getBytes());
						query.append("'"). append(value).append("'");
					} else {
						query.append("'"). append(field.get(entity).toString()).append("'");
					}
				}
				if(index != fields.length - 1) {
					query.append(",");
				}
			}
		}
		query.append(")");
		return query.toString();
	}
	
}
