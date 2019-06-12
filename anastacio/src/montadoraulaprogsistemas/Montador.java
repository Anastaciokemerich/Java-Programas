/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package montadoraulaprogsistemas;

/**
 * Esta classe define como √© o modelo orientado a objetos do Montador baixo
 * n√≠vel
 *
 * @author Mirkos
 */
public class Montador {

    private String palavra;//tamanho 18 caracteres '0 ou 1'
    private int[] registros = new int[10];//R0...R9
    private String naoImporta = "11111111";
    
    /**
     * Inicializa TODOS os registros com o valor ZERO (0)
     */
    public void inicializa(){
    	for(int x = 0; x<10; x++)
    		registros[x]=0;
    }
    
    /**
     * M√©todo que mostra o conte√∫do dos registros
     */
    public void mostraRegistros(){
    	for(int x=0;x<10;x++)
    		System.out.print("R"+x+": "+this.registros[x]+"\t");
    	System.out.println("");//imprime nova linha
    }
    
    /**
     * M√©todo construtor da classe, chamando a inicializa√ß√£o dos registros
     */
    public Montador(){
    	this.inicializa();
    }

    /**
     * @return the palavra
     */
    public String getPalavra() {
        return palavra;
    }

    /**
     * @param palavra the palavra to set
     */
    public Saida setPalavra(String palavra) {
        this.palavra = palavra;
        return trataPalavra(palavra);
    }

    /**
     * @return the registros
     */
    public int[] getRegistros() {
        return registros;
    }

    /**
     * @param registros the registros to set
     */
    public void setRegistros(int[] registros) {
        this.registros = registros;
    }

    private Saida trataPalavra(String palavra) {
    	Saida saida = new Saida();
        String elementos[] = palavra.split(" ");
        String comando, pParam="", sParam="",aux;
        int iSParam;
        comando = elementos[0];
        if(elementos.length>1){
        pParam = elementos[1];
        sParam = elementos[2];
        }
        if(comando.equals("HALT")){
        	saida.setComando("11111111");
        	saida.setPrimeiroP("11111111");
        	saida.setSegundoP("11111111");
        }
        if(comando.equals("ADD")){
        	saida = trataADD(comando, pParam, sParam);   
        }      
        
        if(comando.equals("SUB")){System.out.println("Comando SUB");}
        //pParam = trataEndRegistro(pParam);
        //System.out.println("Comando: "+elementos[0]+" PParam: "+elementos[1]+" SParam: "+elementos[2]);
        System.out.println(saida.getComando()+saida.getPrimeiroP()+saida.getSegundoP());
        //return saida;
        
        if(comando.equals("MULT")){System.out.println("Comando MULT");}
        //pParam = trataEndRegistro(pParam);
        //System.out.println("Comando: "+elementos[0]+" PParam: "+elementos[1]+" SParam: "+elementos[2]);
        System.out.println(saida.getComando()+saida.getPrimeiroP()+saida.getSegundoP());
        return saida;
    }

	private String trataEndRegistro(String param) {
		String numRegistro = param.substring(1);
		int endRegistro = Integer.valueOf(numRegistro)*24;
		//System.out.println("Endereco: "+endRegistro);
		Conversor cnv = new Conversor();
		return cnv.converteDecBinario8bits(endRegistro);
	}

	private Saida trataADD(String comando, String pParam, String sParam) {
		String aux;
		Saida sd = new Saida();
		Conversor conversor = new Conversor();
		int iSParam;
		//System.out.println("Comando ADD");
        
        //Se o segundo par√¢metro come√ßa com R. Ex: ADD R5 R2
        if(sParam.startsWith("R")){sd.setComando("00000000");
        //pego a posi√ß√£o nos registros do primeiro parametro Ex: R7->7
        int end1Param = Integer.valueOf(pParam.substring(1));
        //pego a posi√ß√£o nos registros do segundo parametro
        int end2Param = Integer.valueOf(sParam.substring(1));
        this.registros[end1Param]+=this.registros[end2Param];
        //this.mostraRegistros();
        //System.out.println("A: "+this.trataEndRegistro(pParam)+ " B: "+pParam);
        sd.setPrimeiroP(this.trataEndRegistro(pParam));
        //System.out.println("->:"+sParam);
        sd.setSegundoP(this.trataEndRegistro(sParam));
        }
        
        //Se o segundo par√¢metro come√ßa com @. Ex: ADD R5 @R2
        if(sParam.startsWith("@")){sd.setComando("00000001");
        //pego a posi√ß√£o nos registros do primeiro parametro Ex: R7->7
        int end1Param = Integer.valueOf(pParam.substring(1));
        //do segundo par√¢metro preciso do endere√ßo do registro.
        //Ex: ADD R5 @R2 -> @R2-> 2*24 = 48
        int end2Param = Integer.valueOf(sParam.substring(2));
        //endere√ßo do Registro
        int posicao2Param = end2Param * 24;
        this.registros[end1Param]+=posicao2Param;
        //this.mostraRegistros();
        sd.setPrimeiroP(this.trataEndRegistro(pParam));
        sd.setSegundoP(this.trataEndRegistro(sParam.substring(1)));
        
        }
        if(sParam.startsWith("#"))
            {
                
                aux = sParam.substring(1, sParam.length());
                //Converte a string do segundo par√¢metro, sem o
                // '#' em inteiro! Ex: #33->33
                iSParam = Integer.valueOf(aux);
                
                
                //Estou pegando a posi√ß√£o nos registros do primeiro parametro Ex: R7->7
                //System.out.println(">"+pParam);
                int endereco = Integer.valueOf(pParam.substring(1));
                this.registros[endereco]+=iSParam;
                //this.mostraRegistros();
                if(iSParam>255){
                    sd.setComando("00000011");
                    sd.setPrimeiroP(this.trataEndRegistro(pParam));
                    sd.setSegundoP(this.naoImporta+"\n"
                    +conversor.converteDec24bits(iSParam));
                }else{
                    sd.setComando("00000010");
                    sd.setPrimeiroP(this.trataEndRegistro(pParam));
                    sd.setSegundoP(conversor.converteDecBinario8bits(iSParam));
                }
                
                
            }
        
        //Se o segundo par√¢metro come√ßa com ZERO ou UM. Ex: ADD R3 101
        if(sParam.startsWith("0")||sParam.startsWith("1")){
        	
        	int end1Param = Integer.valueOf(pParam.substring(1));
        	int isParam = Integer.parseInt(sParam, 2);
        	this.registros[end1Param]+= isParam;
        	//this.mostraRegistros();
        	        	
            if(sParam.length()>8){sd.setComando("00000101");
            sd.setPrimeiroP(this.trataEndRegistro(pParam));
            sd.setSegundoP(this.naoImporta+"\n"
            +conversor.preencheBits(sParam, 24));
            }
            else{sd.setComando("00000100");
            sd.setPrimeiroP(this.trataEndRegistro(pParam));
            sd.setSegundoP(conversor.preencheBits(sParam, 8));
            }
                                   }
        this.mostraRegistros();
        return sd;
        }
        
        private Saida trataSUB(String comando, String pParam, String sParam) {
		String aux;
		Saida sd = new Saida();
		Conversor conversor = new Conversor();
		int iSParam;
		//System.out.println("Comando ADD");
        
        //Se o segundo par‚metro comeÁa com R. Ex: ADD R5 R2
        if(sParam.startsWith("R")){sd.setComando("00000000");
        //pego a posiÁ„o nos registros do primeiro parametro Ex: R7->7
        int end1Param = Integer.valueOf(pParam.substring(1));
        //pego a posiÁ„o nos registros do segundo parametro
        int end2Param = Integer.valueOf(sParam.substring(1));
        this.registros[end1Param]+=this.registros[end2Param];
        //this.mostraRegistros();
        //System.out.println("A: "+this.trataEndRegistro(pParam)+ " B: "+pParam);
        sd.setPrimeiroP(this.trataEndRegistro(pParam));
        //System.out.println("->:"+sParam);
        sd.setSegundoP(this.trataEndRegistro(sParam));
        }
        
        //Se o segundo par‚metro comeÁa com @. Ex: ADD R5 @R2
        if(sParam.startsWith("@")){sd.setComando("00000001");
        //pego a posiÁ„o nos registros do primeiro parametro Ex: R7->7
        int end1Param = Integer.valueOf(pParam.substring(1));
        //do segundo par‚metro preciso do endereÁo do registro.
        //Ex: ADD R5 @R2 -> @R2-> 2*24 = 48
        int end2Param = Integer.valueOf(sParam.substring(2));
        //endereÁo do Registro
        int posicao2Param = end2Param * 24;
        this.registros[end1Param]+=posicao2Param;
        //this.mostraRegistros();
        sd.setPrimeiroP(this.trataEndRegistro(pParam));
        sd.setSegundoP(this.trataEndRegistro(sParam.substring(1)));
        
        }
        if(sParam.startsWith("#"))
            {
                
                aux = sParam.substring(1, sParam.length());
                //Converte a string do segundo par‚metro, sem o
                // '#' em inteiro! Ex: #33->33
                iSParam = Integer.valueOf(aux);
                
                
                //Estou pegando a posiÁ„o nos registros do primeiro parametro Ex: R7->7
                //System.out.println(">"+pParam);
                int endereco = Integer.valueOf(pParam.substring(1));
                this.registros[endereco]+=iSParam;
                //this.mostraRegistros();
                if(iSParam>255){
                    sd.setComando("00000011");
                    sd.setPrimeiroP(this.trataEndRegistro(pParam));
                    sd.setSegundoP(this.naoImporta+"\n"
                    +conversor.converteDec24bits(iSParam));
                }else{
                    sd.setComando("00000010");
                    sd.setPrimeiroP(this.trataEndRegistro(pParam));
                    sd.setSegundoP(conversor.converteDecBinario8bits(iSParam));
                }
                
                
            }
        
        //Se o segundo par‚metro comeÁa com ZERO ou UM. Ex: ADD R3 101
        if(sParam.startsWith("0")||sParam.startsWith("1")){
        	
        	int end1Param = Integer.valueOf(pParam.substring(1));
        	int isParam = Integer.parseInt(sParam, 2);
        	this.registros[end1Param]+= isParam;
        	//this.mostraRegistros();
        	        	
            if(sParam.length()>8){sd.setComando("00000101");
            sd.setPrimeiroP(this.trataEndRegistro(pParam));
            sd.setSegundoP(this.naoImporta+"\n"
            +conversor.preencheBits(sParam, 24));
            }
            else{sd.setComando("00000100");
            sd.setPrimeiroP(this.trataEndRegistro(pParam));
            sd.setSegundoP(conversor.preencheBits(sParam, 8));
            }
                                   }
        this.mostraRegistros();
        return sd;
	}
private Saida trataSUB(String comando, String pParam, String sParam) {
		String aux;
		Saida sd = new Saida();
		Conversor conversor = new Conversor();
		int iSParam;
		System.out.println("Comando SUB");
        
        //Se o segundo par‚metro comeÁa com R. Ex: SUB R5 R2
        if(sParam.startsWith("R")){sd.setComando("00000000");
        //pego a posiÁ„o nos registros do primeiro parametro Ex: R7->7
        int end1Param = Integer.valueOf(pParam.substring(1));
        //pego a posiÁ„o nos registros do segundo parametro
        int end2Param = Integer.valueOf(sParam.substring(1));
        this.registros[end1Param]+=this.registros[end2Param];
        //this.mostraRegistros();
        //System.out.println("A: "+this.trataEndRegistro(pParam)+ " B: "+pParam);
        sd.setPrimeiroP(this.trataEndRegistro(pParam));
        //System.out.println("->:"+sParam);
        sd.setSegundoP(this.trataEndRegistro(sParam));
        }
        
        //Se o segundo par‚metro comeÁa com @. Ex: SUB R5 @R2
        if(sParam.startsWith("@")){sd.setComando("00000001");
        //pego a posiÁ„o nos registros do primeiro parametro Ex: R7->7
        int end1Param = Integer.valueOf(pParam.substring(1));
        //do segundo par‚metro preciso do endereÁo do registro.
        //Ex: ADD R5 @R2 -> @R2-> 2*24 = 48
        int end2Param = Integer.valueOf(sParam.substring(2));
        //endereÁo do Registro
        int posicao2Param = end2Param * 24;
        this.registros[end1Param]+=posicao2Param;
        //this.mostraRegistros();
        sd.setPrimeiroP(this.trataEndRegistro(pParam));
        sd.setSegundoP(this.trataEndRegistro(sParam.substring(1)));
        
        }
        if(sParam.startsWith("#"))
            {
                
                aux = sParam.substring(1, sParam.length());
                //Converte a string do segundo par‚metro, sem o
                // '#' em inteiro! Ex: #33->33
                iSParam = Integer.valueOf(aux);
                
                
                //Estou pegando a posiÁ„o nos registros do primeiro parametro Ex: R7->7
                //System.out.println(">"+pParam);
                int endereco = Integer.valueOf(pParam.substring(1));
                this.registros[endereco]+=iSParam;
                //this.mostraRegistros();
                if(iSParam>255){
                    sd.setComando("00000011");
                    sd.setPrimeiroP(this.trataEndRegistro(pParam));
                    sd.setSegundoP(this.naoImporta+"\n"
                    +conversor.converteDec24bits(iSParam));
                }else{
                    sd.setComando("00000010");
                    sd.setPrimeiroP(this.trataEndRegistro(pParam));
                    sd.setSegundoP(conversor.converteDecBinario8bits(iSParam));
                }
                
                
            }
        
        //Se o segundo par‚metro comeÁa com ZERO ou UM. Ex: ADD R3 101
        if(sParam.startsWith("0")||sParam.startsWith("1")){
        	
        	int end1Param = Integer.valueOf(pParam.substring(1));
        	int isParam = Integer.parseInt(sParam, 2);
        	this.registros[end1Param]+= isParam;
        	//this.mostraRegistros();
        	        	
            if(sParam.length()>8){sd.setComando("00000101");
            sd.setPrimeiroP(this.trataEndRegistro(pParam));
            sd.setSegundoP(this.naoImporta+"\n"
            +conversor.preencheBits(sParam, 24));
            }
            else{sd.setComando("00000100");
            sd.setPrimeiroP(this.trataEndRegistro(pParam));
            sd.setSegundoP(conversor.preencheBits(sParam, 8));
            }
                                   }
        this.mostraRegistros();
        return sd;
	}
}

