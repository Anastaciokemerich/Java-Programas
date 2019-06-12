
public class Caneta {

    public String modelo;
    private float ponta;
    private boolean tampada;
    private String cor;

    public  Caneta(String m,String c, float p) {//este e o construtor
        this.modelo = m;
        this.cor = c;
        this.ponta = p;
        this.tampar();
    }

    public String getModelo() {
        return this.modelo;
    }

    public String setModelo(String m) {
        return this.modelo = m;
    }

    public float getPonta() {
        return this.ponta;
    }

    public void setPonta(float p) {
        this.ponta = p;
    }

    public void tampar() {
        this.tampada = true;
    }

    public void destampar() {
        this.tampada = false;
    }

    public void status() {
        System.out.println("Sobre a caneta ");
        System.out.println("Modelo " + this.getModelo());
        System.out.println("ponta " + this.ponta);
        System.out.println("Cor " + this.cor);
        System.out.println("Tampada "+this.tampada);
        
    }

    public Caneta(String modelo, float ponta, String cor) {
        this.modelo = modelo;
        this.ponta = ponta;
        this.cor = cor;
    }

    public boolean isTampada() {
        return tampada;
    }

    public void setTampada(boolean tampada) {
        this.tampada = tampada;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
    
}
