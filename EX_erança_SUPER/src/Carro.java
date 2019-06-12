/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Anastacio
 */
public class Carro extends Veiculo {
    String nome;
   Carro() {
        super("FIAT");
        nome="UNO";
        Exibirmenssagen();
        // no construtor e clamar a classe mãe acima
        //super.Exibirmenssagen();
        marca = "GM";
        super.marca = "chevrolett";
        this.marca = "VW";
    //verificar se o super atibui valor na metado e no attributo    
    System.out.println(super.marca);
        System.out.println(this.marca);
    }    
//   @Override 
   public void Exibirmenssagen(){
       System.out.println("EU SOU A SUBCLASSE");
   } 
}