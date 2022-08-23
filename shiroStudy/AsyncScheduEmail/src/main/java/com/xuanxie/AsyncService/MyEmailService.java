package com.xuanxie.AsyncService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Service
public class MyEmailService {

    @Autowired
    JavaMailSenderImpl javaMailSender;

    public void javaEmailService(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("邮件测试");
        message.setText("这是一封springboot mail 测试邮件");
        message.setFrom("3035361676@qq.com");
        message.setTo("325884@whut.edu.cn");
        javaMailSender.send(message);
    }

    public void MimeMessageEmail(){
        try {
            //复杂邮件
            MimeMessage message = javaMailSender.createMimeMessage();
            //组装邮件
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            helper.setSubject("复杂邮件测试");

            String imagePath=System.getProperty("user.dir")+"\\target\\classes\\static\\image\\forEmail.jpg";
            helper.addAttachment("1.jpg",new File(imagePath));

            helper.setText("<p style='color:red'>这是一封springboot 复杂邮件测试</p>"
                    +"<p>主要内容在图片里</p>"
                    +"<h><img src='cid:p1' width:100/></h>",true);

            FileSystemResource fileSystemResource = new FileSystemResource(new File(imagePath));
            helper.addInline("p1", fileSystemResource);


            helper.setFrom("3035361676@qq.com");
            helper.setTo("325884@whut.edu.cn");
            javaMailSender.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
