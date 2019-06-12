import java.util.Scanner;

public class menu {
    
    public static void menu(){
        System.out.println("\tCadastro de clientes");
        System.out.println("0. Fim");
        System.out.println("1. Inclui");
        System.out.println("2. Altera");
        System.out.println("3. Exclui");
        System.out.println("4. Consulta");
        System.out.println("Opcao:");
    }

    public static void inclui(){
        System.out.println("Você entrou no método Inclui.");
    }
    
    public static void altera(){
        System.out.println("Você entrou no método Altera.");
    }
    
    public static void exclui(){
        System.out.println("Você entrou no método Exclui.");
    }
    
    public static void consulta(){
        System.out.println("Você entrou no método Consulta.");
    }
    
    public static void main(String[] args) {
        int opcao;
        Scanner entrada = new Scanner(System.in);
        
        do{
            menu();
            opcao = entrada.nextInt();
            
            switch(opcao){
            case 1:
                inclui();
                break;
                
            case 2:
                altera();
                break;
                
            case 3:
                exclui();
                break;
                
            case 4:
                consulta();
                break;
            
            default:
                System.out.println("Opção inválida.");
            }
        } while(opcao != 0);
    }
}
