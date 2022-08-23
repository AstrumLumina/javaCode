package com.xuanxie.JavaEmail;

import org.junit.jupiter.api.Test;

import javax.mail.*;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import com.xuanxie.JavaEmail.MailParseTool;

//解析邮件的测试类
public class MailClient {//读取邮件测试
    public String emailHost="pop.163.com";
    public String storeType="pop3";
    public String fromEmail="wzw3035361676@163.com";
    public String authCode="";//授权码

    @Test
    public  void clientTest_1() throws MessagingException, IOException {//简单解析
        //初始化默认参数
        Properties props = new Properties();
        props.setProperty("mail.host",emailHost);
        props.setProperty("mail.store.protocol",storeType);
        props.setProperty("amil.user",fromEmail);

        //获取连接
        Session session = Session.getInstance(props);
        session.setDebug(true);

        //获取store对象
        Store store = session.getStore();
        store.connect(null,authCode);//第一个参数已经在props中设置了,因此可以传入空

        //获取收件箱中的内容  folder:邮件夹
        Folder folder = store.getFolder("INBOX");
        //设置对邮件的访问权限
        folder.open(Folder.READ_WRITE);
        //Folder.READ_ONLY:1 只读   Folder.READ_WRITE:2 只写

        //获取邮箱账户的所有邮件
        Message[] messages = folder.getMessages();
        for (Message message : messages) {
            String subject=message.getSubject();
            Address from=message.getFrom()[0];
            System.out.println("邮件的主题是:"+subject);
            System.out.println("邮件来自:"+from);
            message.writeTo(System.out);
        }
        //关闭邮件对象
        folder.close(false);
        store.close();//关闭连接对象
    }

    //较完整的解析
    @Test
    public void clientTest_2(){
        //初始化默认参数
        Properties props = new Properties();
        props.setProperty("mail.host",emailHost);
        props.setProperty("mail.store.protocol",storeType);
        props.setProperty("amil.user",fromEmail);

        //获取连接
        Session session = Session.getInstance(props);
        session.setDebug(true);

        try {
            //获取store对象
            Store  store = session.getStore();
            store.connect(null,authCode);//第一个参数已经在props中设置了,因此可以传入空

            //获取收件箱中的内容  folder:邮件夹
            Folder folder = store.getFolder("INBOX");
            //设置对邮件的访问权限
            folder.open(Folder.READ_WRITE);
            //Folder.READ_ONLY:1 只读   Folder.READ_WRITE:2 只写

            //获取 邮件的借本信息
            Map<String,Integer> map=MailParseTool.emailInfo(folder);
            System.out.println(map);

            //得到所有的邮件并解析
            Message[] messages = folder.getMessages();
            paraseMessage(messages);

            folder.close(false);
            store.close();


        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void paraseMessage(Message... messages) throws MessagingException, IOException {//循环解析单封邮件
        //判断邮件是否为空
        if(messages==null||messages.length<1){
            throw new MessagingException("未找到要解析的邮件!");
        }

        //有 邮件则解析邮件
        for (int i = 0; i < messages.length; i++) {
            MimeMessage mgs=(MimeMessage) messages[i];
            System.out.println("********** 现在在解析第 "+i+" 封邮件");
            System.out.println("邮件主题 : "+MailParseTool.getSubject(mgs));
            System.out.println("发件人 : "+MailParseTool.getFrom(mgs));
            System.out.println("日期 : "+MailParseTool.getSentDate(mgs,null));
            System.out.println("是否需要回复 : "+MailParseTool.isReplySign(mgs));

            //处理邮件正文
            StringBuffer content=new StringBuffer();
            MailParseTool.getMailTextContent(mgs,content);
            System.out.println("邮件的正文: ");
            System.out.println(content);
            System.out.println("第 "+i+" 封邮件解析结束!\n\n\n");
        }

    }

}
