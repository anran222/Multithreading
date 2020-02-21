package Thread;

/**
 * @Author:xiang
 * @Date:2020/2/21 14:51
 * join合并线程，插队线程
 */
public class BlockedJoin implements Runnable{
    public static void main(String[] args) {
        BlockedJoin bj=new BlockedJoin();
        Thread t=new Thread(bj);
        t.start();
        for (int i = 0; i <=100 ; i++) {
            if (i==20) {
                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
                System.out.println("main----"+i);
        }
    }
    public void run(){
        for (int i = 0; i <=100 ; i++) {
            System.out.println("fu-----"+i);
        }
    }
}
