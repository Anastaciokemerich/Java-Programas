package montadoraulaprogsistemas;

public class MontadorPalavra {
	public int[] registros = new int[10];// R0...R9

	public void setPalavra(String palavra) {
		trataPalavra(palavra);
	}

	public void setRegistros(int registros,int pos, int valor) {
		this.registros[pos] += valor;
	}
	
	
	/*
	 * Imprime todos os registros na tela
	 */
	public void mostraRegistros(){
		for (int i = 0; i < registros.length; i++) {
			System.out.print("R" + i + ": " + registros[i] + "   ");
		}
		System.out.println("");
	}
	
	/*	Pega um inteiro e transforma em binario
	 * 	com bits necessarios
	 */
	private String intToBinary(int decimal, int bits){
		String binary = null;
		
		binary = Integer.toBinaryString(decimal);
		
		binary = nBitsToNBits(binary, bits);
		
		return binary;
	}
	
	/*	Pega a string com n bits e
	 * 	adiciona '0's na frente
	 */
	private String nBitsToNBits(String binary, int bits) {
		while(true) {
			if(binary.length() < bits){
				binary = "0" + binary;
			} else {
				break;
			}
		}
		return binary;
	}
	
	/* Pega o parametro sem o caractere especial 
	*e converte a string para um inteiro!
	*/ 
	private int valorParametro(String parametro, int pos) {
		int intParametro;
		
		parametro = parametro.substring(pos);
		intParametro = Integer.valueOf(parametro);
		
		return intParametro;
	}
	
	private void montaPalavra(String comando, String pParam, String sParam, int caso){
		if(caso == 0){
			System.out.println("Palavra: 00000000" + pParam + sParam);
		} else if(caso == 1) {
			System.out.println("Palavra: 00000001" + pParam + sParam);
		} else if(caso == 2) {
			System.out.println("Palavra: 00000010" + pParam + sParam);
		} else if(caso == 3) {
			System.out.println("Palavra: 00000011" + pParam + "00000000 \nPalavra: " + sParam);
		} else if(caso == 4) {
			System.out.println("Palavra: 00000100" + pParam + sParam);
		} else if(caso == 5) {
			System.out.println("Palavra: 00000101" + pParam + "00000000 \nPalavra: " + sParam);
		}
	};
	
	private void trataPalavra(String palavra) {
		String elementos[] = palavra.split(" ");
		String comando, pParam, sParam;
		
		comando = elementos[0];
		pParam = elementos[1];
		sParam = elementos[2];
		
		int intPrimParam, intSegParam, caso = 0;
		
		if (comando.equals("ADD")) {			
			if (sParam.startsWith("R")) {
				caso = 0;
				
				intPrimParam = valorParametro(pParam, 1);
				intSegParam = valorParametro(sParam, 1);
				pParam = intToBinary((intPrimParam * 24), 8);
				sParam = intToBinary((intSegParam * 24), 8);
				
				setRegistros(registros[intPrimParam], intPrimParam, registros[intSegParam]);
				montaPalavra(comando, pParam, sParam, caso);
			} else if (sParam.startsWith("@")) {
				caso = 1;
				
				intPrimParam = valorParametro(pParam, 1);
				pParam = intToBinary((intPrimParam * 24), 8);
				intSegParam = valorParametro(sParam, 2) * 24;
				sParam = intToBinary(intSegParam, 8);
				
				setRegistros(registros[intPrimParam], intPrimParam, intSegParam);
				montaPalavra(comando, pParam, sParam, caso);
			} else if (sParam.startsWith("#")) {
				intPrimParam = valorParametro(pParam, 1);
				pParam = intToBinary((intPrimParam * 24), 8);
				intSegParam = valorParametro(sParam, 1);
				
				if (intSegParam < 256) {
					caso = 2;
					
					sParam = intToBinary(intSegParam, 8);
				} else {
					caso = 3;
					
					sParam = intToBinary(intSegParam, 24);
				}
				
				setRegistros(registros[intPrimParam], intPrimParam, intSegParam);
				montaPalavra(comando, pParam, sParam, caso);
			} else if (sParam.startsWith("0") || sParam.startsWith("1")) {
				intPrimParam = valorParametro(pParam, 1);
				pParam = intToBinary((intPrimParam * 24), 8);
				intSegParam = Integer.parseInt(sParam, 2);
				
				if (intSegParam < 256) {
					caso = 4;
					
					sParam = nBitsToNBits(sParam, 8);
				} else {
					caso = 5;
					
					sParam = nBitsToNBits(sParam, 24);
				}
				
				setRegistros(registros[intPrimParam], intPrimParam, intSegParam);
				montaPalavra(comando, pParam, sParam, caso);
			}
			
		}else if (comando.equals("SUB")) {
			System.out.println("Comando SUB, ainda não tratado!!!");
		}
		
		mostraRegistros();
	}
}

