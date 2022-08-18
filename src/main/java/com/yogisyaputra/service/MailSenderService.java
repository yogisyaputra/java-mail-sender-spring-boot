package com.yogisyaputra.service;

/**
 * project java-mail-sender-spring-boot
 * created Thursday 18/08/2022
 * author Yogi Syaputra @yogisyaputra
 */
public interface MailSenderService {
    void sendSimpleMessage(String to, String subject, String body);
    void  sendMessageWithAttachment(String to, String subject, String text, String pathAttachment);
}
