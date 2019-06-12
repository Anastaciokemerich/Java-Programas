/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Anastacio
 */
public class figura {
    public void desenhar(int lado){
        System.out.println("DESENHAR UM QUADRADOCOM LADO"+lado);
    }
    
    public static void desenhar(int base ,int altura) {
        System.out.println("DESENHAR UM RETANGLO DE "+base"X",+altura"Y");
    }

    void desenhar(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
