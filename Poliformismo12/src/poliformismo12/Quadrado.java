/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poliformismo12;

/**
 *
 * @author Anastacio
 */
class Quadrado extends Figuras {
 @Override
 public void /*desenhar*/ (int lado) {
        System.out.println("SOBRESCRITA");
        System.out.println("DSENHA DO QUADRADO"+lado);
    }   
}
