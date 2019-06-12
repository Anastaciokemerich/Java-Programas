

public class gravar {

    public BufferedWriter brw;//objeto 
    public BufferedReader br;

    public void gravar() {
        try {
            brw = new BufferedWriter(new FileWriter("22")); //acrecentar conteudo em um Arquivo("ARQ.txt,true)
            brw = write("teteto a ser gravado:");//comando grava uma linha só
            brw.close();

        } catch (exception e) {
        }
    }
    }
