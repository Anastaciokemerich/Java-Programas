
public class Ventuinha2 implements Runnable{

    static void start() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 @Override
    public void run(){
    for(int i=0;i<60;i++){
        if(i==10){
        System.out.println("refrigeração esta desligada"+i);
        try{
        Thread.sleep(3000);
    }catch(InterruptedException e){}
    }
}
}
}
