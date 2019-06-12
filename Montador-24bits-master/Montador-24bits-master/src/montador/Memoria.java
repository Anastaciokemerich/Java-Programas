package montador;


import java.util.*;
import javax.script.SimpleBindings;

/**
 *
 * @author usrlab09
 */
public class Memoria {
    Registro registro;
    List<Integer> accLinhas;
    List<String> accComandos;
    SimpleBindings identificadores;
    
    public Memoria() {
        registro = new Registro();
        accLinhas = new ArrayList<>();
        accComandos = new ArrayList<>();
        identificadores = new SimpleBindings();
    }
    
    public void adicionarComando(Integer noLinha, String comando) {
        accLinhas.add(noLinha);
        accComandos.add(comando);
    }

    int indexDoIdentificador(String idLinha) {
        return accLinhas.indexOf(Integer.valueOf(identificadores.get(idLinha).toString()));
    }

    public void mostrarIdentificadores(){
        for(Object k : identificadores.keySet()) {
            System.out.println("Chave(id): " + String.valueOf(k) + " Linha: " + String.valueOf(identificadores.get(k)));
        }
    }

}
