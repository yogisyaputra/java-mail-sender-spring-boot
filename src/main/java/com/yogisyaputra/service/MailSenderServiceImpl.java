package com.yogisyaputra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * project java-mail-sender-spring-boot
 * created Thursday 18/08/2022
 * author Yogi Syaputra @yogisyaputra
 */

@Service
public class MailSenderServiceImpl implements MailSenderService{

    @Value("${spring.mail.from}")
    private String from;

    @Autowired
    private JavaMailSender emailSender;

    @Override
    public void sendSimpleMessage(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setText(body);
        message.setSubject(subject);

        emailSender.send(message);

    }

    @Override
    public void sendMessageWithAttachment(String to, String subject, String text, String pathAttachment) {
        try {
            MimeMessage message = emailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text);

            FileSystemResource file
                    = new FileSystemResource(new File(pathAttachment));
            helper.addAttachment("Invoice", file);

            emailSender.send(message);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
