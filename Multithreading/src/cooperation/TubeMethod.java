package cooperation;

import threadsynchronized.SynContain;

/**
 * @Author:xiang
 * @Date:2020/2/22 16:01
 * 生产者消费者模式；管程法
 */
public class TubeMethod {
    public static void main(String[] args) {
        SynContainer container=new SynContainer();
        new Productor(container).start();
        new Customer(container).start();
    }
}
//生产者
class Productor extends Thread{
    SynContainer container;
    public Productor(SynContainer container){
        this.container=container;
    }
    @Override
    public void run() {
        for (int i = 0; i <100 ; i++) {
            System.out.println("生产-->"+i+"馒头");
            container.push(new Bun(i));
        }
    }
}
//消费者
class Customer extends Thread{
    SynContainer container;
    public Customer(SynContainer container){
        this.container=container;
    }
    @Override
    public void run() {
        for (int i = 0; i <100 ; i++) {
            System.out.println("消费-->"+container.pop().id+"馒头");
            container.push(new Bun(i));
        }
    }
}
//缓冲区
class SynContainer{
    Bun[] buns=new Bun[100];
    int count=0;
    //存储
    public synchronized void push(Bun bun){
        //何时生产 容器存在空间
        //不能生产
        if (count==buns.length){
            try {
                this.wait();//线程阻塞  消费者通知生产解除
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //存在空间，可以生产
        buns[count]=bun;
        count++;
        //存在数据，可以通知消费
        this.notifyAll();
    }
    //获取
    public synchronized Bun pop(){
        //何时消费 容器中是否存在数据
        //没有数据，只有等待
        if (count==0){
            try {
                this.wait();//线程阻塞 生产者通知消费解除阻塞
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //存在数据可以消费
        count--;
        Bun bun=buns[count];
        this.notifyAll();//存在空间可以唤醒生产
        return bun;
    }
}
class Bun{
    int id;
    public Bun(int id) {
        this.id = id;
    }
}