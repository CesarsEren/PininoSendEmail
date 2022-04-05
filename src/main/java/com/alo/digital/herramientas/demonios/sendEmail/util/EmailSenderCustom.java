package com.alo.digital.herramientas.demonios.sendEmail.util;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.*;

@Component
public class EmailSenderCustom extends JavaMailSenderImpl {

    Map<String, Properties> propertiesMap = new HashMap<>();


    List<String> rucs = new ArrayList<>();

    EmailSenderCustom() {
        try {
            initializeProperties();
            initialize();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //generateProperties

    public void initializeProperties() throws IOException {
        rucs.clear();
        InputStream inputStream = this.getClass().getResourceAsStream("/RUCS.txt");
        //StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                //resultStringBuilder.append(line).append("\n");
                rucs.add(line);
            }
        }
        //RUCS= rucs.stream().toArray(String[]::new);
    }

    public void initialize() {
        propertiesMap.clear();
        System.out.println(rucs.toString());
        rucs.forEach(ruc -> {
            Properties properties = new Properties();
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("smtp/" + ruc + "email.properties");
            try {
                properties.load(inputStream);
                propertiesMap.put(ruc, properties);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void enviarCorreo(String ruc, MimeMessagePreparator preparator) {
        System.out.println(ruc);

        Properties properties = propertiesMap.get(ruc);
        System.out.println(properties.toString());
        this.setHost(properties.getProperty("mail.smtp.host"));
        this.setPort(Integer.parseInt(properties.getProperty("mail.smtp.port")));
        this.setUsername(properties.getProperty("mail.smtp.username"));
        this.setPassword(properties.getProperty("mail.smtp.password"));
        this.setJavaMailProperties(properties);
        this.send(preparator);
    }

}
