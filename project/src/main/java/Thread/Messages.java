package Thread;

import java.util.Collection;

public class Messages implements Runnable {
   static int taskcount=0;
    final int id=taskcount++;
    public void run() {
        for(int i=0;i<3;i++){
            System.out.println(id+"第"+i+"次接收信息"+this);

        }
    }

}
