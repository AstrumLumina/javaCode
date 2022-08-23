package com.xuanxie.JavaEmail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MailParseTool {//邮件解析工具类
    public static Map<String,Integer> emailInfo(Folder folder) throws MessagingException {
        Map<String,Integer> emailInfo=new HashMap<>();
        /// 由于POP3协议无法获知邮件的状态,
        //所以getUnreadMessageCount得到的是收件箱的邮件总数
        emailInfo.put("unreadMessageCount",folder.getUnreadMessageCount());
       // 由于POP3协议无法获知邮件的状态,所以下面(删除、新邮件)得到的结果始终都是为0
        emailInfo.put("deletedMessageCount",folder.getDeletedMessageCount());
        emailInfo.put("newMessageCount",folder.getNewMessageCount());

        //获取收件箱中的邮件总是
        emailInfo.put("messageCount",folder.getMessageCount());
        return emailInfo;
    }

    public static String getSubject(MimeMessage msg) throws MessagingException {
        return msg.getSubject().toString();
    }

    public static String getFrom(MimeMessage msg) throws MessagingException {
        String from="";
        Address[] froms = msg.getFrom();
        if(froms.length<1){
            throw new MessagingException("内有人发邮件!!");
        }

        InternetAddress address=(InternetAddress)froms[0];
        String person= address.getPersonal();
        if(person==null){
            person="";
        }
        from=person+"<"+address.getAddress()+">";
        return from;
    }

    public static String getSentDate(MimeMessage msg,String pattern) throws MessagingException {
        Date receivedDate=msg.getSentDate();
        if(receivedDate==null){
            return "";
        }
        if(pattern==null||"".equals(pattern)){
            pattern="yyyy年MM月dd日 E HH:mm ";
        }
        return new SimpleDateFormat(pattern).format(receivedDate);
    }

    //判断邮件是否以读
    public static boolean isSeen(MimeMessage msg) throws MessagingException {
        return     msg.getFlags().contains(Flags.Flag.SEEN);
    }

    //判断邮件是否需要回执
    public static boolean isReplySign(MimeMessage msg) throws MessagingException {
        boolean replySign=false;
        String[] headers = msg.getHeader("Dispostions-Notification-To");
        if(headers!=null){
            replySign=true;
        }
        return replySign;
    }

    //获取邮件的优先级

    //获得邮件的文本内容
    public  static void getMailTextContent(Part part,StringBuffer content) throws MessagingException, IOException {
        boolean isContainTextAttach=part.getContentType().indexOf("name")>0;
        if(part.isMimeType("text/*")&&!isContainTextAttach){
            content.append(part.getContent().toString());
        }else if(part.isMimeType("message/rfc822")){
            getMailTextContent((Part)part.getContent(),content);
        }else if(part.isMimeType("multipart/*")){
            Multipart multipart=(Multipart) part.getContent();
            int partCount=multipart.getCount();
            for(int i=0;i<partCount;++i){
                BodyPart bodyPart=multipart.getBodyPart(i);
                getMailTextContent(bodyPart,content);
            }
        }
    }
}
