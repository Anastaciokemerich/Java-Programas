import java.util.Scanner;

public class GerenciadordoJogo {

    private final boolean jogador1venceu = false;
    private final boolean jogador2venceu = false;
    private final boolean fimDoJogo = false;
    int [] [] matrizVelha = new int[3][3];

    private int vezDoJogador=1;

    private final Scanner teclado = new Scanner(System.in);

    void iniciar(){

        System.out.println("####################################################");
        System.out.println("      Seja bem vindo ao jogo da velha ");
        System.out.println("####################################################");

        while(!fimDoJogo){

            imprimirEstado();
            realizaJogada();
        }

    }

    void imprimirEstado(){
        System.out.println("__________");
        for(int i = 0; i<3;i++) {
            for(int j = 0; j<3;j++) {
                imprimiMarcacao(matrizVelha[i][j]);
            }
            System.out.println();
        }  
        System.out.println("__________");
    }

    void imprimiMarcacao(int VezDoJogador){
        switch (VezDoJogador) {
            case 1:
                System.out.print(" X ");
                break;
            case 2:
                ComputadorJoga();
                break;
            default:
                System.out.print("   ");
                break;
        }
    }



    boolean  realizaJogada(){
        boolean posicaoPermitida=true;
        int linha,coluna;

        do{
            System.out.println("Jogador "+ vezDoJogador);
            System.out.println("Digite a linha entre 1 e 3");
            linha = teclado.nextInt();
            System.out.println("Digite a coluna entre 1 e 3");
            coluna = teclado.nextInt();

            if(linha<=3 & linha >=1 & coluna<=3 & coluna >=1 & matrizVelha[linha-1][coluna-1]>0){
                System.out.println("Jogada inválida");
                posicaoPermitida = false;
            }
            else{
                matrizVelha[linha-1][coluna-1] = vezDoJogador;
                posicaoPermitida=true;
            }


        }while(!posicaoPermitida);



        vezDoJogador = ((vezDoJogador ) %2) + 1; // atualiza o jogador!

        avaliaEstadoDoJogo();

        return false;// não finaliza o jogo

    }

    void avaliaEstadoDoJogo(){



    }


    void apresentarResultado(){

        if(jogador1venceu){
               System.out.println("O jogador 1 venceu!!!");
        }
        else if (jogador2venceu){
               System.out.println("O jogador 2 venceu!!!");
        }
        else{
            System.out.println("Empate técnico!");
   }
 }
}