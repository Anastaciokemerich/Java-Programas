
public class ControleRenoto implements controlador{

    private int volume;
    private boolean ligar;
    private boolean tocando;

    ControleRenoto() {
        this.volume = 10;
        this.ligar = false;
        this.tocando = false;
    }

    private int getVolume() {
        return volume;
    }

    private void setVolume(int volume) {
        this.volume = volume;
    }

    private boolean getLigar() {
        return ligar;
    }

    private void setLigar(boolean ligar) {
        this.ligar = ligar;
    }

    private boolean getTocando() {
        return tocando;
    }

    private void setTocando(boolean tocando) {
        this.tocando = tocando;
    }
    
    
//metodos abristratos
    @Override
    public void ligar() {
     this.setLigar(true);
    }

    @Override
    public void desligar() {
        this.setLigar(false);
    }

    @Override
    public void abriMenu() {
        System.out.println("_____MENU_____");
        System.out.println("Esta ligada "+this.getLigar());
        System.out.println("Esta tocando "+this.getTocando());
        System.out.print("volume "+this.getVolume());
        for(int i=0;i<=this.getVolume();i+=10){
            System.out.print("|");
        }
        System.out.println("");
    }

    @Override
    public void fecharMenu() {
        System.out.println("Fechando Menu....");
    }

    @Override
    public void maisVolume() {
        if(this.getLigar()){
            this.setVolume(this.getVolume()+5);
        }
    }

    @Override
    public void menosVolume() {
        if(this.getLigar()){
           this.setVolume(this.getVolume()-5);
        }
    }

    @Override
    public void ligarMudo() {
        if(this.getLigar()&& this.getVolume()>0){
            this.setVolume(0);
        }
    }

    @Override
    public void desligarMudo() {
        if(this.getLigar()&& this.getVolume()==0){
            this.setVolume(50);
        }
    }

    @Override
    public void play() {
        if(this.getLigar()&&!(this.getTocando())){
            this.setTocando(true);
        }
    }

    @Override
    public void pause() {
        if(this.getTocando()&&this.getTocando()){
            this.setTocando(false);
        }
    }
    
}
