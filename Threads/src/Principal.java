
public class Principal {

    /**´so é real em processadores multicoore se não e pseldopralelismo
     * 
     * @param args the command line arguments
     */
    //com erança
    public static void main(String[] args) {
        Thread motor = new Motor1();        
        Thread ventuinha = new Thread (new Ventuinha2());       
        Motor1.start();
        Ventuinha2.start();
    }
    
}

