package com.promotion.mail.service;

import com.promotion.mail.model.Client;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService{
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String FROM;

    @Value("${MessagePromotion.discountValue}")
    private String discountValue;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

   public void sendMessage(Client client) throws MessagingException {
       MimeMessage message = mailSender.createMimeMessage();
       MimeMessageHelper helper = new MimeMessageHelper(message, true);
       helper.setFrom(FROM);
       helper.setTo(client.getEmail());
       helper.setSubject("Promotion");
       helper.setText(getMessage(client.getName()));
       mailSender.send(message);
   }

    public String getMessage (String name){
        return name+" Hoy es su cumpleaños y usted es importante para nosotros," +
                " queremos celebralo ofreciendo un "+ discountValue +" % de descuento " +
                "y delivery gratuito. Valido por 24 hrs";
    }

}
