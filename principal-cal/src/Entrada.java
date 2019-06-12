
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *entrada de dados nas operaçoes da calculadora
 * @author Anastacio
 */
class Entrada {
public String[] lerDados(){
    String vetor[] = new String[3];
    vetor[0]= JOptionPane.showInputDialog( "Digite o primeiro Valor: ");
    vetor[1]= JOptionPane.showInputDialog("Digite o segundo Valor: ");
    vetor[2] =JOptionPane.showInputDialog("Digite a Operação = - * /: ");
    return vetor;
    
}   
   
}
