package montador;

/**
 *
 * @author jprask
 */
public class Palavra {
    public String bin = "";
    
    public Palavra(String op, Registro registros) {
        if(op.toLowerCase().equals("halt"))
            this.bin = "111111111111111111111111";
    }
    
    public Palavra(String op, String param, Registro registros) {
        int operacao = 0;
        int paramVal;
        
        if(param.toLowerCase().startsWith("r"))
            paramVal = registros.acharValor("@" + param);
        else
            paramVal = registros.acharValor(param);
        if(op.toLowerCase().equals("desq")) {
            operacao = 24;
        } else if(op.toLowerCase().equals("ddir")) {
            operacao = 25;
        } else if(op.toLowerCase().equals("jmp"))
            operacao = 26;
        this.bin += identarBinario(Integer.toBinaryString(operacao), 8);
        this.bin += identarBinario(Integer.toBinaryString(paramVal), 8);
        this.bin += "11111111";
    }
    
    public Palavra(String op, String pParam, String sParam, Registro registros) {
        int operacao = 0;
        int pVal = registros.acharValor("@" + pParam);
        int sVal;
        if(sParam.toLowerCase().startsWith("r")) {
            sVal = registros.acharValor("@" + sParam);
        } else {
            sVal = registros.acharValor(sParam);
        }
        if(op.toLowerCase().equals("add")) {
            if(sParam.toLowerCase().startsWith("r")) {
                operacao = 0;
            } else if (sParam.toLowerCase().startsWith("@")) {
                operacao = 1;
            } else if(sParam.toLowerCase().startsWith("#")) {
                if(sVal < 255) {
                    operacao = 2;
                } else {
                    operacao = 3;
                }
            } else if(sParam.toLowerCase().startsWith("1") || sParam.toLowerCase().startsWith("0")) {
                if(sVal < 255) {
                    operacao = 4;
                } else {
                    operacao = 5;
                }
            }
        } else if(op.toLowerCase().equals("sub")) {
            if(sParam.toLowerCase().startsWith("r")) {
                operacao = 6;
            } else if (sParam.toLowerCase().startsWith("@")) {
                operacao = 7;
            } else if(sParam.toLowerCase().startsWith("#")) {
                if(sVal < 255) {
                    operacao = 8;
                } else {
                    operacao = 9;
                }
            } else if(sParam.toLowerCase().startsWith("1") || sParam.toLowerCase().startsWith("0")) {
                if(sVal < 255) {
                    operacao = 10;
                } else {
                    operacao = 11;
                }
            }
        } else if(op.toLowerCase().startsWith("mult")) {
            if(sParam.toLowerCase().startsWith("r")) {
                operacao = 12;
            } else if (sParam.toLowerCase().startsWith("@")) {
                operacao = 13;
            } else if(sParam.toLowerCase().startsWith("#")) {
                if(sVal < 255) {
                    operacao = 14;
                } else {
                    operacao = 15;
                }
            } else if(sParam.toLowerCase().startsWith("1") || sParam.toLowerCase().startsWith("0")) {
                if(sVal < 255) {
                    operacao = 16;
                } else {
                    operacao = 17;
                }
            }
        } else if(op.toLowerCase().startsWith("div")) {
            if(sParam.toLowerCase().startsWith("r")) {
                operacao = 18;
            } else if (sParam.toLowerCase().startsWith("@")) {
                operacao = 19;
            } else if(sParam.toLowerCase().startsWith("#")) {
                if(sVal < 255) {
                    operacao = 20;
                } else {
                    operacao = 21;
                }
            } else if(sParam.toLowerCase().startsWith("1") || sParam.toLowerCase().startsWith("0")) {
                if(sVal < 255) {
                    operacao = 22;
                } else {
                    operacao = 23;
                }
            }
        }
        this.bin += identarBinario(Integer.toBinaryString(operacao), 8);
        this.bin += identarBinario(Integer.toBinaryString(pVal), 8);
        if(sVal < 255) {
            this.bin += identarBinario(Integer.toBinaryString(sVal), 8);
        } else {
            this.bin += "11111111\n\t";
            this.bin += identarBinario(Integer.toBinaryString(sVal), 24);
        }    
    }
    
    public static String identarBinario(String binario, int tam) {
        if(binario.length() > tam)
            return "erro ao identar " + binario;
        if(binario.length() == tam)
            return binario;
        return identarBinario("0"+binario, tam);
    }
}