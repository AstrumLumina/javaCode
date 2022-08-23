package com.xuanxie.AsyncService;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class service {
    //异步任务,方法
    @Async
    public void myAsyncService(){
        try {
            System.out.println("服务开始");
            for (int i = 0; i < 3; i++) {
                Thread.sleep(1000);
                System.out.println("服务经行中");
            }
            System.out.println("服务结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
