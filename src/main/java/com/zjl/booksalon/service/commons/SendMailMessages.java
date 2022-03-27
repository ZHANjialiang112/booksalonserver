package com.zjl.booksalon.service.commons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @Auther: ZJL
 * @Date: 2022/3/27 09:55
 * @Description:
 */
@Service
public class SendMailMessages {
    public final static String MAIL_REGISTER_TYPE = "register";
    public final static String MAIL_UPDATE_TYPE = "update";
    /**
     * 获取配置文件信息
     */
    @Value("${spring.mail.username}")
    private String username;
    @Value("${spring.mail.host}")
    private String host;
    @Value("${spring.mail.password}")
    private String password;


    public void sendMailHtmlCode(){
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setPassword(password);
        javaMailSender.setHost(host);
        javaMailSender.setUsername(username);
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true,"utf-8");
            mimeMessageHelper.setFrom(username);
            mimeMessageHelper.setTo("2655919500@qq.com");
            //mimeMessageHelper.setTo("booksalon@163.com");
            //mimeMessageHelper.setTo("zhanjia821@gmail.com");
            //TODO 此处根据验证码的类型，设置对应的标题
            mimeMessage.setSubject("注册验证码");
            mimeMessageHelper.setText(sendMailCode(MAIL_UPDATE_TYPE),true);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }


    private static  String sendMailCode(String type){
        if (MAIL_REGISTER_TYPE.equals(type)) {
            return "<div class=\"qmbox qm_con_body_content qqmail_webmail_only\" style=\"opacity: 1;\"><p style=\"font-size:12pt;\">亲爱的booksalon用户，您好：</p>\n" +
                    "\t\t<p style=\"font-size:12pt;text-indent: 2em;\">感谢注册booksalon,您的验证码是<a style=\"color: red;\">"+randomCodeToRedis()+"</a>。验证码在一分钟内有效，失效后请重新获取。</p>\n" +
                    "\t\t<p style=\"font-size:12pt;text-indent: 2em;\">若不是本人操作请忽略，请注意保护账号安全。</p>\n" +
                    "\t\t<p style=\"font-size:12pt;text-align:right;\">booksalon团队</p><style type=\"text/css\">.qmbox style, .qmbox script, .qmbox head, .qmbox link, .qmbox meta {display: none !important;}</style>\n" +
                    "\t\t</div>";
        }
        if (MAIL_UPDATE_TYPE.equals(type)) {
            return "<div class=\"qmbox qm_con_body_content qqmail_webmail_only\" style=\"opacity: 1;\"><p style=\"font-size:12pt;\">亲爱的booksalon用户，您好：</p>\n" +
                    "\t\t<p style=\"font-size:12pt;text-indent: 2em;\">您正在操作修改账号密码,您的验证码是<a style=\"color: red;\">" + randomCodeToRedis() + "</a>。验证码在一分钟内有效，失效后请重新获取。</p>\n" +
                    "\t\t<p style=\"font-size:12pt;text-indent: 2em;\">若不是本人操作请忽略，请注意保护账号安全。</p>\n" +
                    "\t\t<p style=\"font-size:12pt;text-align:right;\">booksalon团队</p><style type=\"text/css\">.qmbox style, .qmbox script, .qmbox head, .qmbox link, .qmbox meta {display: none !important;}</style>\n" +
                    "\t\t</div>";

        }
        return "获取验证码失败";
    }

    private static String randomCodeToRedis(){
        String s = String.valueOf((int) (Math.random() * 123456789));
        String code = s.substring(1, 7);
        //TODO 此处将对应的验证码放入到redis中
        return code;
    }
}
