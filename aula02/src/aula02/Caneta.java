package aula02;

public class Caneta {

    String nodelo;
    String cor;
    float ponta;
    int carga;
    boolean tampada;
    String modelo;

    void statos() {
        System.out.println("Modelo "+this.modelo);
        System.out.println(" uma caneta " + this.cor);
        System.out.println(" esta caneta tem " + this.ponta);
        System.out.println("Carga " + this.carga);
        System.out.println(" esta tampada " + this.tampada);
        System.out.println("sua carga é: "+carga);
    }

    void rabiscar() {
        if (this.tampada == false) {
            System.out.println("ERRO!nao posso Rabiscar");
        } else {
            System.out.println("Estou Rabiscanso");
        }
    }

    void tampar() {
        this.tampada = true;

    }

    void destampar() {
        this.tampada = false;
    }
}
