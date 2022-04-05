package com.alo.digital.herramientas.demonios.sendEmail;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Configuration
public class EmailConfig {

/*
    @Bean
    public JavaMailSender mailSender() throws IOException {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("cesarsdev@gmail.com");
        mailSender.setPassword("rvyyonirqweynqxq");

        Properties javaMailProperties = new Properties();
        javaMailProperties.put("mail.smtp.auth", "true");
        javaMailProperties.put("mail.smtp.starttls.enable", "true");
        javaMailProperties.put("mail.smtp.ssl.enable", "false");
        javaMailProperties.put("mail.smtp.ssl.trust", "*");

        mailSender.setJavaMailProperties(javaMailProperties);*/



/*
        Properties properties = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("smtp/" + RUC + "email.properties");
        properties.load(inputStream);
        mailSender.setHost(properties.getProperty("mail.smtp.host"));
        mailSender.setPort(Integer.parseInt(properties.getProperty("mail.smtp.port")));
        mailSender.setUsername(properties.getProperty("mail.smtp.username"));
        mailSender.setPassword(properties.getProperty("mail.smtp.password"));

        mailSender.setJavaMailProperties(properties);

        return mailSender;
    }*/

    @Bean
    public void creadorDeProperties(){

    }

    @Bean
    public VelocityEngine velocityEngine() {
        VelocityEngine engine = new VelocityEngine();

        engine.setProperty("resource.loader", "class");
        engine.setProperty("class.resource.loader.class",
                "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");

        return engine;
    }

}
