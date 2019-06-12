package aula02;

public class Caneta {

    public String nodelo;
    public String cor;
    float ponta;
    protected int carga;
    private boolean tampada;
    public String modelo;

    void statos() {
        System.out.println("Modelo " + this.modelo);
        System.out.println("E uma caneta " + this.cor);
        System.out.println("esta caneta tem ponta " + this.ponta);
        System.out.println("Carga " + this.carga);
        System.out.println("esta tampada? " + this.tampada);
    }

    public void rabiscar() {
        if (this.tampada == true) {
            System.out.println("ERRO!nao posso Rabiscar");
        } else {
            System.out.println("Estou Rabiscanso");
        }
    }

    public void tampar() {
        this.tampada = true;

    }

    public void destampar() {
        this.tampada = false;
    }
}
