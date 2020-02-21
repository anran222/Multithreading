package Thread;

import javax.swing.plaf.nimbus.State;

/**
 * @Author:xiang
 * @Date:2020/2/21 15:48
 * 所有状态
 */
public class AllState {
    public static void main(String[] args) {
        Thread t=new Thread(()->{
            for (int i = 0; i <5 ; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("------");
        });
        //观察状态
        Thread.State state=t.getState();
        System.out.println(state);//NEW

        t.start();
        state=t.getState();
        System.out.println(state);//RUNNABLE

        while(state!=Thread.State.TERMINATED){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            state=t.getState();
            System.out.println(state);//TIMED_WAITING
        }
        state=t.getState();
        System.out.println(state);//TERMINATED
    }
}
