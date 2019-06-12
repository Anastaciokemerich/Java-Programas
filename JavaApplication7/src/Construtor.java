/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Anastacio
 */
/*public class Construtor {

    public static void main(String[] arg) {
        Pessoa pessoa = new Pessoa();

        System.out.println("Nome:"+ pessoa.nome +"idade:"+ pessoa.idade);
    }
}

public class Pessoa {
 public String nome;
 public int idade;
public Pessoa() {    
    nome = "Lucio";
    idade = 20;
   }
}
*/

//modo certo de fazer
//sobrecarga e o mesmo metodo se comportar de forma diferente
public class Construtor {

    public static void main(String[] arg) {
    Pessoa pessoa = new Pessoa("lucio",20);
    Pessoa pessoa2 =new Pessoa("pedro:"+21,"pedro@gmail.com");
   // System.out.println(pessoa.nome+" "+pessoa.idade);
       
    }

public class Pessoa {
 public String nome;
 public int idade;
public Pessoa(String  nome,int idade) {    
    this.nome = nome ;
    this.idade = idade;
   }
public Pessoa(String  nome,int idade, String email) {    
    this.nome = nome ;
    this.idade = idade;
    System.out.println("Seu email é:"+email);
}
}
}