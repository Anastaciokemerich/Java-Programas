/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodavelhaterminal;

import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author Anastacio
 */
public class NewClass extends JFrame {
    
    public static void main(String[] args) {
        (ERROR);
    }

    public NewClass() {
        super();
    }

    public void acao(int bnt) {
        String XO;
        if (quemJoga == 0) {
            XO = "X";
            quemJoga = 1;
            guia.setText("Vez do Jogador 2");
        } else {
            XO = "O";
            quemJoga = 0;
            guia.setText("Vez do Jogador 1");
        }
        button[bnt].setText(XO);
        button[bnt].setEnabled(false);
        verifica(XO);
    }

    public boolean verifica(String XO) {
        //verificações horizontais
        if ((button[0].getText().equals(XO)) && (button[1].getText().equals(XO)) && (button[2].getText().equals(XO))) {
            button[0].setBackground(Color.green);
            button[1].setBackground(Color.green);
            button[2].setBackground(Color.green);
            ganhou(XO);
            return true;
        }
        if ((button[3].getText().equals(XO)) && (button[4].getText().equals(XO)) && (button[5].getText().equals(XO))) {
            button[3].setBackground(Color.green);
            button[4].setBackground(Color.green);
            button[5].setBackground(Color.green);
            ganhou(XO);
            return true;
        }
        if ((button[6].getText().equals(XO)) && (button[7].getText().equals(XO)) && (button[8].getText().equals(XO))) {
            button[6].setBackground(Color.green);
            button[7].setBackground(Color.green);
            button[8].setBackground(Color.green);
            ganhou(XO);
            return true;
        }
        //verificaçoes verticais
        if ((button[0].getText().equals(XO)) && (button[3].getText().equals(XO)) && (button[6].getText().equals(XO))) {
            button[0].setBackground(Color.green);
            button[3].setBackground(Color.green);
            button[6].setBackground(Color.green);
            ganhou(XO);
            return true;
        }
        if ((button[1].getText().equals(XO)) && (button[4].getText().equals(XO)) && (button[7].getText().equals(XO))) {
            button[1].setBackground(Color.green);
            button[4].setBackground(Color.green);
            button[7].setBackground(Color.green);
            ganhou(XO);
            return true;
        }
        if ((button[2].getText().equals(XO)) && (button[5].getText().equals(XO)) && (button[8].getText().equals(XO))) {
            button[2].setBackground(Color.green);
            button[5].setBackground(Color.green);
            button[8].setBackground(Color.green);
            ganhou(XO);
            return true;
        }
        //verificações diagonais
        if ((button[0].getText().equals(XO)) && (button[4].getText().equals(XO)) && (button[8].getText().equals(XO))) {
            button[0].setBackground(Color.green);
            button[4].setBackground(Color.green);
            button[8].setBackground(Color.green);
            ganhou(XO);
            return true;
        }
        if ((button[2].getText().equals(XO)) && (button[4].getText().equals(XO)) && (button[6].getText().equals(XO))) {
            button[2].setBackground(Color.green);
            button[4].setBackground(Color.green);
            button[6].setBackground(Color.green);
            ganhou(XO);
            return true;
        }
        //verifica se deu velha
        if ((!"   ".equals(button[0].getText())) && (!"   ".equals(button[1].getText())) && (button[2].getText() != "   ") && (button[3].getText() != "   ") && (button[4].getText() != "   ") && (button[5].getText() != "   ") && (button[6].getText() != "   ") && (button[7].getText() != "   ") && (button[8].getText() != "   ")) {
            for (int i = 0; i < 9; i++) {
                button[i].setBackground(Color.red);
            }
            velha();
            return true;
        }
        return true;
    }

    public void velha() {
        for (int i = 0; i < 9; i++) {
            button[i].setEnabled(false);
        }
        button1.setVisible(true);
        guia.setText("Deu Velha");
    }

    public void ganhou(String XO) {
        for (int i = 0; i < 9; i++) {
            button[i].setEnabled(false);
        }
        String texto;
        if ("X".equals(XO)) {
            texto = "Jogador 1 Venceu";
            pnt1++;
        } else {
            texto = "Jogador 2 Venceu";
            pnt2++;
        }
        Lpnt1.setText(Integer.toString(pnt1));
        Lpnt2.setText(Integer.toString(pnt2));
        button1.setVisible(true);
        guia.setText(texto);
    }

    public void newGame() {
        button1.setVisible(false);
        guia.setText("Vez do Jogador 1");
        quemJoga = 0;
        for (int i = 0; i < 9; i++) {
            button[i].setText("   ");
            button[i].setBackground(button1.getBackground());
            button[i].setEnabled(true);
        }
    }
    
}
