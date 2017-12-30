package com.yangfuzhao.common.mail;


import com.ipaynow.npacc.common.secret.SecretUtil;

public class MailUtil {



    private static final String MAILPASS_KEY = "09s7d3sf0s97sfu32";
    /*public static void main(String [] args){
        String s = SecretUtil.encryptStringAES("Ipaynow@06CR/:",MAILPASS_KEY);
        System.out.println(s);
    }*/


    private String host;   
    private String name;   
    private String password;   
    private String from;   
    private String to;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * 初始化Mailbox
     * @host smtp地址的Host。如 smtp.163.com
     * @name 用户名
     * @password 密码
     * @from 发件人
     * @to 收件人
     */
    public MailUtil(String host, String name, String password,String from , String to) {   
        this.host = host;   
        this.name = name;   
        this.password = SecretUtil.decryptStringAES(password,MAILPASS_KEY);
        this.from = from;   
        this.to = to;
    }

    public MailUtil(String host, String name, String password, String from) {
        this.host = host;
        this.name = name;
        this.password = SecretUtil.decryptStringAES(password,MAILPASS_KEY);
        this.from = from;
    }

    /**
     * 发送文本邮件
     * @subject 主题
     * @content 正文内容
     * @return  成功返回true
     */
    public boolean sendTextMail(String subject,String content){   
        TextMail textMail = new TextMail(host,name,password);   
        textMail.setFrom(from);
        textMail.setTo(to);
        textMail.setText(content);   
        textMail.setSubject(subject);   
        return textMail.send();
    }

    /**
     * 发送文本邮件
     * @subject 主题
     * @content 正文内容
     * @return  成功返回true
     */
    public boolean sendHtmlMail(String subject,String content){
        HtmlMail htmlMail = new HtmlMail(host,name,password);
        htmlMail.setFrom(from);
        htmlMail.setTo(to);
        htmlMail.setHtml(content);
        htmlMail.setSubject(subject);
        return htmlMail.send();
    }

    /**
     * 发送带附件的邮件
     * @subject 主题
     * @content 正文内容
     * @attachments 附件路径数组
     * @return  成功返回true
     */
    public boolean sendAttachmentMail(String subject,String content,String []attachments){   
    	AttachmentMail attachmentMail = new AttachmentMail(host,name,password);
    	attachmentMail.setFrom(from);
    	attachmentMail.setTo(to);
    	attachmentMail.setContent(content);
    	attachmentMail.setSubject(subject);
    	for(int i = 0; i < attachments.length;i ++){
    		attachmentMail.addAttachMent(attachments[i]);
    	}
        return attachmentMail.send();   
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void main(String [] args){
        String from = "mchPlat@ipaynow.cn";
        String to = "gaohuiqian@ipaynow.cn";
        String subject = "请您激活join账号";
        String content = "呵呵,world!";
        String host = "smtp.exmail.qq.com";
        String name = "mchPlat@ipaynow.cn";
        String password = "6114b410502af5a701af749ed8331557";
//        String password = "6114b410502af5a701af749ed8331557";

       MailUtil mailBox = new MailUtil(host,name,password,from,to);   
        if(mailBox.sendAttachmentMail(subject,content,new String[0])){
            System.out.println("TextMail send successfully!");   
        }
        else{
            System.out.println("TextMail send failed!");
        }
        
        
//        String [] attachments = new String[2];
//        attachments[0] = "src//test//resources//properties//propertyReader.properties";
//        attachments[1] = "src//test//resources//properties//util-log4j.properties";
//
//        if(mailBox.sendAttachmentMail(subject, content, attachments)){
//            System.out.println("AttachmentMail send successfully!");
//        }else{
//            System.out.println("AttachmentMail send failed!");
//        }
    }
}  
