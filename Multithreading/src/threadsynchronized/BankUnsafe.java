package threadsynchronized;

/**
 * @Author:xiang
 * @Date:2020/2/21 18:33
 * 线程不安全：银行取钱
 */
public class BankUnsafe {
    public static void main(String[] args) {
        Account account=new Account(100,"礼金");
        Drawing boy=new Drawing(account,80,"boy");
        Drawing girl=new Drawing(account,90,"girl");
        boy.start();
        girl.start();
    }
}
class Account{
    int money;
    String name;
    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}
class Drawing extends Thread{
    Account account;//取钱的账户
    int drawingMoney;//去的钱数
    int packetTotal;//口袋的钱
    @Override
    public void run() {
        if (account.money-drawingMoney<0){
            return;
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        account.money-=drawingMoney;
        packetTotal+=drawingMoney;
        System.out.println(this.getName()+"-->账户余额为："+account.money);
        System.out.println(this.getName()+"-->口袋的钱为"+packetTotal );
    }
    public Drawing(Account account,int drawingMoney,String name){
        super(name);
        this.account=account;
        this.drawingMoney=drawingMoney;
    }
}
