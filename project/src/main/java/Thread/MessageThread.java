package Thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MessageThread {
    public static void main(String[] args) {
//        for(int i=0;i<10;i++){
//            Thread thread=new Thread(new Messages());
//            thread.start();
//        }
        ExecutorService exec= Executors.newSingleThreadExecutor();
        for(int i=0;i<5;i++){
            if(!exec.isShutdown()){
                exec.execute(new Messages());
            }
        }
        exec.shutdown();
        System.out.println("message close");
    }
}
