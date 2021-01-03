package com.leaning.MyConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.leaning")
public class MyUserConfig{

	
	@Bean
	public InternalResourceViewResolver getUserResolver() {
		
		
		InternalResourceViewResolver resolver=new InternalResourceViewResolver();
		
		resolver.setPrefix("/WEB-INF/UserViews/");
		resolver.setSuffix(".jsp");
		
		return resolver;
		
		
	}
	
	
	
}
