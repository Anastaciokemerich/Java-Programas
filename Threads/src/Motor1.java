
import java.util.concurrent.ExecutionException;

public class Motor1 extends Thread{
    @Override
    public void run(){
        for(int i=0;i<60;i++){
            if(i==45){
            System.out.println("Super aquecimento no Motor"+i);
    try{
        Thread.sleep(3000);
    }catch(InterruptedException e){}
        }
    
    }
    
}
}
