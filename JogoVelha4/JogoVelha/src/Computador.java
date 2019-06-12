
public class Computador implements Jogador {

    @Override
    public int[] solicitarJogada() {
        int vet[] = new int[2];
        vet[0] = (int)(Math.random()*3); // gera um número randômico para a linha
        vet[1] = (int)(Math.random()*3); // gera um número randômico para a coluna
        return vet;
    }
    
    
    
}
