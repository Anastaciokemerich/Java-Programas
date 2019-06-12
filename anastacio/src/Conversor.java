package montadoraulaprogsistemas;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Conversor {

	
	public String preencheBits(String numero, int tam){
		int size = numero.length();
		while(size<tam){
			numero = "0"+numero;
			size++;
		}
		return numero;
	}
	
	public String converteDecBinario8bits(int numero){
		String numBin = Integer.toBinaryString(numero);
		//System.out.println("em bin:"+numBin);
		int x=8, y=numBin.length();
		while(y<x){
			numBin = "0"+numBin;
			y++;
		}
		//System.out.println("em bin:"+numBin);
		
		//return Integer.toBinaryString(numero);
		return numBin;
	}
	
	public String converteDecBinario24bits(int numero){
		String sNumBIN = String.valueOf(Integer.toBinaryString(numero));
		System.out.println(sNumBIN);
		return "";

	}
	
	public int converteBinarioDec(String numero){
		return 0;
	}
	
	public String converteDec8bits(String numero){
		return "";
	}
	
	public String converteDec24bits(int numero){
		String sNumero = Integer.toBinaryString(numero);
		int tam = sNumero.length(), aux=24;
		while(tam<aux){
			sNumero = "0"+sNumero;
			tam++;
		}
		return sNumero;
	}
	
	public int numeroRegistro(String parametro){
		return Integer.valueOf(parametro.substring(1));
	}
	
}
