
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Calc {
/*Declaração dos métodos*/
    public int som(int num1, int num2) {
        return num1 + num2;
    }

    public int sub(int num1, int num2) {
        return num1 - num2;
    }

    public int div(int num1, int num2) {
        //verificar divisãopor zerro
        if(num2==0){
                    System.out.println("\"ERRO DIVISÂO POR ZERRO\"4");
                }
        return num1 / num2;
    }

    public int mult(int num1, int num2) {
        return num1 - num2;
    }

    public static void main(String args[]) {
        //criando um objeto c a apartir do metodo calc
        Calc c = new Calc();
        //declarando as varíaveis
        int opcao = 5;
        int num1;
        int num2 = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("|Escolha uma opção|");
        System.out.println("1. Soma");
        System.out.println("2. Subtracao");
        System.out.println("3. Multiplicacao");
        System.out.println("4. Divisao");
        System.out.println("0. Sair");
        // System.out.println("Operação: ");
        opcao = input.nextInt();
        while (opcao != 0) {
            if (opcao == 1) {
                Scanner input1 = new Scanner(System.in);
                System.out.println("Qual o primeiro numero: ");
                num1 = input1.nextInt();
                System.out.println("Qual o segundo numero: ");
                num2 = input1.nextInt();

                int operacao = c.som(num1, num2);
                System.out.println("resultado\n" + operacao);
                break;
            }
            if (opcao == 2) {
                Scanner input1 = new Scanner(System.in);
                System.out.println("Qual o primeiro numero: ");
                num1 = input1.nextInt();
                System.out.println("Qual o segundo numero: ");
                num2 = input1.nextInt();
                int operacao = c.sub(num1, num2);
                System.out.println("resultado\n" + operacao);
                break;
            }
            if (opcao == 3) {
                Scanner input1 = new Scanner(System.in);
                System.out.println("Qual o primeiro numero: ");
                num1 = input1.nextInt();
                System.out.println("Qual o segundo numero: ");
                num2 = input1.nextInt();
                int operacao = c.mult(num1, num2);
                System.out.println("resultado\n" + operacao);
                break;
            }
            if (opcao == 4) {
                Scanner input1 = new Scanner(System.in);
                System.out.println("Qual o primeiro numero: ");
                num1 = input1.nextInt();
                System.out.println("Qual o segundo numero: ");
                num2 = input1.nextInt();
                int operacao = c.div(num1, num2);
                System.out.println("resultado\n" + operacao);
                break;
            } else {
                System.out.println("????");
                break;
            }
        }
    }
}
