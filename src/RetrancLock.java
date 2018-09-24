import java.util.concurrent.locks.ReentrantLock;

public class RetrancLock implements Runnable {

    public static ReentrantLock lock = new ReentrantLock();

    public static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        RetrancLock test = new RetrancLock();
        Thread t1 = new Thread(test);
        Thread t2 = new Thread(test);
        t1.start();
        t2.start();
       // t1.join();
        t2.join(); // main线程会等待t1和t2都运行完再执行以后的流程
        System.out.println(i);
    }

    @Override
    public void run() {
        for (int j = 0; j < 10000; j++) {
            lock.lock();  // 看这里就可以
            //lock.lock(); ①
            try {
                i++;
            } finally {
                lock.unlock(); // 看这里就可以
                //lock.unlock();②
            }
        }
    }
}
