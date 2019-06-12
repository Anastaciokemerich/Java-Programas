/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Anastacio
 */
public class liga extends principal{
    @SuppressWarnings("FieldNameHidesFieldInSuperclass")
    String marca;
    liga(){
        super("FIAT");
        marca="UNO";
    
    
    marca = "GM";
        super.marca = "GM";
        this.marca = "VW";
    //verificar se o super atibui valor na metado e no attributo    
    System.out.println(super.marca);
        System.out.println(this.marca);
}
}

    
