package com.alo.digital.herramientas.demonios.sendEmail.taks.async;

import com.alo.digital.herramientas.demonios.sendEmail.email.EmailSender;
import com.alo.digital.herramientas.demonios.sendEmail.taks.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class SendEmailTask implements Task {


    @Autowired
    private EmailSender emailSender;

    @Override
    @Scheduled(fixedDelayString = "${app.time.senddelay.sg}")
    public void iniTask() {
        System.out.println("SEND EMAIL");
        if (ReInitializeEmailSender.flagInitialized) {
            System.out.println("NO SE ENVIAN CORREO SE ESTÁ REINICIALIZANDO EL COMPONENTE");
        } else {
            Map<String, String> obj = new HashMap<>();
            obj.put("userName", "Cesar's");
            obj.put("empresaName", "Norkys");
            obj.put("empresaLogo", "https://beebeneficios.com.pe/rsc/mail/rsc/BB-007-1.png");
            emailSender.sendEmailUsingVelocityTemplate("Su Cupón .", "11111111111", "", "cesarsdev@gmail.com", "cpinedo428@gmail.com", obj);
        }

    }
}
