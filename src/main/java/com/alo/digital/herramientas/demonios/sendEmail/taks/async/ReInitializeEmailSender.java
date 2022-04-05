package com.alo.digital.herramientas.demonios.sendEmail.taks.async;

import com.alo.digital.herramientas.demonios.sendEmail.email.EmailSender;
import com.alo.digital.herramientas.demonios.sendEmail.taks.Task;
import com.alo.digital.herramientas.demonios.sendEmail.util.EmailSenderCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ReInitializeEmailSender implements Task {

    static boolean flagInitialized = false;

    @Autowired
    EmailSenderCustom emailSenderCustom;

    @Override
    @Scheduled(fixedDelayString = "${app.time.delay.sg}")
    public void iniTask() {
        ReInitializeEmailSender.flagInitialized = true;
        try {
            emailSenderCustom.initializeProperties();
            emailSenderCustom.initialize();
            ReInitializeEmailSender.flagInitialized = false;
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
