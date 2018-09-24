public class ThreadOrder {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    try {
                        Thread.sleep(40);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("t1 run:"+i);
                }

            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    try {
                        Thread.sleep(40);
                        //t1.join();//表明当前线程需要在t1线程上等待
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("t2 run:"+i);
                }

            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    try {
                        Thread.sleep(40);
                        t2.join();//表明当前线程需要在t2线程上等待
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("t3 run:"+i);
                }

            }
        });
        t1.start();
        t2.start();
        t3.start();
    }
}


