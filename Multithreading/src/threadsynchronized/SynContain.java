package threadsynchronized;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author:xiang
 * @Date:2020/2/22 14:43
 * 线程安全，并发容器
 */
public class SynContain {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list=new CopyOnWriteArrayList<String>();
        for (int i = 0; i <10000 ; i++) {
            new Thread(()->{
                list.add(Thread.currentThread().getName());
            }).start();
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }
}
