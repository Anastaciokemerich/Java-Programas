/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maestro;

/**
 *
 * @author Anastacio
 */
public class Cadastro_pessoas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       // criar o objeto do tipo pessoa da minha classe
       //criar o objeto(instaciar a classe)
       Pessoa pessoa = new Pessoa();
       //
       //Gravar os dados no objeto
        Pessoa.nome = "Pedro";
        Pessoa.email ="atsta@cc.br";
        //Pessoa.idade = "32";
        //ler obter dados gravados
        System.out.println("Nome: " +Pessoa.nome);
        System.out.println("email: " +Pessoa.email");
         //cadastrar(pessoa);        
    }
    
}
