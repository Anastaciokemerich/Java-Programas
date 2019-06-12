package montador;

/**
 *
 * @author jprask
 */
public class Registro {
    int registros[] = new int[10];
    
    public Registro() {
        for(int reg : registros)
            reg = 0;
    }
    
    public void exibir() {
        for(int i = 0; i < 10; i ++)
            System.out.print("R" + i + ": " + registros[i] + "\t");
        System.out.println();
    }
    
    public int acharValor(String arg) {
        if(arg.toLowerCase().startsWith("r")) {
            return registros[Integer.valueOf(arg.substring(1))];
        } else if (arg.toLowerCase().startsWith("@")) {
            return Integer.valueOf(arg.substring(2)) * 24;
        } else if (arg.toLowerCase().startsWith("#")) {
            return Integer.valueOf(arg.substring(1));
        } else {
            boolean flag = true;
            for(char c : arg.toCharArray())
                if(c != '0' && c != '1')
                    flag = false;
            if(flag) return Integer.valueOf(arg, 2);
        }
        
        return 8388608;   
    }

    public void atualizarRegistro(String op, String registro) {
        int reg = Integer.valueOf(registro.substring(1));
        if(op.toLowerCase().startsWith("desq")) {
            this.registros[reg] *= 2;
            if(registros[reg] > 8388608) {//1 na 24a casa do registro (criar váriavel para 8388608)
                System.out.println("Ocorrera perda de informaçõeses para o comando " + op + " " + registro);
                this.registros[reg] -= 16777216;
            }
        }
        else if (op.toLowerCase().startsWith("ddir")) {
            this.registros[reg] /= 2;
            if(registros[reg] % 2 != 0) { //numeros ímpares
                System.out.println("Ocorrera perda de informaçõeses (fracional) para o comando " + op + " " + registro);
            }
        }
    }
    
    public void atualizarRegistro(String op, String endereco, String val) {
        int reg = Integer.valueOf(endereco.substring(1));
        int pVal = registros[reg];
        int sVal = acharValor(val);
        if(op.toLowerCase().equals("add")) {
            this.registros[reg] = pVal + sVal;
        } else if(op.toLowerCase().equals("sub")) {
            this.registros[reg] = pVal - sVal;
        } else if(op.toLowerCase().startsWith("mult")) {
            this.registros[reg] = pVal * sVal;
        } else if(op.toLowerCase().startsWith("div")) {
            this.registros[reg] = pVal / sVal;
        }
    }
}