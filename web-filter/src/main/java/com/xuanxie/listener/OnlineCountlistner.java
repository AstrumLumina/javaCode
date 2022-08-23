package com.xuanxie.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnlineCountlistner implements HttpSessionListener {
    //创建session监听
    /*一旦创建这个事件,就会触发这个事件
    * */
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println(se.getSession().getId());
        ServletContext ctext = se.getSession().getServletContext();
        Integer onlineCount =(Integer) ctext.getAttribute("OnlineCount");
        if(onlineCount==null){
            onlineCount=new Integer(1);

        }else{
            int count=onlineCount.intValue();
            onlineCount=new Integer(count+1);
        }
        ctext.setAttribute("OnlineCount",onlineCount);//更新变量

        //se.getSession().invalidate();//主动销毁session
    }
//销毁session
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

    }
}
