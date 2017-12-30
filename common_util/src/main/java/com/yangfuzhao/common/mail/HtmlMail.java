package com.yangfuzhao.common.mail;

import org.apache.log4j.Logger;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: benyamin
 * Date: 17-3-31
 * Time: 下午12:07
 * To change this template use File | Settings | File Templates.
 */
public class HtmlMail {
    private static Logger logger = Logger.getLogger(TextMail.class);


    private MimeMessage message;
    private Properties props;
    private Session session;
    private String name = "";
    private String password = "";

    public HtmlMail(String host, String name, String password){
        this.name = name;
        this.password = password;
        props = System.getProperties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.auth", "true");

        MyAuthenticator auth = new MyAuthenticator(name,password);
        session = Session.getDefaultInstance(props,auth);
        message = new MimeMessage(session);
    }

    public void setFrom(String from){
        try {
            message.setFrom(new InternetAddress(from));
        } catch (AddressException e) {
            logger.error(e);
        } catch (MessagingException e) {
            logger.error(e);
        }
    }


    public void setTo(String to){
        try {
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        } catch (AddressException e) {
            logger.error(e);
        } catch (MessagingException e) {
            logger.error(e);
        }
    }


    public void setSubject(String subject){
        try {
            message.setSubject(subject);
        } catch (MessagingException e) {
            logger.error(e);
        }
    }

    public void setHtml(String html) {
        try {
            message.setContent(html, "text/html;charset = gbk");
            message.saveChanges();
        } catch (MessagingException e) {
            logger.error(e);
        }
    }

    public boolean send(){
        try{
            Transport transport = session.getTransport("smtp");
            transport.connect((String) props.get("mail.smtp.host"),name,password);
            transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            transport.close();
            return true;
        }catch(NoSuchProviderException e){
            logger.error(e);
            return false;
        }catch (MessagingException e){
            e.printStackTrace();
            logger.error(e);
            return false;
        }
    }
}
