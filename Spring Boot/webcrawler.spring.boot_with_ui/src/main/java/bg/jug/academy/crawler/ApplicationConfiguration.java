package bg.jug.academy.crawler;

import bg.jug.academy.crawler.db.PersistenceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
//@EnableWebMvc
public class ApplicationConfiguration implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
                    throws Exception {
                System.out.println("Request comming: " + request.getPathInfo());
                return true;
            }
        });
    }

    @Autowired
    private ApplicationProperties properties;

    public void setProperties(ApplicationProperties properties) {
        this.properties = properties;
    }

    @Qualifier("dbpersistencemanager")
    @Bean
//	@DependsOn("filePersistenceManager")
//	@Scope("prototype")
//	@Lazy
    public PersistenceManager createPersistenceManager() {
        return new PersistenceManager();
    }

//	@Bean
//	public DataSource createDataSource() {
//		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
////	        dataSourceBuilder.driverClassName("org.h2.Driver");
//		dataSourceBuilder.url(properties.getUrl());
//		dataSourceBuilder.username(properties.getUser());
//		dataSourceBuilder.password(properties.getPass());
//		return dataSourceBuilder.build();
//	}

}
