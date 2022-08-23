package com.xuanxie.listener;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class PanelTest {
    public static void main(String[] args) {
        Frame frame = new Frame(("节日快乐!"));//新建一个窗口
        Panel panel = new Panel();//面板
        frame.setLayout(null);//设置窗体布局
        frame.setBounds(300,300,500,500);
        frame.setBackground(new Color(0,0,255));
        panel.setBounds(50,50,300,300);
        panel.setBackground(new Color(0,255,0));
        frame.add(panel);
        frame.setVisible(true);
        //无法关闭  需要添加监听事件
        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("窗口打开");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("关闭ing");
                System.exit(0);//正常关闭
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("关闭ed");
                //异常关闭

            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
            }

            @Override
            public void windowActivated(WindowEvent e) {
                System.out.println("激活");

            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                System.out.println("未激活");

            }
        });

    }
}
