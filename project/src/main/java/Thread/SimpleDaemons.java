package Thread;

import java.util.concurrent.TimeUnit;

public class SimpleDaemons implements Runnable{
    @Override
    public void run() {
        while (true){
//                TimeUnit.MILLISECONDS.sleep(100);
            System.out.println(Thread.currentThread()+" "+this);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i=0;i<10;i++){
            Thread daemo=new Thread(new SimpleDaemons());
            daemo.setDaemon(true);
            daemo.start();
        }
        System.out.println("ALL daemo start");
//        TimeUnit.MILLISECONDS.sleep(99);
    }
}
