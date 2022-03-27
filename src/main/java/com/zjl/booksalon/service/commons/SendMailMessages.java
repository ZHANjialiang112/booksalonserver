package com.zjl.booksalon.service.commons;

import com.zjl.booksalon.excption.SystemErrorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    private Logger logger = LoggerFactory.getLogger(this.getClass());
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

    @Autowired
    private static RedisTemplateService redisService;

    public void sendMailHtmlCode(String type, String sendToeMail) {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setPassword(password);
        javaMailSender.setHost(host);
        javaMailSender.setUsername(username);
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "utf-8");
            mimeMessageHelper.setFrom(username);
            mimeMessageHelper.setTo(sendToeMail);
            if (MAIL_REGISTER_TYPE.equals(type)) {
                mimeMessage.setSubject("注册验证码");
            }
            if (MAIL_UPDATE_TYPE.equals(type)) {
                mimeMessage.setSubject("改密验证码");
            }
            mimeMessageHelper.setText(sendMailCode(type), true);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            logger.info(String.valueOf(e));
            throw new SystemErrorException("验证码发送失败");
        }
    }


    private static  String sendMailCode(String type){
        if (MAIL_REGISTER_TYPE.equals(type)) {
            return "<div class=\"qmbox qm_con_body_content qqmail_webmail_only\" style=\"opacity: 1;\"><p style=\"font-size:12pt;\">亲爱的booksalon用户，您好：</p>\n" +
                    "\t\t<p style=\"font-size:12pt;text-indent: 2em;\">感谢注册booksalon,您的验证码是<a style=\"color: red;\">" + randomCodeToRedis(type) + "</a>。验证码在一分钟内有效，失效后请重新获取。</p>\n" +
                    "\t\t<p style=\"font-size:12pt;text-indent: 2em;\">若不是本人操作请忽略，请注意保护账号安全。</p>\n" +
                    "\t\t<p style=\"font-size:12pt;text-align:right;\">booksalon团队</p><style type=\"text/css\">.qmbox style, .qmbox script, .qmbox head, .qmbox link, .qmbox meta {display: none !important;}</style>\n" +
                    "\t\t</div>";
        }
        if (MAIL_UPDATE_TYPE.equals(type)) {
            return "<div class=\"qmbox qm_con_body_content qqmail_webmail_only\" style=\"opacity: 1;\"><p style=\"font-size:12pt;\">亲爱的booksalon用户，您好：</p>\n" +
                    "\t\t<p style=\"font-size:12pt;text-indent: 2em;\">您正在操作修改账号密码,您的验证码是<a style=\"color: red;\">" + randomCodeToRedis(type) + "</a>。验证码在一分钟内有效，失效后请重新获取。</p>\n" +
                    "\t\t<p style=\"font-size:12pt;text-indent: 2em;\">若不是本人操作请忽略，请注意保护账号安全。</p>\n" +
                    "\t\t<p style=\"font-size:12pt;text-align:right;\">booksalon团队</p><style type=\"text/css\">.qmbox style, .qmbox script, .qmbox head, .qmbox link, .qmbox meta {display: none !important;}</style>\n" +
                    "\t\t</div>";

        }
        return "获取验证码失败";
    }

    /**
     * 生成6位验证码，并保存到redis中
     */
    private static String randomCodeToRedis(String key) {
        String s = String.valueOf((int) (Math.random() * 123456789));
        String code = s.substring(1, 7);
        //此处将对应的验证码放入到redis中
        redisService.setMailCode(key, code);
        return code;
    }
}
