package com.alo.digital.herramientas.demonios.sendEmail;

import com.alo.digital.herramientas.demonios.sendEmail.email.EmailPojo;
import com.alo.digital.herramientas.demonios.sendEmail.email.EmailSender;
import com.alo.digital.herramientas.demonios.sendEmail.email.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@SpringBootApplication
@EnableScheduling
public class SendEmailApplication {//implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(SendEmailApplication.class, args);
    }

    /*
    *     String userName;
        String empresaName;
        String empresaLogo;

    @Override
    public void run(String... args) throws Exception {


    }* */

}
