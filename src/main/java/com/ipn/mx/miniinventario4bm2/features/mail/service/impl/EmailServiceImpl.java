package com.ipn.mx.miniinventario4bm2.features.mail.service.impl;

import com.ipn.mx.miniinventario4bm2.features.mail.service.EmailService;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class EmailServiceImpl implements EmailService{
    @Autowired
    private JavaMailSender mailSender;

    @Value("classpath:static/img/triplet.jpeg")
    Resource resourceFile;
    @Override
    public void enviarCorreoEelectronico(String to, String subject, String text) {
        MimeMessage mensaje = mailSender.createMimeMessage();
        MimeMessageHelper helper;
        try{
            helper = new MimeMessageHelper(mensaje,
                    true,
                    "UTF-8");

            helper.addAttachment("archivo",
                    new File(resourceFile.getFile().toURI()));

            helper.setFrom("noreply@gmail.com",
                    "Envio de correos via Spring");

            helper.setSubject(subject);
            helper.setText(text, true);
            helper.setTo(to);
            helper.setCc("reyes.salazar.diego1@gmail.com");
            helper.setBcc("reyes.salazar.diego1@gmail.com");
            mailSender.send(mensaje);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
