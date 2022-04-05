package com.alo.digital.herramientas.demonios.sendEmail.email;

import com.alo.digital.herramientas.demonios.sendEmail.util.EmailSenderCustom;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Map;
import java.util.Properties;

@Component
public class EmailSender {

    //@Autowired
    //private JavaMailSender mailSender;

    @Autowired
    EmailSenderCustom emailSenderCustom;
    @Autowired
    private VelocityEngine velocityEngine;

    public void sendEmailUsingVelocityTemplate(final String subject, String RUC, final String message,
                                               final String fromEmailAddress, final String toEmailAddress, Map<String,String> emailPojo) {

        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
                message.setTo(toEmailAddress);
                message.setFrom(new InternetAddress(fromEmailAddress));

                VelocityContext velocityContext = new VelocityContext();
                velocityContext.put("eml", emailPojo);

                StringWriter stringWriter = new StringWriter();

                velocityEngine.mergeTemplate("velocity/text.vm", "UTF-8", velocityContext, stringWriter);

                message.setSubject(subject);
                message.setText(stringWriter.toString(), true);
            }
        };

        try {
            emailSenderCustom.enviarCorreo(RUC, preparator);
            System.out.println("Email sending complete.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
