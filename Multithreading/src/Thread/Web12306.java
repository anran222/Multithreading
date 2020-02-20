package Thread;

/**
 * @Author:xiang
 * @Date:2020/2/20 20:11
 *共享资源，并发（线程安全）
 */
public class Web12306 implements Runnable{
    private int ticketNums=99;

    @Override
    public void run() {
        while (true){
            if (ticketNums<0){
                break;
            }
                System.out.println(Thread.currentThread().getName()+"---->"+ticketNums--);
        }
    }

    public static void main(String[] args) {
        Web12306 web1=new Web12306();
        new Thread(web1,"张三").start();
        new Thread(web1,"李四").start();
        new Thread(web1,"王五").start();
    }
}
