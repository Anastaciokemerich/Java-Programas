

import java.io.IOException;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) throws IOException {
        Tabuleiro tabuleiro = new Tabuleiro();
        Pessoa pessoa = new Pessoa();
        Computador computador = new Computador();
        int vet[] = new int[2];
        tabuleiro.exibirMatriz();
        
        int numeroJogadas = 1;
        while (tabuleiro.testarGanhador() && numeroJogadas < 9) {
            String pessoaJogou = "Não";
            String computadorJogou = "Não";

            // Controle de jogada da pessoa
            while (pessoaJogou.equals("Não")) {
                vet = pessoa.solicitarJogada();
                if (tabuleiro.podeJogar(vet[0], vet[1]).equals("Sim")) {
                    tabuleiro.realizarJogada(vet[0], vet[1], 'X');
                    pessoaJogou = "Sim";
                    tabuleiro.exibirMatriz();          
                } else {
                    JOptionPane.showMessageDialog(null, "Jogada já existe, tente outra posição");
                }
            }
            
            numeroJogadas++;

            // Controle de jogada do computador      
            while (computadorJogou.equals("Não")) {  
                vet = computador.solicitarJogada();
                int vetorAtaque[] = tabuleiro.verificarPosicaoDeAtaqueEDefesa('O');
                int vetorDefesa[] = tabuleiro.verificarPosicaoDeAtaqueEDefesa('X');
                 
                if (tabuleiro.posicaoDoMeioEstaLivre().equals("Sim")) {  // na primeira joda tenta no meio
                    tabuleiro.realizarJogada(1, 1, 'O');
                    computadorJogou = "Sim";
                    tabuleiro.exibirMatriz();
                }
                else if (tabuleiro.posicaoDaPonta().equals("Sim") && (tabuleiro.matriz[1][1]) != 'O') {  
                    tabuleiro.realizarJogada(0, 0, 'O'); // se o meio esta ocupado, joga na ponta
                    computadorJogou = "Sim";
                    tabuleiro.exibirMatriz();
                }
                
                else if (vetorAtaque[0]!=9 && vetorAtaque[1]!=9){
                    tabuleiro.realizarJogada(vetorAtaque[0], vetorAtaque[1], 'O');
                    computadorJogou = "Sim";
                    tabuleiro.exibirMatriz();
                }
                
                else if (vetorDefesa[0]!=9 && vetorDefesa[1]!=9){
                    tabuleiro.realizarJogada(vetorDefesa[0], vetorDefesa[1], 'O');
                    computadorJogou = "Sim";
                    tabuleiro.exibirMatriz();
                }
                
                else if (tabuleiro.podeJogar(vet[0], vet[1]).equals("Sim")) {
                    tabuleiro.realizarJogada(vet[0], vet[1], 'O');
                    computadorJogou = "Sim";
                    tabuleiro.exibirMatriz();
                } 
                
                else {
                    vet = computador.solicitarJogada();
                }
            }
            
            numeroJogadas++;
            
           
        }
        
        if (numeroJogadas==9) {
            JOptionPane.showMessageDialog(null, "Empate");
        }    


    }

}
