package hello;

import hello.services.GreeterService;
import hello.services.PhraseBuilderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.web.WebApplicationInitializer;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableMBeanExport
public class Application extends SpringBootServletInitializer implements WebApplicationInitializer {

    @Bean
    public GreeterService getGreeterService() {
        return new GreeterService();
    }

    @Bean(initMethod = "init")
    public PhraseBuilderService getPhraseBuilderService() {
        return new PhraseBuilderService();
    }

    private static Class<Application> applicationClass = Application.class;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }

}