public class Principla{
    public static void main(String[] args){
        
        arquivo arquivo = new arquivo();
        arquivo.gravar("Meu Arquivo","EU estou ");
        System.out.println(arquivo.ler("MEU Arquivo"));
    }

    private static class arquivo {

        public arquivo() {
        }

        private void gravar(String meu_Arquivo, String eu_estou_) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private boolean ler(String meu_Arquivo) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}

    