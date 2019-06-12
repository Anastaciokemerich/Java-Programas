import java.util.Scanner;

public class menu {
    
    public static void menu(){
         System.out.println("\t BANCO KEMERICH");
        System.out.println("1. ABRIR CONTA CORRENTE");
        System.out.println("2. ABRIR CONTA POUPANÇA");
        System.out.println("3. DEPOSITAR CONTA CORRENTE");
        System.out.println("4. DEPOSITAR CONTA POUPANÇA");
        System.out.println("5. RETIRAR CONTA CORRENTE");
        System.out.println("6. RETIRAR CONTA POUPANÇA:");        
        System.out.println("21. EXIBIR CONTA CORRENTE:");        
        System.out.println("22. EXIBIR CONTA POUPANÇA:");
        System.out.println("00. EXIBIR CONTA POUPANÇA:");
    }

    public static void CORRENTE(){
        System.out.println("ABRIR CONTA CORRENTE.");
    }
    
    public static void POUPANÇA(){
        System.out.println("ABRIR CONTA POUPANÇA.");
    }    
        
    public static void EXIBIR(){
        System.out.println(" EXIBIR CONTA CORRENTE.");
    }
    public static void EXIBIR(){
        System.out.println(" EXIBIR CONTA POUPANÇA.");
    }
    
    public static void main(String[] args) {
        int opcao;
        Scanner entrada = new Scanner(System.in);
        
        do{
            menu();
            opcao = entrada.nextInt();
            
            switch(opcao){
            case 1:
                CORRENTE();
                break;
                
            case 2:
                POUPANÇA();
                break;
                
            case 3:
                EXIBIR();
                break;
                
            case 4:
                EXIBIR();
                break;
            case 00:
                EXIBIR();
                break;
            default:
                System.out.println("Opção inválida.");
            }
        } while(opcao != 0);
    }
}
