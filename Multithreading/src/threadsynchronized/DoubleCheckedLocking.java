package threadsynchronized;

import java.lang.Thread;
/**
 * @Author:xiang
 * @Date:2020/2/22 22:04
 * 单例模式：在懒汉式的基础下在多线程环境下，对外存在一个对象
 * 1、构造器私有化，避免外部new构造器
 * 2、提供私有的静态属性，存储对象的地址
 * 3、提供公共的静态方法，获取属性
 */
public class DoubleCheckedLocking {
    //提供私有的静态属性
    private static volatile DoubleCheckedLocking instance;//没有volatile其他线程可能会访问到一个没有被初始化的对象
    //构造器私有化
    private DoubleCheckedLocking(){

    }
    //提供公共的静态方法
    public static DoubleCheckedLocking getInstance(){
        //再次检测
        if (null!=instance){//避免不必要的同步，已经存在对象
            return instance;
        }
        synchronized (DoubleCheckedLocking.class) {
            if (null == instance) {
                instance = new DoubleCheckedLocking();

            }
        }
        return instance;
    }
    public static void main(String[] args) {
        Thread t=new Thread(()->{
            System.out.println(DoubleCheckedLocking.getInstance());
        });
        t.start();
        System.out.println(DoubleCheckedLocking.getInstance());
    }
}
