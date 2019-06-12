
import java.io.BufferedReader;

  
public class ler {
    try{
    br = new BufferedReader(new = FileReader("Arquivo.txt"));
    String linha;
    while((linha = new br.readeLine())!=NULL){
        System.out.println(linha);
    }
    br.close();
}catch(Exption e){}
}
