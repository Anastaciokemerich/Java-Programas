package montadoraulaprogsistemas;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MontadorAulaProgSistemas {

    public static void main(String[] args) {
        System.out.println("Iniciando o Montador...");
        MontadorPalavra montador = new MontadorPalavra();//Instancio o Montador
        //ABRIR ARQUIVO COM OS COMANDOS EM MNEMÔNICO
        try {
            BufferedReader br = new BufferedReader(new FileReader("entrada"));
                while(br.ready()){
                String linha = br.readLine();
                System.out.println(linha);
                montador.setPalavra(linha);
            }    
            br.close();//fecha o arquivo
        } catch (IOException ex) {
            ex.getMessage();
        }
    
    }
}
