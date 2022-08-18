package com.yogisyaputra;

import com.yogisyaputra.service.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class JavaMailSenderSpringBootApplication {

    @Autowired
    private MailSenderService mailSenderService;

    public static void main(String[] args) {
        SpringApplication.run(JavaMailSenderSpringBootApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void sendMail(){
        mailSenderService.sendSimpleMessage("yogisyaputra00@gmail.com","test Subject","text body");
    }
}
