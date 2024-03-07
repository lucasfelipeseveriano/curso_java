package com.softgraf.primavera.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan
public class WebConfig implements WebMvcConfigurer{
	
	private final static String folderUploads = System.getProperty("user.dir") + "\\uploads\\";
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		registry
			.addResourceHandler("/uploads/**", "/images/**")
			.addResourceLocations("file:" + folderUploads,
									"classpath:\\static\\images\\");
		
		
		WebMvcConfigurer.super.addResourceHandlers(registry);
	}

}
