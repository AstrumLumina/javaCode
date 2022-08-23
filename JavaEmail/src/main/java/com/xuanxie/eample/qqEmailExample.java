package com.xuanxie.eample;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.search.FlagTerm;
import java.io.*;
import java.security.Security;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeUtility;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class qqEmailExample {

    //收
    public  static class SendQQMailInbox {
        public static void main(String[] args) {
            // TODO Auto-generated method stub
            Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";// ssl加密,jdk1.8无法使用

            // 定义连接imap服务器的属性信息
            String port = "993";
            String imapServer = "imap.qq.com";
            String protocol = "imap";
            String username = "3035361676@qq.com";
            String password = "dwmexcxswbizdgdd"; // QQ邮箱的授权码

            // 有些参数可能不需要
            Properties props = new Properties();
            props.setProperty("mail.imap.socketFactory.class", SSL_FACTORY);
            props.setProperty("mail.imap.socketFactory.fallback", "false");
            props.setProperty("mail.transport.protocol", protocol); // 使用的协议
            props.setProperty("mail.imap.port", port);
            props.setProperty("mail.imap.socketFactory.port", port);

            // 获取连接
            Session session = Session.getDefaultInstance(props);
            session.setDebug(true);

            // 获取Store对象
            Store store;
            try {
                store = session.getStore(protocol);
                store.connect(imapServer, username, password); // 登陆认证

                // 通过imap协议获得Store对象调用这个方法时，邮件夹名称只能指定为"INBOX"
                Folder folder = store.getFolder("INBOX");// 获得用户的邮件帐户
                folder.open(Folder.READ_WRITE); // 设置对邮件帐户的访问权限

                int n = folder.getUnreadMessageCount();// 得到未读数量
                System.out.println("未读邮件+" + n);

                FlagTerm ft = new FlagTerm(new Flags(Flags.Flag.SEEN), false); // false代表未读，true代表已读
                Message messages[] = folder.search(ft);
                for (Message message : messages) {
                    String subject = message.getSubject();// 获得邮件主题
                    Address from = (Address) message.getFrom()[0];// 获得发送者地址
                    System.out.println("邮件的主题为: " + subject);
                    try {
                        System.out.println("发件人地址为: " + decodeText(from.toString()));
                    } catch (UnsupportedEncodingException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.println("日期:" + message.getSentDate());
                    /*
                     * Enumeration headers = message.getAllHeaders(); System.out.println(
                     * "----------------------allHeaders-----------------------------"); while
                     * (headers.hasMoreElements()) { Header header = (Header)headers.nextElement();
                     * System.out.println(header.getName()+" ======= "+header.getValue());
                     * System.out.println("----------------------------"); }
                     */
                    try {
//					parseMultipart((Multipart) message.getContent());
                        Object content = message.getContent();
                        if(content instanceof String ) {
                            String body = (String) content;
                            System.out.println("正文："+ body);
                        }else if(content instanceof Multipart){
                            Multipart mp = (Multipart) content;
                            System.out.println("正文："+ mp.getBodyPart(0).getContent());
                        }
                        //System.out.println("正文:" + bp.getContent());
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    message.setFlag(Flags.Flag.SEEN, false); // imap读取后邮件状态会变为已读,设为未读
                }

                folder.close(false);// 关闭邮件夹对象
                store.close(); // 关闭连接对象
            } catch (MessagingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        protected static String decodeText(String text) throws UnsupportedEncodingException {
            if (text == null)
                return null;
            if (text.startsWith("=?GB") || text.startsWith("=?gb"))
                text = MimeUtility.decodeText(text);
            else
                text = new String(text.getBytes("ISO8859_1"));
            return text;
        }

        /**
         * 对复杂邮件的解析
         *
         * @param multipart
         * @throws MessagingException
         * @throws IOException
         */
        public static void parseMultipart(Multipart multipart) throws MessagingException, IOException {
            int count = multipart.getCount();
            System.out.println("couont =  " + count);
            for (int idx = 0; idx < count; idx++) {
                BodyPart bodyPart = multipart.getBodyPart(idx);
                System.out.println(bodyPart.getContentType());
                if (bodyPart.isMimeType("text/plain")) {
                    System.out.println("plain................." + bodyPart.getContent());
                } else if (bodyPart.isMimeType("text/html")) {
                    System.out.println("html..................." + bodyPart.getContent());
                } else if (bodyPart.isMimeType("multipart/*")) {
                    Multipart mpart = (Multipart) bodyPart.getContent();
                    parseMultipart(mpart);

                } else if (bodyPart.isMimeType("application/octet-stream")) {
                    String disposition = bodyPart.getDisposition();
                    System.out.println(disposition);
                    if (disposition.equalsIgnoreCase(BodyPart.ATTACHMENT)) {
                        String fileName = bodyPart.getFileName();
                        InputStream is = bodyPart.getInputStream();
                        copy(is, new FileOutputStream("D:\\" + fileName));
                    }
                }
            }
        }

        /**
         * 文件拷贝，在用户进行附件下载的时候，可以把附件的InputStream传给用户进行下载
         *
         * @param is
         * @param os
         * @throws IOException
         */
        public static void copy(InputStream is, OutputStream os) throws IOException {
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = is.read(bytes)) != -1) {
                os.write(bytes, 0, len);
            }
            if (os != null)
                os.close();
            if (is != null)
                is.close();
        }


    }

    //发
    public static class SendQQMailUtil {

        //需要用户名密码邮件发送实例
        //文件名 SendEmail2.java
        //本实例以QQ邮箱为例，你需要在qq后台设置
        /**
         * QQ发送邮件
         *@author Administrator
         */
        public static void main(String[] args) {
            // 收件人电子邮箱
            String to = "325884@whut.edu.cn";

            // 发件人电子邮箱
            final String from = "3035361676@qq.com";
            final String password = "dwmexcxswbizdgdd"; // QQ邮箱的授权码

            // 指定发送邮件的主机为 smtp.qq.com
            String host = "smtp.qq.com"; // QQ 邮件服务器

            // 获取系统属性
            Properties properties = System.getProperties();

            // 设置邮件服务器
            properties.setProperty("mail.smtp.host", host);

            properties.put("mail.smtp.auth", "true");
            // 获取默认session对象
            Session session = Session.getDefaultInstance
                    (properties, new Authenticator() {
                public PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(from, password); // 发件人邮件用户名、授权码
                }
            });

            try {
                // 创建默认的 MimeMessage 对象
                MimeMessage message = new MimeMessage(session);

                // Set From: 头部头字段
                message.setFrom(new InternetAddress(from));

                // Set To: 头部头字段
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

                // Set Subject: 头部头字段
                message.setSubject("This is the Subject Line!");

                // 设置消息体
                message.setText("This is actual message");

                // 发送消息
                Transport.send(message);
                System.out.println("Sent message successfully....from runoob.com");
            } catch (MessagingException mex) {
                mex.printStackTrace();
            }
        }
    }

}


