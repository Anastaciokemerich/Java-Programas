
import java.util.Scanner;

public class principal {

    public static void main(String[] args) {
        Scanner digito = new Scanner(System.in);
        int Vetor = 3;
        double[] contVetor = new double[Vetor];

        for (int i = 0; i < Vetor; i++) {
            System.out.println("Insira o contrudo do Vetor" + (i + 1) + "°posição");
            contVetor[i] = digito.nextDouble();
        }
        for (int i = 0; i < Vetor; i++) {
            System.out.println("->" +contVetor[i];
         
        }       
        for (int i = 0; i < Vetor; i++) {
            System.out.println("->" +contVetor[i]+5);
         

}
/*Vetor vetor = new vetor();
        vetor.Vetor = new int[3];
        vetor.Vetor[0] = 9;
        vetor.Vetor[1] = 10;
        vetor.Vetor[2] = 13;*/
