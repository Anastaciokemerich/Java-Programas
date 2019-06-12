/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *processa as informaçoes das entardas
 *
 * @author Anastacio
 */
class processamento {

    public int calcular(String[] vetor) {
        int v1 = Integer.parseInt(vetor[0]);
        int v2 = Integer.parseInt(vetor[1]);
        char op = vetor[2].charAt(0);
        int resultado = 0;
        switch(op):{
            case '+': {
                resultado = v1 + v2;
                break;
            }
        }
        return resultado;
    }
}
