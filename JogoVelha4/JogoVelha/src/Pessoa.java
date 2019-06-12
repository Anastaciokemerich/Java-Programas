
import javax.swing.JOptionPane;

public class Pessoa implements Jogador {

 
    @Override
    public int[]solicitarJogada() {
        int vet[]= new int[2];
        vet[0] = Integer.parseInt(JOptionPane.showInputDialog("Informe a linha da jogada:"));
        vet[1] = Integer.parseInt(JOptionPane.showInputDialog("Informe a coluna da jogada:"));
        return vet;
    }
    
    
    
    
    
}
