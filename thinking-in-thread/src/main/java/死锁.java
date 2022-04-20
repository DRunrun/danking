/**
 * 死锁（Dead Lock）指的是两个或两个以上的运算单元（进程、线程或协程），都在等待对方停止执行，
 * 以取得系统资源，但是没有一方提前退出，就称为死锁。
 *
 * @author djq
 * @date 2021/9/24 16:34
 */
public class 死锁 {
    public static void main(String[] args) {
        /**
         * 1、死锁的形成分为两个方面  一个是使用内置锁（synchronized）形成的死锁
         * 另一种是使用显式锁lock实现的死锁
         */
        // 死锁 synchronized版
        //deadLock1();
        // 死锁 Lock版
        deadLock2();
    }

    /**
     * 死锁 Lock版
     */
    private static void deadLock2() {
        // 创建锁A、锁B
        Object lockA = new Object();
        Object lockB = new Object();
        // 创建线程1
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                
            }
        });
    }

    /**
     * 死锁 synchronized版
     */
    private static void deadLock1() {
        // 创建锁A、锁B
        Object lockA = new Object();
        Object lockB = new Object();
        //创建线程1
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lockA){
                    System.out.println("线程 1 : 获取到锁A");
                    try {
                        Thread.sleep(1000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    System.out.println("线程 1:等待获取 B..");
                    synchronized (lockB){
                        System.out.println("线程 1: 获取到锁B");
                    }
                }
            }
        });
        // 运行线程
        t1.start();
        // 创建线程2
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lockB){
                    System.out.println("线程 2 : 获取到锁B");
                    try {
                        Thread.sleep(1000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    System.out.println("线程 2:等待获取 A..");
                    synchronized (lockA){
                        System.out.println("线程 2: 获取到锁A");
                    }
                }
            }
        });
        // 运行线程
        t2.start();
    }
}
