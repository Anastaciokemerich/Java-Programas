package montador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jprask
 */
public class Montador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        Memoria memoria = new Memoria();
        boolean flag = false;
        String identificador = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader("entrada.txt"));
            while(br.ready()){
                String linha = br.readLine();
                linha = linha.toLowerCase();
                System.out.println(linha);
                if(flag) {
                    memoria.identificadores.put(identificador, linha.split(" ")[0]);
                    flag = false;
                }
                if(linha.contains(":")) { //identificador
                    flag = true;
                    identificador = linha.substring(0, linha.indexOf(":"));
                } else {
                    String numeroLinha = linha.split(" ")[0];
                    memoria.adicionarComando(Integer.valueOf(numeroLinha), linha.substring(numeroLinha.length() + 1));
                }
            }
            br.close();
            memoria.mostrarIdentificadores();
            rodar(memoria, 0, 0);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    private static void rodar(Memoria memoria, int linhaSaida, int indexLinha) throws InterruptedException {//comentar funções, adicionar traduções na memória e salvar arquivo no final
        Palavra palavra = null;

        do {
            String[] elementos = memoria.accComandos.get(indexLinha).split(" "); // indice da linha
            switch (elementos.length) {
                case 1:
                    palavra = new Palavra(elementos[0], memoria.registro);
                    System.out.println();
                    System.out.println("Linha: " + memoria.accLinhas.get(indexLinha)
                            + " Comando:" + memoria.accComandos.get(indexLinha));
                    memoria.registro.exibir();
                    escrever(Palavra.identarBinario(Integer.toBinaryString(linhaSaida), 8)
                            + " " + palavra.bin);
                    return;
                case 2:
                    if(elementos[0].equals("jmp")) {
                        System.out.println("Pulando para linha " + Integer.valueOf(elementos[1],2)
                                + " Indice " + memoria.accLinhas.indexOf(Integer.valueOf(elementos[1], 2)));
                        rodar(memoria, linhaSaida, memoria.accLinhas.indexOf(Integer.valueOf(elementos[1], 2))); // mandar o índice da linha
                        return;
                    } else if(elementos[0].equals("call")) {
                        System.out.println("Chamando linha " + memoria.identificadores.get(elementos[1])
                                + " indice " + memoria.indexDoIdentificador(elementos[1]));
                        rodar(memoria, linhaSaida, memoria.indexDoIdentificador(elementos[1])); //indice da linha que corresponde ao identificador
                        return;
                    } else {
                        palavra = new Palavra(elementos[0], elementos[1], memoria.registro);
                        memoria.registro.atualizarRegistro(elementos[0], elementos[1]);
                    }
                    break;
                case 3:
                    palavra = new Palavra(elementos[0], elementos[1], elementos[2], memoria.registro);
                    memoria.registro.atualizarRegistro(elementos[0], elementos[1], elementos[2]);
                    break;
                default:
                    break;
            }
            System.out.println("");
            System.out.println("Linha: " + memoria.accLinhas.get(indexLinha)
                    + " Comando:" + memoria.accComandos.get(indexLinha));
            memoria.registro.exibir();
            if(palavra != null) {
                escrever(Palavra.identarBinario(Integer.toBinaryString(linhaSaida), 8)
                        + " " + palavra.bin);
            }
            TimeUnit.SECONDS.sleep(1);
            linhaSaida++;
            indexLinha++;
        } while(true);
    }
    
    private static void escrever(String linha) {
        try {
            FileWriter fw = new FileWriter("saida.txt", true);
            PrintWriter pw = new PrintWriter(fw);
            System.out.println(linha);
            pw.println(linha);
            pw.close();
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(Montador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}