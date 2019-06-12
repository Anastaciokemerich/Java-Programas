
public class Logon {

    public String Usuario;
    public int senha;

    @SuppressWarnings("SillyAssignment")
    public Logon(String usuario) {
        this.Usuario = Usuario;
        System.out.println("Ambiente de trabalho" + this.Usuario);
    }

    @SuppressWarnings("SillyAssignment")
    public Logon(String usuario, int senha) {
        this.Usuario = Usuario;
        this.senha = senha;
        if(senha.equals("12345")&& Usuario.equals("admin")){
            System.out.println("Ambiente privado:");
        }
    }
    

   
