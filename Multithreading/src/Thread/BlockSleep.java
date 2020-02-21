package Thread;

/**
 * @Author:xiang
 * @Date:2020/2/21 14:31
 * 模拟倒计时
 */
public class BlockSleep {
    public static void main(String[] args) {
        int num=10;
        while (num>=0){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(num--+"\r");
        }
    }
}
