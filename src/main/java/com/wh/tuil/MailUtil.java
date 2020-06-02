package com.wh.tuil;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

/**
 *  原生发邮件，贼鸡儿麻烦
 * @author WangHao
 * 2020-06-02
 */
public class MailUtil {
    public static void send() throws Exception {
        // 1、配置构成邮件的环境信息
        Properties prpo = new Properties();
        prpo.setProperty("mail.transport.protocol", "smtp");
        prpo.setProperty("mail.smtp.host", "smtp.sina.cn");
        prpo.setProperty("mail.smtp.auth", "true");
        prpo.setProperty("mail.smtp.port", "465");
        prpo.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        prpo.setProperty("mail.smtp.socketFactory.fallback", "false");
        prpo.setProperty("mail.smtp.socketFactory.port", "465");

        // 2、创建会话
        Session session = Session.getInstance(prpo);

        // 3、创建一封邮件
        MimeMessage message = new MimeMessage(session);
        // 发送人
        String sendMail = "wanghao519@sina.cn";
        // 收件人
        String Recipients = "1462455761@qq.com";
        message.setFrom(new InternetAddress(sendMail, "王小同学", "UTF_8"));
//        MimeMessage.RecipientType.TO      发送
//        MimeMessage.RecipientType.CC      抄送
//        MimeMessage.RecipientType.BCC     密送
        message.setRecipient(MimeMessage.RecipientType.TO,new InternetAddress(Recipients,"王小同学","UTF_8"));

        message.setSubject("这是一个标题","UTF-8");
        message.setContent("这是正文", "text/html;charset=UTF-8");
        message.setSentDate(new Date());

        // 4、获取邮件传输对象 建立连接并发送
        Transport transport = session.getTransport();
        String accout = "wanghao519@sina.cn";
        String password = "f3af9469e2f829a8";
        transport.connect(accout, password);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();

    }


}
