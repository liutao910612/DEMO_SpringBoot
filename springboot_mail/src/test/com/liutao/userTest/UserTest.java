package com.liutao.userTest;

import com.liutao.scheduler.application.Application;
import com.liutao.service.UserService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 测试类
 *
 * @author LIUTAO
 * @version 2017/3/29
 * @see
 * @since
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserTest {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private UserService userServiceImpl;

    @Autowired
    Configuration configuration;

    @Test
    public void getUserInfoTest(){
        System.out.println(userServiceImpl.getUserInfo());
    }

    /**
     * 测试邮件发送
     */
    @Test
    public void sendSimpleMail(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("liutao910612@126.com");
        message.setTo("912413295@qq.com");
        message.setSubject("主题：简单邮件");
        message.setText("测试邮件内容");
        mailSender.send(message);
    }

    /**
     * 发送有附件的邮件
     */
    @Test
    public void sendAttachmentsMail() throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("liutao910612@126.com");
        helper.setTo("912413295@qq.com");
        helper.setSubject("主题：有附件");
        helper.setText("有附件的邮件");
        FileSystemResource file = new FileSystemResource(new File("D:/mail_test.jpg"));
        helper.addAttachment("附件-1.jpg", file);
        helper.addAttachment("附件-2.jpg", file);
        mailSender.send(mimeMessage);
    }

    /**
     * 嵌入静态资源
     * @throws Exception
     */
    @Test
    public void sendInlineMail() throws Exception {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("liutao910612@126.com");
        helper.setTo("912413295@qq.com");
        helper.setSubject("主题：嵌入静态资源");
        helper.setText("<html><body><img src=\"cid:mail_test\" ></body></html>", true);
        FileSystemResource file = new FileSystemResource(new File("D:/mail_test.jpg"));
        helper.addInline("mail_test", file);
        mailSender.send(mimeMessage);
    }

    @Test
    public void sendTemplateMail() throws Exception {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("liutao910612@126.com");
        helper.setTo("912413295@qq.com");
        helper.setSubject("主题：模板邮件");
        Map<String, Object> model = new HashMap();
        model.put("username", "熊大");
        Template t = configuration.getTemplate("mailTemplate/template.ftl");
        String text = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
        helper.setText(text, true);
        mailSender.send(mimeMessage);
    }

}
