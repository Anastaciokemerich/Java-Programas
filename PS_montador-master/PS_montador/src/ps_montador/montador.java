/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ps_montador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Formatter;
import java.util.Scanner;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author leonardo
 */
public class montador {
    
    File arquivo;
    BufferedReader br;
    BufferedWriter bw;
    FileReader fr;
    FileWriter fw;
    
    String matriz[][] = new String[30][3];
    String tabela_simb[][] = new String[30][3];
    String tabela_def[][] = new String[30][3];
    String tabela_uso[][] = new String[30][4];
    int opcode_saida = 0;
    String Entrada;
    int cont = 0;
    int cont_def = 0;
    int cont_uso = 0;
    
    
    public void set_matriz(int x, int y, String key){
        this.matriz[x][y] = key;
    }
    
    public String get_matriz(int x, int y){
        return this.matriz[x][y];
    }
    
    public void montador(String s){
        this.Entrada = s;
        
    }
    
    public boolean verifica_tab(String s){
        for(int i=0; i<cont;i++){
            if(this.tabela_simb[i][0].equals(s)){
                return true;
            }
        }
        return false;
    }
    
    public int verifica_tab_pos(String s){
        for(int i=0; i<cont;i++){
            if(this.tabela_simb[i][0].equals(s)){
                return i;
            }
        }
        return 0;
    }
    
    public String get_pos(String s){
        for(int i=0; i<cont;i++){
            if(this.tabela_simb[i][0].equals(s)){
                return this.tabela_simb[i][1];
            }
        }
        return null;
    }
    
    public void imprimir() throws IOException{
        System.out.println("");
        //-----------------------------------
        FileWriter saida_t = new FileWriter("tabela_simbolos.txt");
        PrintWriter gravarSaida_t = new PrintWriter(saida_t);
        //-----------------------------------
        for(int i=0; i<10;i++){
            for(int j=0; j<3;j++){
                if(!" ".equals(this.tabela_simb[i][j])){
                    System.out.print(this.tabela_simb[i][j]);
                    System.out.print("      ");
                    gravarSaida_t.printf(this.tabela_simb[i][j]+" ");
                }
            }
            if(!" ".equals(this.tabela_simb[i][0])){
                System.out.print("\n");
                gravarSaida_t.printf("%n");
            }
        }
        gravarSaida_t.close();
    }
    
    public void imprimir_def() throws IOException{
        FileWriter saida1 = new FileWriter("tab_def.txt");
        PrintWriter gravarSaida1 = new PrintWriter(saida1);
        System.out.println("");
        for(int i=1; i<20;i++){
            if("0".equals(this.tabela_def[i][1])){
                gravarSaida1.printf("SEGMENT" + " " + "NULL" + " " + "NULL" + "%n");
            }
            
            for(int j=0; j<3;j++){
                
                if(!" ".equals(this.tabela_def[i][j])){
                    System.out.print(this.tabela_def[i][j]);
                    System.out.print("      ");
                    gravarSaida1.printf(this.tabela_def[i][j]+" ");
                }
            }
            if(!" ".equals(this.tabela_def[i][0])){
                System.out.print("\n");
                gravarSaida1.printf("%n");
            }
        }
        gravarSaida1.close();
    }
    
    public void imprimir_uso(){
        System.out.println("");
        for(int i=0; i<10;i++){
            for(int j=0; j<4;j++){
                if(!" ".equals(this.tabela_uso[i][j])){
                    System.out.print(this.tabela_uso[i][j]);
                    System.out.print("      ");
                }
            }
            if(!" ".equals(this.tabela_uso[i][0])){
                System.out.print("\n");
            }
        }
    }
    
    public void imprimir2() throws IOException{
        FileWriter saida = new FileWriter("codigo.txt");
        PrintWriter gravarSaida = new PrintWriter(saida);
        for(int i=0; i<30;i++){
            for(int j=0; j<3;j++){
                if(!" ".equals(this.matriz[i][j])){
                    System.out.print(this.matriz[i][j]);
                    System.out.print("      ");
                    gravarSaida.printf(this.matriz[i][j]+" ");
                }
            }
            if(!" ".equals(this.matriz[i][0])){
                System.out.print("\n");
                gravarSaida.printf("%n");
            }
            
        }
        gravarSaida.close();
    }
    
    
    public void primeiropasso() throws IOException{
        
        for(int k=0;k<30;k++){
            for(int h=0;h<3;h++){
                this.tabela_def[k][h]=" ";
                this.tabela_simb[k][h]= " ";
                this.matriz[k][h]= " ";
            }
        }
        
        for(int k=0;k<30;k++){
            for(int h=0;h<4;h++){
                this.tabela_uso[k][h]=" ";
            }
        }
        
        
        //System.out.print(this.Entrada);
        String token="",label="",op1="",op2="";
        StringTokenizer st = new StringTokenizer(this.Entrada,"\n");
        StringTokenizer st1;
        int bytes = 0,tokensDados=0,tokensInstr=0;
        st1 = new StringTokenizer((String) st.nextElement());
        int flag =0, end = 0, aux=1;
       
        token=st1.nextToken();
        this.matriz[0][0]=token;
        token=st1.nextToken();
        this.matriz[0][1]=token;
        
        st1 = new StringTokenizer((String) st.nextElement());
        st1.nextToken();
        token=st1.nextToken();
        this.matriz[1][0]=token;
        
        this.imprimir2();
        
        for(int j=0;st.hasMoreElements()==true || aux==1;j++){//primeiro passo
            //System.out.print(j + " - ");
            st1 = new StringTokenizer((String) st.nextElement());
            label=st1.nextToken();
            if(function(label)==0)
                   token=st1.nextToken();
            else
                    token=label;
            //System.out.println(label+ " - " + token);
            
            end++;
            
            if(token.equals("END") || token.equals("START")){
                end=0;
            }
            
            if (function(token)==1){
                op1=st1.nextToken();
                end++;
                op2=st1.nextToken();
                end++;
                if(!verifica_tab(op1)){
                    this.tabela_simb[cont][0]=op1;
                    cont ++;
                }
                if(!verifica_tab(op2)){
                    this.tabela_simb[cont][0]=op2;
                    cont ++;
                }
            }
            else if (function(token)==2){
                op1=st1.nextToken();
                end++;
                end++;
                this.tabela_simb[cont][0]=label;
                this.tabela_simb[cont][1]=Integer.toString(end-3);
                //System.out.println("TESTE - " + end + " - "+cont);
                cont++;
            }
            else if (function(token)==3){
                this.tabela_uso[cont_uso][0]=label;
                this.tabela_uso[cont_uso][1]=Integer.toString(end);
                this.tabela_uso[cont_uso][2]="r";
                this.tabela_uso[cont_uso][3]="+";
                cont_uso++;
                end --;
            }
            else if (function(token)==4){
                op1=st1.nextToken();
                this.tabela_def[cont_def][0]=op1;
                this.tabela_def[cont_def][1]=Integer.toString(end);
                this.tabela_def[cont_def][2]="r";
                cont_def++;
                end --;
            }
            else if (function(token)==5){
                aux=0;
            }
            else if (function(token)==6){
            }
        }
        for(int i=0;i<30;i++){
            String comp = this.tabela_def[i][0];
            for(int j=0;j<30;j++){
                if(verifica_tab(comp)){
                    int x = verifica_tab_pos(comp);
                    this.tabela_def[i][1] = this.tabela_simb[x][1];
                }
                
            }
                    
        }
        
    }

    public void segundopasso(){
        
        String token="",label,op1,op2;
        StringTokenizer st = new StringTokenizer(this.Entrada,"\n");
        StringTokenizer st1;
        int bytes = 0,tokensDados=0,tokensInstr=0;

        int flag =0, end = 0,aux=1;
        int pos_mem=0;
        int pos=2;
        
        for(int j=2;st.hasMoreElements()==true;j++){//primeiro passo
            st1 = new StringTokenizer((String) st.nextElement());
            
            for(int i=0;st1.hasMoreElements()==true;i++){
                //st1 = new StringTokenizer((String) st.nextElement());
                token=st1.nextToken();
                
                if (function(token)==1){
                    // Aqui q deve colocar o end das variaveis...
                    op1=st1.nextToken();
                    op2=st1.nextToken();
                    //System.out.println("OP1: " + op1);
                    
                    //System.out.println("OP1: " + op1 + "   OP2: " + op2);
                    this.matriz[pos][0]=token;
                    if(verifica_tab_pos(op1) == 0){
                        this.matriz[pos][1] = op1;
                    }
                    this.matriz[pos][1]=Integer.toString(verifica_tab_pos(op1));
                    
                    if(verifica_tab_pos(op2) == 0){
                        this.matriz[pos][2] = op1;
                    }
                    this.matriz[pos][2]=Integer.toString(verifica_tab_pos(op2));
                    pos++;
                }                 
            }
            //pos++;
        }
                
    }
    
    
    
    public int function(String opcode){

        switch(opcode) {
            case "ADD":
                this.opcode_saida=1;
                return 1;
            case "ADDA":
                this.opcode_saida=2;
                return 1;
            case "AND":
                this.opcode_saida=3;
                return 1;
            case "ASL":
                this.opcode_saida=4;
                return 1;
            case "ASR":
                this.opcode_saida=5;
                return 1;
            case "BCLR":
                this.opcode_saida=6;
                return 1;
            case "BSET":
                this.opcode_saida=7;
                return 1;
            case "BTST":
                this.opcode_saida=8;
                return 1;
            case "CLR":
                this.opcode_saida=9;
                return 1;
            case "CMP":
                this.opcode_saida=10;
                return 1;
            case "CMPA":
                this.opcode_saida=11;
                return 1;
            case "DIVS":
                this.opcode_saida=12;
                return 1;
            case "DIVU":
                this.opcode_saida=13;
                return 1;
            case "EOR":
                this.opcode_saida=14;
                return 1;
            case "JMP":
                this.opcode_saida=15;
                return 1;
            case "JSR":
                this.opcode_saida=16;
                return 1;
            case "LSL":
                this.opcode_saida=17;
                return 1;
            case "LSR":
                this.opcode_saida=18;
                return 1;
            case "MOVEA":
                this.opcode_saida=19;
                return 1;
            case "MULS":
                this.opcode_saida=20;
                return 1;
            case "MULU":
                this.opcode_saida=21;
                return 1;
            case "NEG":
                this.opcode_saida=22;
                return 1;
            case "NOP":
                this.opcode_saida=23;
                return 1;
            case "NOT":
                this.opcode_saida=24;
                return 1;
            case "OR":
                this.opcode_saida=25;
                return 1;
            case "SUB":
                this.opcode_saida=26;
                return 1;
            case "SUBA":
                this.opcode_saida=27;
                return 1;
            case "SUBQ":
                this.opcode_saida=28;
                return 1;
            case "TAS":
                this.opcode_saida=29;
                return 1;
            case "TST":
                this.opcode_saida=30;
                return 1;
            case "LD":
                this.opcode_saida=31;
                return 1;
            case "STR":
                this.opcode_saida=32;
                return 1;
            case "NOPD":
                this.opcode_saida=33;
               return 1;
            case "STOP":
                this.opcode_saida=34;
               return 6;
            case "CONST":
                this.opcode_saida=35;
                return 2;
            case "INTUSE":
                this.opcode_saida=35;
                return 3;
            case "INTDEF":
                this.opcode_saida=35;
                return 4;
            case "END":
                this.opcode_saida=35;
                return 5;
            default:
                this.opcode_saida=0;
                return 0;        
        }
    }
    
    public void criar(){
        String nomeArq="gerado.txt";
    //tentando criar arquivo
        try(Formatter saida = new Formatter(nomeArq)) {
            saida.format("Arquivo gerado automaticamente!\n\n...www.terminaldeinformacao.com...");
        }
    //mostrando erro em caso se nao for possivel gerar arquivo
        catch(Exception erro){
            JOptionPane.showMessageDialog(null,"Arquivo nao pode ser gerado!","Erro",0);
        }
        JOptionPane.showMessageDialog(null,"Arquivo '"+nomeArq+"' criado!","Arquivo",1);
    }
    
    
    public String load(){
        
        String mostra= "";
        String nomeArq="gerado.txt"; //Nome do arquivo, pode ser absoluto, ou pastas /dir/teste.txt
        String linha="";
        File arq = new File(nomeArq);

        //Arquivo existe
        if (arq.exists()){
          mostra="Arquivo - '"+nomeArq+"', aberto com sucesso!\n";
          mostra+="Tamanho do arquivo "+Long.toString(arq.length())+"\n";
          //tentando ler arquivo
          try{
            //mostra+="Conteudo:\n";
            //abrindo arquivo para leitura
            FileReader reader = new FileReader(nomeArq);
            //leitor do arquivo
            BufferedReader leitor = new BufferedReader(reader);
            while(true){
              linha = leitor.readLine();
              if(linha == null)
                break;
              mostra = mostra + linha + "\n";
            }
          }
          catch(IOException erro) {}
          //JOptionPane.showMessageDialog(null,mostra,"Arquivo...",1);
        }
        //Se nao existir
        else{
          //JOptionPane.showMessageDialog(null,"Arquivo nao existe!","Erro",0);
        }
        //String content = "";
        return mostra;
    }
}
