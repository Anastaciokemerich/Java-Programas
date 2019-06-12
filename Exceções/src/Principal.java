
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Digite o 1º Valor");
                int valor1 = scanner.nextInt();
                System.out.println("Digite o 2º valor");
                int valor2 = scanner.nextInt();
                int resultado = divisao(valor1, valor2);
                System.out.println("Resultado" + resultado);
            } catch (ArithmeticException) {
                System.out.println("Erro na divisão por Zero");
            } catch (InputMismatchException) {
                System.out.println("qual a parte do digitar valor vc não intendeu");
            } catch (Exception e) {
            }
        }     
        
    public static divisao(int v1, int v2) {
        return v1 / v2;
    }
}
}
