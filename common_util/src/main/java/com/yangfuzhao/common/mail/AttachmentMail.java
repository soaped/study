package com.yangfuzhao.common.mail;

import org.apache.log4j.Logger;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class AttachmentMail {   
	
	private static Logger logger = Logger.getLogger(AttachmentMail.class);
	
	
    private MimeMessage message;   
    private Properties props;   
    private Session session;   
    private MimeMultipart mp;   
    private String name = "";   
    private String password = "";   
  

    public AttachmentMail(String host, String name, String password){   
        this.name = name;   
        this.password = password;   
        props = System.getProperties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.auth", "true");

        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");

        MyAuthenticator auth = new MyAuthenticator(name,password);   
        session = Session.getDefaultInstance(props,auth);
        message = new MimeMessage(session);   
        mp = new MimeMultipart();   
    }   
       
    public void setFrom(String from){
        try {   
            message.setFrom(new InternetAddress(from));   
        } catch (AddressException e){   
        	logger.error(e);
        } catch (MessagingException e){   
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
       
    public void setContent(String content){
        try{   
            BodyPart bp = new MimeBodyPart();   
            bp.setContent(content,"text/html;charset=GB2312");
            mp.addBodyPart(bp);   
        }catch(Exception e){   
        	logger.error(e); 
        }   
    }   
       
    public void addAttachMent(String filename){
        try{   
            BodyPart bp = new MimeBodyPart();   
            FileDataSource fileds = new FileDataSource(filename);   
            bp.setDataHandler(new DataHandler(fileds));   
            bp.setFileName(MimeUtility.encodeWord(fileds.getName()));
            mp.addBodyPart(bp);   
        }catch(Exception e){   
        	logger.error(e);
        }   
    }   
       
    public boolean send(){
        try{   
            message.setContent(mp);   
            message.saveChanges();
            Transport transport = session.getTransport("smtp");
            transport.connect((String) props.get("mail.smtp.host"),name,password);
            transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));   
            transport.close();   
            return true;   
        }catch(NoSuchProviderException e){
        	logger.error(e);
            return false;
        }catch (MessagingException e){   
        	logger.error(e);
            return false;
        }
    }   
}  
