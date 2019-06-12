package maestro;

/**
 *
 * @author Anastacio
 */
public class cadastro_carros {
    public static void main (String[] arg) {
        Carro carro = new Carro();
        carro.setMarca("vw");
        System.out.println(carro.getChassi());
        
    }
    public class Carro{
        public String marca;
        public String modelo;
        public int anofabricação;
        private String chassi ="12345678";
    
        public String getChassi(){
            return chassi;
        }

        private void setMarca(String vw) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
}
