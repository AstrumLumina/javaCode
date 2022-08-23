package com.xuanxie.JavaEmail;

import com.sun.mail.smtp.SMTPSSLTransport;
import com.sun.mail.util.MailSSLSocketFactory;
import org.junit.Test;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.security.GeneralSecurityException;

/*邮件分为简单普通邮件(纯文字)
复杂邮件:带有图片文件等附件
* */

/*注意:qq邮箱的特殊情况:
* qq邮箱还需要SSL加密,需要加上以下代码,
* 登录qq邮箱,获取授权码
* gchcrhoqgbrddcgf
* */

/*邮件发送步骤
1.创建定义整个应用程序所需的环境信息的Session 对象
2.通过session得到transport对象
3.用邮箱的用户名和授权吗/密码连上邮件服务器
4.创建邮件
5.发送邮件
6.关闭连接
 */
/*     一:
* 报凑信息  没有合适的协议（协议被禁用或密码套件不合适）

* C:\Users\XUANXIE\.jdks\openjdk-17.0.1\bin\java.exe -ea -Didea.test.cyclic.buffer.size=1048576 "-javaagent:F:\idea\IntelliJ IDEA 2021.3.1\lib\idea_rt.jar=58704:F:\idea\IntelliJ IDEA 2021.3.1\bin" -Dfile.encoding=UTF-8 -classpath "C:\Users\XUANXIE\.m2\repository\org\junit\platform\junit-platform-launcher\1.9.0-M1\junit-platform-launcher-1.9.0-M1.jar;C:\Users\XUANXIE\.m2\repository\org\junit\platform\junit-platform-engine\1.9.0-M1\junit-platform-engine-1.9.0-M1.jar;C:\Users\XUANXIE\.m2\repository\org\opentest4j\opentest4j\1.2.0\opentest4j-1.2.0.jar;C:\Users\XUANXIE\.m2\repository\org\junit\platform\junit-platform-commons\1.9.0-M1\junit-platform-commons-1.9.0-M1.jar;C:\Users\XUANXIE\.m2\repository\org\apiguardian\apiguardian-api\1.1.2\apiguardian-api-1.1.2.jar;C:\Users\XUANXIE\.m2\repository\org\junit\vintage\junit-vintage-engine\5.9.0-M1\junit-vintage-engine-5.9.0-M1.jar;F:\idea\IntelliJ IDEA 2021.3.1\lib\idea_rt.jar;F:\idea\IntelliJ IDEA 2021.3.1\plugins\junit\lib\junit5-rt.jar;F:\idea\IntelliJ IDEA 2021.3.1\plugins\junit\lib\junit-rt.jar;D:\javaCode\JavaEmail\target\classes;F:\idea\apache-maven-3.8.5-bin\apache-maven-3.8.5\maven-repo\junit\junit\4.13.1\junit-4.13.1.jar;F:\idea\apache-maven-3.8.5-bin\apache-maven-3.8.5\maven-repo\org\hamcrest\hamcrest-core\1.3\hamcrest-core-1.3.jar;F:\idea\apache-maven-3.8.5-bin\apache-maven-3.8.5\maven-repo\javax\mail\mail\1.4.7\mail-1.4.7.jar;F:\idea\apache-maven-3.8.5-bin\apache-maven-3.8.5\maven-repo\com\sun\mail\javax.mail\1.4.4\javax.mail-1.4.4.jar;F:\idea\apache-maven-3.8.5-bin\apache-maven-3.8.5\maven-repo\javax\activation\activation\1.1.1\activation-1.1.1.jar;F:\idea\apache-maven-3.8.5-bin\apache-maven-3.8.5\maven-repo\org\junit\jupiter\junit-jupiter\5.9.0-M1\junit-jupiter-5.9.0-M1.jar;F:\idea\apache-maven-3.8.5-bin\apache-maven-3.8.5\maven-repo\org\junit\jupiter\junit-jupiter-api\5.9.0-M1\junit-jupiter-api-5.9.0-M1.jar;F:\idea\apache-maven-3.8.5-bin\apache-maven-3.8.5\maven-repo\org\opentest4j\opentest4j\1.2.0\opentest4j-1.2.0.jar;F:\idea\apache-maven-3.8.5-bin\apache-maven-3.8.5\maven-repo\org\junit\platform\junit-platform-commons\1.9.0-M1\junit-platform-commons-1.9.0-M1.jar;F:\idea\apache-maven-3.8.5-bin\apache-maven-3.8.5\maven-repo\org\apiguardian\apiguardian-api\1.1.2\apiguardian-api-1.1.2.jar;F:\idea\apache-maven-3.8.5-bin\apache-maven-3.8.5\maven-repo\org\junit\jupiter\junit-jupiter-params\5.9.0-M1\junit-jupiter-params-5.9.0-M1.jar;F:\idea\apache-maven-3.8.5-bin\apache-maven-3.8.5\maven-repo\org\junit\jupiter\junit-jupiter-engine\5.9.0-M1\junit-jupiter-engine-5.9.0-M1.jar;F:\idea\apache-maven-3.8.5-bin\apache-maven-3.8.5\maven-repo\org\junit\platform\junit-platform-engine\1.9.0-M1\junit-platform-engine-1.9.0-M1.jar" com.intellij.rt.junit.JUnitStarter -ideVersion5 -junit5 com.xuanxie.JavaEmail.EmailTest,sendEmai
javax.mail.MessagingException: Could not connect to SMTP host: smtp.qq.com, port: 465;
  nested exception is:
	javax.net.ssl.SSLHandshakeException: No appropriate protocol (protocol is disabled or cipher suites are inappropriate)
Caused by: javax.net.ssl.SSLHandshakeException: No appropriate protocol (protocol is disabled or cipher suites are inappropriate)

 原因:发现是我本地环境的jdk1.8.0_301的配置中禁止了这个SLLv3协议，所以本地发送邮件才会一直报错。
            解决方案是打开自己安装的jdk目录，找到配置的文件：
            jdk1.8.0_301\jre\lib\security\java.security，将以下内容删除
            disabel...=sslv3等删除

* ****************************** 二 *********************************
*   需要授权吗:
com.sun.mail.smtp.SMTPSendFailedException: 503 Error: need EHLO and AUTH first !
  nested exception is:
	com.sun.mail.smtp.SMTPSenderFailedException: 503 Error: need EHLO and AUTH first !
Caused by: com.sun.mail.smtp.SMTPSenderFailedException: 503 Error: need EHLO and AUTH first !
  原因:此处的授权吗不是smtp服务的授权码,而是一般的授权码
  需要先开启smtp服务:
  找不到smtp ,pop等服务的开启处:
        开启POP3/SMTP/IMAP功能必须先设置独立密码，这样能够保障你在第三方客户端登陆时的帐户安全。
如果你已经开启了POP3/SMTP/IMAP功能，撤销独立密码会同时关闭你的POP3/SMTP/IMAP功能，这会导致你无法在第三方客户端登陆QQ邮箱。
解决方法：重新设置独立密码。
*/

public class EmailTest {

    @Test
    public  void  sendEmai()  {//以  qq邮箱为例,无法登录服务器,未知原因,为解决
        try {
            //配置连接服务区的信息
            String isdebug = "ture";
            String needAuth = "true";
            String servicehost = "smtp.qq.com";
            String protocol = "smtp";//协议

  /*
            qq: 服务器   服务器地址  非ssl协议端口   ssl协议端口
             发: smtp    smtp.qq.com  25          465/587
             收:  pop    pop.qq.com    110           995
              收: imap  imap.qq.com     143          993
       发现是我本地环境的jdk1.8.0_301的配置中禁止了这个SLLv3协议，所以本地发送邮件才会一直报错。
            解决方案是打开自己安装的jdk目录，找到配置的文件：
            jdk1.8.0_301\jre\lib\security\java.security，将以下内容删除

*/
            Properties propsOfsendemail = new Properties(); //System.getProperties();
            propsOfsendemail.setProperty("mail.debug", isdebug);//开启调试模式
            propsOfsendemail.setProperty("mail.smtp.auth", needAuth);//需要验证密码 后者授权码
            propsOfsendemail.setProperty("mail.smtp.host", servicehost);//发送邮件的服务器地址
            propsOfsendemail.setProperty("mail.transport.protocol", protocol);//邮件发送 连接 协议
            propsOfsendemail.setProperty("mail.smtp.qq.port", "465");/* 465 587 */
            //  propsOfsendemail.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            //propsOfsendemail.setProperty("mail.pop.qq.port","995");/* 995 */


            //qq邮箱需要开启 SSL加密,否则会失效  其他邮箱发送可以省略这一步
            MailSSLSocketFactory mSSLfaocotry = null;
            mSSLfaocotry = new MailSSLSocketFactory();
            mSSLfaocotry.setTrustAllHosts(true);
            propsOfsendemail.put("mail.smtp.ssl.enable","ture");
            propsOfsendemail.put("mail.smtp.ssl.socketFactory",mSSLfaocotry);


            //创建session
            Session session = Session.getInstance(propsOfsendemail, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("3035361676@qq.com", "dwmexcxswbizdgdd");
                }
            });

            //创建邮件
            MimeMessage mimeMessage = new MimeMessage(session);//用session中的数据初始化邮件
            mimeMessage.setSubject("测试发送纯文本邮件");//设置邮件主题,即标题
            mimeMessage.setText("这是一封Java mail测试邮件");//设置邮件的文本内容
            mimeMessage.setFrom(new InternetAddress("3035361676@qq.com"));//设置邮件发送的地址 从哪里发送来的
            InternetAddress toAddress = new InternetAddress("325884@whut.edu.cn");
            mimeMessage.setRecipient(Message.RecipientType.TO, toAddress);//设置发送邮件的方式和邮件发送的地址
            mimeMessage.saveChanges();//保存信件内容

            //从session获取transport对象
           // Transport transport = session.getTransport();
           // SMTPSSLTransport transport = new SMTPSSLTransport(session,null);//该处不传参导致错误,要么直接哪transport,自动帮我们创建,若使用此方法,则不能为空,否则报错
             SMTPSSLTransport transport = new SMTPSSLTransport(session,new URLName("smtp:"));
            System.out.println("debuge====>transport.urlname");
            System.out.println(transport.getURLName());

            //通过tansport对象连接到邮件服务器
            transport.connect("3035361676@qq.com", "dwmexcxswbizdgdd");

            transport.send(mimeMessage, mimeMessage.getAllRecipients());
            transport.close();
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }catch (Throwable e){
            e.printStackTrace();
        }
    }


    //**************************************************
    public String emailHost="smtp.qq.com";//"smtp.163.com";//发送邮件的主机
    public String transportType="smtp";//发送邮件的协议
    public String fromUser="xuanxie";//发送邮件人的名字
    public String fromEmail="3035361676@qq.com";//发送邮件人的名字
    public String authCode="dwmexcxswbizdgdd";//授权码
    public String toEmail="325884@whut.edu.cn";//收件人邮箱
    public String subject="java 邮件发送测试";//邮件主题
    public String content="这是一封java 邮件发送测试邮件!";//主内容
    //主内容格式
    public String contentType="text/html;charset=UTF-8";//html格式
    //"text/plain" 纯文本格式

    @Test
    public void sendEmailOfNetEasy() throws MessagingException, UnsupportedEncodingException {//以网易163邮箱为例

        //初始化默认参数
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol",transportType);
        props.setProperty("mail.host",emailHost);
        props.setProperty("mail.user",fromUser);

        //获取session对象
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, authCode);
            }
        });
        session.setDebug(true);//开启调试模式

        //通过MimeMessage 来创建Message接口的子类
        MimeMessage message = new MimeMessage(session);
        //对邮件进行设置
        //设置发件人
            //方式一:
        InternetAddress fromAddress = new InternetAddress(fromEmail);
            //方式二:
        String fromName = MimeUtility.encodeWord(fromUser) + "<"+fromEmail+">";
        InternetAddress fromAddress_ = new InternetAddress(fromName);
        message.setFrom(fromAddress_);

        //设置收件人
        InternetAddress toAddress = new InternetAddress(toEmail);
        message.setRecipient(Message.RecipientType.TO,toAddress);

        //设置秘送人
//        InternetAddress toBccAddress = new InternetAddress(toEmail);
//        message.setRecipient(Message.RecipientType.BCC,toBccAddress);
//
        //设置抄送人
        List<InternetAddress> addresses= Arrays.asList(new InternetAddress(toEmail),new InternetAddress(toEmail));
        InternetAddress[] addressesArray=(InternetAddress[]) addresses.toArray();
        message.setRecipients(Message.RecipientType.CC,addressesArray);

        //设置邮件主题
        message.setSubject(subject);
        //设置邮件的内容
        message.setContent(content,contentType);
        //保存以上的邮件内容
        message.saveChanges();

        //获取Transport对象
        Transport transport = session.getTransport();

        //连接邮件服务器
        transport.connect(fromEmail,authCode);

        //发送邮件
        transport.sendMessage(message,message.getAllRecipients());

        //关闭
        transport.close();

    }


    @Test
    public  void sendMutilEmail() throws MessagingException, UnsupportedEncodingException {
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol",transportType);
        props.setProperty("mail.host",emailHost);
        props.setProperty("mail.user",fromUser);
        props.setProperty("mail.from",fromEmail);

       // Session session = Session.getInstance(props);
        //qq邮箱需要多一个参数
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, authCode);
            }
        });
        session.setDebug(true);

        MimeMessage message = new MimeMessage(session);
        message.setRecipient(Message.RecipientType.TO,new InternetAddress(toEmail));
        message.setSubject("java复杂邮件测试");
        message.setSentDate(new Date());

        //设置多资源内容
        MimeMultipart text_img_realted=new MimeMultipart("related");

        MimeBodyPart img_body = new MimeBodyPart();
        String realFilePath=System.getProperty("user.dir")+"\\target\\classes\\forEmail.jpg";
        DataHandler dataHandler = new DataHandler(new FileDataSource(realFilePath));
        img_body.setDataHandler(dataHandler);
        img_body.setFileName(MimeUtility.encodeText("第一个附件.jpg"));//为资源文件设置一个中文别名,防止乱码
        img_body.setContentID("picture1");
        text_img_realted.addBodyPart(img_body);

        MimeBodyPart text_body = new MimeBodyPart();
        text_body.setContent("<h1  style='color:red'>这是一个Java 邮件发送测试邮件</h>:" +
                "<h>邮件的主要类内容为以下图片:</h>" +
                "<h><img src='cid:picture1' width:100/></h>"
                +"这张图片...",contentType);
        text_img_realted.addBodyPart(text_body);

        message.setContent(text_img_realted);
        message.saveChanges();

        Transport transport = session.getTransport();
        transport.connect(null,authCode);

        transport.sendMessage(message, message.getAllRecipients());

        transport.close();
    }



}
