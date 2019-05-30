package com.xiaoliu.service.email;

import java.io.File;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 * Created by 路人甲 on 2019/5/30 22:49
 */
@Service
public class EmailService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private JavaMailSender sender;
    @Value("${spring.mail.username}")
    private String formMail;

    /**
     * 发送简单的邮件信息
     * @param toMail
     * @param subject
     * @param content
     */
    public void sendSimpleMail(String toMail,String subject,String content) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(formMail);
        simpleMailMessage.setTo(formMail);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(content);
        try {

                sender.send(simpleMailMessage);


            logger.info("发送给"+toMail+"简单邮件已经发送。 subject："+subject);
        } catch (Exception e) {
            logger.info("发送给"+toMail+"send mail error subject："+subject);
            e.printStackTrace();
        }finally {
            sender.send(simpleMailMessage);
        }
    }
    /**
     * 发送html格式的邮件
     * @param toMail
     * @param subject
     * @param content
     */
    public void sendHtmlMail(String toMail,String subject,String content) {
        MimeMessage createMimeMessage = sender.createMimeMessage();

        try {
            //true表示需要创建一个multipart message 如何不设置就不会解析html
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(createMimeMessage,true);
            mimeMessageHelper.setFrom(formMail);
            mimeMessageHelper.setTo(toMail);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(content, true);
            sender.send(createMimeMessage);
            logger.info("发送给"+toMail+"html邮件已经发送。 subject："+subject);
        } catch (MessagingException e) {
            logger.info("发送给"+toMail+"html send mail error subject："+subject);
            e.printStackTrace();

        }
    }
    /**
     * 发送静态资源（一般是图片）的邮件
     * @param toMail
     * @param subject
     * @param content
     * @param resourceist
     */
    public void sendInlineResourceMail(String toMail,String subject,String content,List<InlineResource> resourceist) {
        MimeMessage message = sender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(formMail);
            helper.setTo(toMail);
            helper.setSubject(subject);
            helper.setText(content, true);
            for (InlineResource inlineResource : resourceist) {
                FileSystemResource res = new FileSystemResource(new File(inlineResource.getPath()));
                helper.addInline(inlineResource.getCid(),res);
            }
            sender.send(message);
            logger.info("嵌入静态资源的邮件已经发送。");
        } catch (MessagingException e) {
            logger.error("发送嵌入静态资源的邮件时发生异常！", e);
            e.printStackTrace();
        }catch (Exception e) {
            logger.error("发送嵌入静态资源的邮件时发生异常！", e);
            e.printStackTrace();
        }
    }
}
