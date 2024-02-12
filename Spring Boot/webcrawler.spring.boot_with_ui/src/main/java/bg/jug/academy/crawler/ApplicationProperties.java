package bg.jug.academy.crawler;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

/**
 * @author Martin
 *
 */
@ConfigurationProperties(prefix = "spring.datasource")
@Configuration
@Validated
public class ApplicationProperties {

//	@Pattern(regexp = "jdbc:mysql:.*")
	private String url;
	
//	@Min(10)
	private String username;
	
	private String password;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
}
