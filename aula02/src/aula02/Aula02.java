package aula02;

public class Aula02 {

    public static void main(String[] args) {
        Caneta c1 = new Caneta();
        c1.cor = "Azul";
        c1.ponta = 0.5f;
        c1.carga = 0;
        c1.tampar();
        c1.statos();
        c1.rabiscar();
        //segunda objeto 
        Caneta c2 = new Caneta();
        c2.modelo = "hostnet";
        c2.cor = "preto";
        c2.destampar();
        c2.statos();
        c2.rabiscar();
            //terceiro objeto 
        Caneta c3 =new Caneta();
        c3.modelo = "kemerich";
        c3.cor = "Verde";
        c3.destampar();
        c3.statos();
        c3.rabiscar();
    }

}
