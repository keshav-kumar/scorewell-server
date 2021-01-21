package com.scorewell;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class ScoreWellApplication extends SpringBootServletInitializer
{
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ScoreWellApplication.class);
    }
	
    public static void main( String[] args )
    {
    	SpringApplication.run(ScoreWellApplication.class, args);
        System.out.println( "Hello World!" );
    }
}
