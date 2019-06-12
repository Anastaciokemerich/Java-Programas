#pragma once
#include "Instrucao.h"
#include "Diretiva.h"
#include <vector>
#include <iostream>
#include <fstream>
#include <string>
#include <sstream>
#include <stdio.h>
#include <stdlib.h>
#include <algorithm>
#include <conio.h>
#include <exception>

using namespace std;

bool isHex(string str){
	return (str[str.size()-1]=='h');		
}

string converteHexaParaBinario(string str){
	int i = 0;
	string ret = "";
	while(i<str.size()){
		switch(str[i]){
			case '0':
				ret += "0000";
				break;
			case '1':
				ret += "0001";
				break;
			case '2':
				ret += "0010";
				break;
			case '3':
				ret += "0011";
				break;
			case '4':
				ret += "0100";
				break;
			case '5':
				ret += "0101";
				break;
			case '6':
				ret += "0110";
				break;
			case '7':
				ret += "0111";
				break;
			case '8':
				ret += "1000";
				break;
			case '9':
				ret += "1001";
				break;
			case 'A':
				ret += "1010";
				break;
			case 'B':
				ret += "1011";
				break;
			case 'C':
				ret += "1100";
				break;
			case 'D':
				ret += "1101";
				break;
			case 'E':
				ret += "1110";
				break;
			case 'F':
				ret += "1111";
				break;
		}
		i++;
	}
	return ret;
}

bool isJump(string str){
	if(str[0]=='j')
		return true;
	else
		return false;
}

bool isJmp(string str){//testa se é um jump puro->jmp
	int i=0;
	string aux="";
	while(i<str.size() && str.size()-1 !=' '){
		aux+=str[i];
		i++;
	}
	if(aux=="jmp")
		return true;
	else
		return false;
}

Mnemonico getMneFromString(string str){
	int i = 0;
	string aux = "";
	Mnemonico mne;
	while(str[i] != ','){
		aux += str[i];
		i++;
	}
	i++;
	mne.nome = aux;
	aux = "";
	while(str[i] != ','){
		aux += str[i];
		i++;
	}
	i++;
	mne.opcode = aux;
	aux = "";
	while(i<str.size()){
		aux += str[i];
		i++;
	}
	mne.qtdOperandos = atoi(aux.c_str());
	return mne;
}


vector<ModoEnderecamento> carregaModoDeEnderecamento(){
//carregar do arquivo
	vector<ModoEnderecamento> ret;
	ifstream file;
	file.open("./tabelas/tbModEnderec.txt");
	if(file.is_open()){
		while(!file.eof()){
			ModoEnderecamento mod;
			mod.tipo = "";
			mod.bits = "";
			string aux;
			getline(file, aux);
			int i = 0;
			while(aux[i] != '='){
				mod.tipo += aux[i];
				i++;
			}
			i++;
			while(i<aux.size()){
				mod.bits += aux[i];
				i++;
			}
			ret.push_back(mod);
		}
	}
	return ret;
}

vector<Diretiva> carregaDiretivas(){
	vector<Diretiva> ret;
	ifstream file;
	file.open("./tabelas/tbDiretivas.txt");
	if(file.is_open()){
		while(!file.eof()){
			Diretiva dir;
			getline(file, dir.nome);
			ret.push_back(dir);
		}
	}
	file.close();
	return ret;
}


vector<Mnemonico> carregaMnemonicos(){
	vector<Mnemonico> vet;
	ifstream file;
	file.open("./tabelas/tbMnemonicos.txt");
	Mnemonico aux;
	if(file.is_open()){
		string strAux;
		while(!file.eof()){
			getline(file, strAux);
			//pega a linha e adiciona no vetor
			aux = getMneFromString(strAux);
			if(aux.qtdOperandos == 1){// caso de jumps
				//aux->modo = new ModoEnderecamento();
				aux.modo->tipo = "xx";//definir os valores para 11
				aux.modo->bits = "xx";//11
			}
			vet.push_back(aux);
		}
	}
	file.close();
	return vet;
}

Registrador getRegistradorFromString(string str){
	int i = 0;
	Registrador ret;
	string aux = "";
	while(str[i] != ','){
		aux += str[i];
		i++;
	}
	i++;
	ret.nome = aux;
	aux = "";
	while(i<str.size()){
		aux += str[i];
		i++;
	}
	ret.identificador = aux;
	return ret;
}

vector<Registrador> carregaRegistradores(){
	vector<Registrador> vet;
	ifstream file;
	file.open("./tabelas/tbRegistradores.txt");
	if(file.is_open()){
		while(!file.eof()){
			string aux;
			getline(file, aux);
			vet.push_back(getRegistradorFromString(aux));
		}
	}
	file.close();
	return vet;
}

bool isComentario(string str){
	return (str[0] == ';');
}

bool isLabel(string str){
	char aux = str[str.size()-1];
	bool ret = aux== ':';
	//return (str[str.size()-1] == ':');
	return ret;
}

bool existeMnemonico(string mne, vector<Mnemonico> vet){
	int i = 0;
	while(i<vet.size()){
		if(mne ==vet[i].nome){
			return true;
		}
		i++;
	}
	return false;
}

bool existeRegistrador(string reg, vector<Registrador> vet){
	int i = 0;
	while(i<vet.size()){
		if(reg ==vet[i].nome){
			return true;
		}
		i++;
	}
	return false;
}

bool existeDiretiva(string dir, vector<Diretiva> vet){
	int i = 0;
	string pal1 = "";
	string pal2 = "";
	while(i<dir.size() && dir[i] != ' '){
		if(dir[i] == ',' || dir[i]==':'){
			return false;
		}
		pal1 += dir[i];
		i++;
	}
	i++;
	while (i<dir.size() && dir[i] != ' '){
		if(dir[i] == ',' || dir[i]==':'){
			return false;
		}
		pal2 += dir[i];
		i++;
	}
	i=0;
	while(i<vet.size()){
		if(pal1 == vet[i].nome || pal2==vet[i].nome){
			return true;
		}
		i++;
	}
	return false;
}

string getMneStringFromStringInstrucao(string str){
	int i = 0;
	string aux = "";
	while(i<str.size() && str[i] != ' '){
		aux += str[i];
		i++;
	}
	return aux;
}

bool opcodeRepetido(vector<Mnemonico> vet){
	int i = 0;
	int j;
	while(i<vet.size()){
		j=i+1;
		while(j<vet.size()){
			if(vet[i].opcode == vet[j].opcode){
				return true;
			}
			j++;
		}
		i++;
	}
	return false;
}

bool is16bits(string registrador){
	return (registrador[registrador.size()-1] == 'x');
}

bool isMemory(string str){
	return (str[str.size()-1]==']' && str[str.size()-3]=='[' );
}

bool isBinario(string str){
	int i =0;
	while (i<str.size()) {
		if (str[i] != '1' && str[i] != '0') {
			return false;
		}
		i++;
	}
	return true;
}

int getQtdVirgulas(string str){
	int i = 0;
	int qtd = 0;
	while(i<str.size()){
		if(str[i]== ','){
			qtd++;
		}
		i++;
	}
	return qtd;
}

bool verificacao(string path, bool echo){
	bool valid = true;
	vector<Mnemonico> vetMne = carregaMnemonicos();
	vector<Registrador> vetReg = carregaRegistradores();	
	vector<Diretiva> vetDir = carregaDiretivas();	
	ifstream file;
	string aux;
	if (echo) cout << "Tabelas carregadas com sucesso" << endl;
	file.open(path.c_str());
	if(file.is_open()){
		int linha = 1;
		while(!file.eof()){
			aux = "";
			while(!file.eof() && aux == ""){
				getline(file, aux);		
			}
			if(file.eof() && aux == "") break;
			//getline(file, aux);			
			if(linha == 1){
				string strTesteJump = "";
				int k = 0;
				while(aux[k] == ' ') k++;
				while(aux[k] != ' '){
					strTesteJump += aux[k];
					k++;
				}
				if(!isJmp(strTesteJump)){
					cout << "A primeira linha precisa ser um jump" << endl;
					getch();
					return false;
				}
			}
			if(!isComentario(aux)){
				if(existeDiretiva(aux, vetDir)){
					if (echo) cout << "Linha " << linha << ": " << aux << " - OK" << endl;
				}else{
					if(!isLabel(aux)){						
						if(existeMnemonico(getMneStringFromStringInstrucao(aux), vetMne)){
							string mne = "";
							string op1 = "";
							string op2 = "";
							string aux2 = "";
							int qtdOperandosLinha = 0;
							int i = 0;
							while(i<aux.size() && aux[i] != ' '){
								aux2 += aux[i];
								i++;
							} 
							i++;
							mne = aux2;
							aux2 = "";
							while(i<aux.size() && aux[i] != ','){
								aux2+= aux[i];
								i++;
							}
							op1 = aux2;
							i++;
							if(mne == "hlt" || mne == "popall" || mne == "pushall" || mne == "ret" || mne == "iret"){
								qtdOperandosLinha = 0;
							}else if(i>=aux.size()){
								qtdOperandosLinha = 1;
							}else{
								qtdOperandosLinha = 2;
								aux2="";
								while(i<aux.size()){
									aux2+= aux[i];
									i++;
								}
								op2 = aux2;
							}
							//retira o primeiro operando
							if(getQtdVirgulas(aux)==1 || getQtdVirgulas(aux)==0){
								if (mne == "call" || mne == "hlt" || mne == "popall" || mne == "pushall" || mne == "ret" || mne == "iret" || getQtdVirgulas(aux)==1 && existeRegistrador(op1,vetReg) || isMemory(op1) || isLabel(op1+':')  ) {
									if(mne == "call" || mne == "push" || mne == "hlt" || mne == "popall" || mne == "pushall" || mne == "ret" || mne == "iret" || mne == "pop" || mne == "hlt" || mne == "xor" || mne == "or" || mne == "and" || mne == "not" || mne == "inc" || mne == "dec"){
										if (echo) cout << "Linha " << linha << ": " << aux << " - OK" << endl;
									}else if(isJump(mne)){
										if (echo) cout << "Linha " << linha << ": " << aux << " - OK" << endl;
									}else if (getQtdVirgulas(aux)==1 && isHex(op2) || (is16bits(op1) && is16bits(op2)) || (!is16bits(op1) && !is16bits(op2) )  ) {
										if (echo) cout << "Linha " << linha << ": " << aux << " - OK" << endl;
										//ok - reg reg 16 bits ou reg reg 8 bits
									}else if(getQtdVirgulas(aux)==1 && existeRegistrador(op1,vetReg) && isMemory(op2)){
										if (echo) cout << "Linha " << linha << ": " << aux << " - OK" << endl;
										//ok - reg memoria
									}else if (getQtdVirgulas(aux)==1 && isMemory(op1) && existeRegistrador(op2,vetReg)) {
										if (echo) cout << "Linha " << linha << ": " << aux << " - OK" << endl;
										//ok - memoria, reg
									}else if (getQtdVirgulas(aux)==1 && existeRegistrador(op1,vetReg) && isBinario(op2)) {
										if (echo) cout << "Linha " << linha << ": " << aux << " - OK" << endl;
										//ok- reg, imediato								
									}else{
										cout << "Linha " << linha << ": " << aux << " - ERRO" << endl;
										valid = false;
									}
								}							
							}else{
								cout << "Linha " << linha << ": " << aux << " - ERRO" << endl;
								valid = false;
							}
						}else{
							valid = false;
							cout << "Linha " << linha << ": " << aux << " - ERRO" << endl;
						}
					}else{
						// pega posição do label
					}
				}
			}
			linha++;
		}
	}
	file.close();
	return valid;
}

typedef struct {
	int pos;
	string label;
	bool achou;
}LabelPos;

typedef struct{
	int pos;
	string dir;
}DiretivaPos;

string tiraDoisPontos(string str){
	string aux = "";
	int i = 0;
	while(i<str.size()-1){
		aux += str[i];
		i++;
	}
	return aux;
}

Diretiva getDiretivaFromStringInst(string str){/////////////////////////////////////////
	Diretiva ret;
	vector<Diretiva> diretivas = carregaDiretivas();
	bool flag = false;
	if(!(str == "hlt" || str =="equ" || str == "proc" || str == "endp")){
		int i = 0;
		ret.nome = "";
		ret.id = "";
		while(str[i] != ' '){
			ret.id += str[i];
			i++;
		}
		i++;
		while(str[i] != ' '){
			ret.nome += str[i];
			i++;
		}
		i++;
		i = 0;
		
		while(i<diretivas.size()){
			if(ret.nome == diretivas[i].nome){
				flag = true;//ret = diretivas[i];				
			}
			i++;
		}
	}else{
		ret.nome = str;
	}
	if(flag){	
		ret.incrementoDolar = 1;
		return ret;
	}
}

Mnemonico montaMnemonicoFromNome(string nome){/////////////////////////////////////////////
	Mnemonico ret;	
	vector<Mnemonico> vet = carregaMnemonicos();
	int i = 0;
	while(i<vet.size()){
		if(nome==vet[i].nome){
			ret = vet[i];
		}
		i++;
	}
	return ret;
}


bool fazOutputDiretivas(string path, vector<Diretiva> vet){
	ofstream file;
	string pathOutput = "";
	int i = 0;
	while(i<path.size()-4){
		pathOutput += path[i];
		i++;
	}
	pathOutput += "tbDiretivas.txt";
	
	file.open(pathOutput.c_str(), fstream::out);
	if(file.fail()){
		cout << "Falhou ao criar arquivos output" << endl;
	}else{
	    
		i = 0;
		while(i< vet.size()){
			string output;
			output += vet[i].id + "=";
			stringstream ss;			
			if(i==vet.size()-1){
				ss << output << vet[i].posDolar;
			}else{
				ss << output << vet[i].posDolar << endl;
			}
			output = ss.str();			
			file.write(output.c_str(), output.size());			
			i++;
		}
	}
	file.close();
	cout << "Arquivo criado: " << pathOutput << endl;
	return true;
}

bool fazOutputLabels(string path, vector<LabelPos> vet){
	ofstream file;
	string pathOutput = "";
	int i = 0;
	while(i<path.size()-4){
		pathOutput += path[i];
		i++;
	}
	pathOutput += "tbLabelsPos.txt";
	
	file.open(pathOutput.c_str(), fstream::out);
	if(file.fail()){
		cout << "Falhou ao criar arquivos output" << endl;
	}else{
	    
		i = 0;
		while(i< vet.size()){
			string output;
			output += vet[i].label + "=";
			stringstream ss;			
			if(i==vet.size()-1){
				ss << output << vet[i].pos;
			}else{
				ss << output << vet[i].pos << endl;
			}
			output = ss.str();			
			file.write(output.c_str(), output.size());			
			i++;
		}
	}
	file.close();
	cout << "Arquivo criado: " << pathOutput << endl;
	return true;
}

string getOp1(string str){
	string ret = "";
	int i = 0;
	while(str[i] != ' '){
		i++;
	}
	i++;
	while(str[i] != ','){
		ret += str[i];
		i++;
	}
	return ret;
}

string getOp2(string str){
	string ret = "";
	int i = 0;
	while(str[i] != ','){
		i++;
	}
	i++;
	while(str[i] == ' '){
		i++;
	}
	//i++;
	while(i<str.size() && str[i] != ' '){
		ret += str[i];
		i++;
	}
	return ret;
}

string pegaNomeFuncaoFromLinha(string linha){
	int i = 0;
	string aux;
	while(i < linha.size() && linha[i] != ' '){
		aux += linha[i];
		i++;
	}	
	std::remove(aux.begin(), aux.end(), ' ');
	std::remove(aux.begin(), aux.end(), ' ');
	return aux;
}


bool fazOutputFuncoes(string path, vector<LabelPos> vet){
	ofstream file;
	string pathOutput = "";
	int i = 0;
	while(i<path.size()-4){
		pathOutput += path[i];
		i++;
	}
	pathOutput += "tbLabelsFunc.txt";
	
	file.open(pathOutput.c_str(), fstream::out);
	if(file.fail()){
		cout << "Falhou ao criar arquivos output" << endl;
	}else{
	    
		i = 0;
		while(i< vet.size()){
			string output;
			output += vet[i].label + "=";
			stringstream ss;			
			if(i==vet.size()-1){
				ss << output << vet[i].pos;
			}else{
				ss << output << vet[i].pos << endl;
			}
			output = ss.str();			
			file.write(output.c_str(), output.size());			
			i++;
		}
	}
	file.close();
	cout << "Arquivo criado: " << pathOutput << endl;
	return true;
}


bool montaArquivoLabelVariavel(string path){	
	int dolar = 0;
	ifstream file;
	file.open(path.c_str());
	string aux;
	vector<Diretiva> diretivas = carregaDiretivas();
	vector<LabelPos> labelPos;
	vector<LabelPos> funcoes;
	vector<Diretiva> diretivasOutput;
	vector<Mnemonico> mnemonicos = carregaMnemonicos();
	vector<Registrador> registradores = carregaRegistradores();
	while(!file.fail() && !file.eof()){
		aux = "";
		while(!file.eof() && aux == "")	getline(file, aux);
		if(file.eof() && aux == "") break;
		//cout << aux << "        dolar: " << dolar << endl;
		if(!isComentario(aux)){
		   if(aux.find("proc") != -1){ //encontra um proc na linha
			   LabelPos auxiliarLabel;
			   auxiliarLabel.label = pegaNomeFuncaoFromLinha(aux);
			   auxiliarLabel.pos = dolar;
			   auxiliarLabel.achou = false;
			   funcoes.push_back(auxiliarLabel);
		   }else if(aux.find("endp") != -1){
			   string aux1 = pegaNomeFuncaoFromLinha(aux);
			   int cont = 0;
			   while(cont < funcoes.size()){
				   if(funcoes[cont].label == aux1){
					   funcoes[cont].achou = true;
				   }
				   cont++;
			   }			   
		   }else if(isLabel(aux)){
			   LabelPos aux2;
			   aux2.pos = dolar;
			   aux2.label = tiraDoisPontos(aux); 
			   labelPos.push_back(aux2);
		   }else{
			   if(existeDiretiva(aux, diretivas)){
				  Diretiva aux3 = getDiretivaFromStringInst(aux);
				  aux3.posDolar = dolar;
				  diretivasOutput.push_back(aux3);
				  dolar++;				  
			   }else{
			       //testa rr, rm, mr ou ri
				   //rr e ri -> dolar += mne.qtdOperandos+1;
				   //rm e mr -> dolar += mne.qtdOperandos+2;
				   Mnemonico mne = montaMnemonicoFromNome(getMneStringFromStringInstrucao(aux));				   				   
				   if(mne.qtdOperandos == 0){
				      dolar += 1;//hlt
				   }else if(mne.qtdOperandos == 1){
					   if( mne.nome == "pop" || mne.nome == "push" || mne.nome == "not" || mne.nome == "inc" || mne.nome == "dec"){
					     dolar += 2;
					  }else if(mne.nome == "call" || isJump(mne.nome)){
					     dolar += 3; // 8 + 16 bits memoria
					  }else{
					     cout << "erro na montagem do dolar na linha: " << aux << endl;
						 return false;
					  }
					}else if(mne.qtdOperandos == 2){
						string op1 = getOp1(aux);
						string op2 = getOp2(aux);
						//op2 é hexa?
						if(!existeRegistrador(op2, registradores) && isHex(op2)){
							op2 = converteHexaParaBinario(op2);
						}

						if(existeRegistrador(op1, registradores) && existeRegistrador(op2, registradores)){ //rr							
							dolar += mne.qtdOperandos + 1;
						}else if(existeRegistrador(op1, registradores) && isMemory(op2)){ // rm
							dolar += mne.qtdOperandos + 2;
						}else if(isMemory(op1) && existeRegistrador(op2, registradores)){//mr							
							dolar += mne.qtdOperandos + 2;
						}else if(existeRegistrador(op1, registradores) && isBinario(op2) ){//ri
							if(is16bits(op1)) dolar += mne.qtdOperandos + 2;
							else dolar += mne.qtdOperandos + 1;
						}else{
							cout << "erro na contagem do dolar na linha: " << aux << endl;
							return false;
						}
				   }
			   }
		   }		
		}	
		dolar;
	}
	int auxFuncoes = 0;
	while(auxFuncoes < funcoes.size()){
		if(!funcoes[auxFuncoes].achou){
			cout << "Erro ao encontrar o fechamento da funcao: " << funcoes[auxFuncoes].label << endl;
			system("pause");
			exit(0);
		}
		auxFuncoes++;
	}
	fazOutputFuncoes(path, funcoes);
	fazOutputDiretivas(path, diretivasOutput);
	fazOutputLabels(path, labelPos);
	
	file.close();
	return true;
}


vector<Diretiva> leTabelaDiretivas(string path){
	string pathIn = "";
	int i = 0;
	while(i<path.size()-4){
		pathIn += path[i];
		i++;
	}
	pathIn += "tbDiretivas.txt";

	//le
	vector<Diretiva> ret;
	ifstream fileIn;
	fileIn.open(pathIn.c_str());
	if(!fileIn.fail()){
		while(!fileIn.eof()){
			string strRead;
			string str = "";
			Diretiva dir;
			getline(fileIn, strRead);
			if(strRead != ""){
				int i = 0;
				while(strRead[i] != '='){
					str += strRead[i];
					i++;
				}
				i++;
				dir.id = str;
				str = "";
				while(i<strRead.size()){
					str += strRead[i];
					i++;
				}
				dir.posDolar = atoi(str.c_str());
				ret.push_back(dir);
			}			
		}
	}
	fileIn.close();
	return ret;
}

vector<LabelPos> leTabelaLabels(string path){
	string pathIn = "";
	int i = 0;
	while(i<path.size()-4){
		pathIn += path[i];
		i++;
	}
	pathIn += "tbLabelsPos.txt";

	//le
	vector<LabelPos> ret;
	ifstream fileIn;
	fileIn.open(pathIn.c_str());
	if(!fileIn.fail()){
		while(!fileIn.eof()){
			string strRead;
			string str = "";
			LabelPos lbl;
			getline(fileIn, strRead);
			int i = 0;
			while(strRead[i] != '='){
				str += strRead[i];
				i++;
			}
			i++;
			lbl.label = str;
			str = "";
			while(i<strRead.size()){
				str += strRead[i];
				i++;
			}
			lbl.pos = atoi(str.c_str());
			ret.push_back(lbl);
		}
	}
	fileIn.close();
	return ret;
}

string getUnicoOp(string str){
	string ret = "";
	int i  = 0;
	while(str[i] != ' '){
		i++;
	}
	i++;
	while(i<str.size()){
		ret += str[i];
		i++;
	}
	return ret;
}



string pegaBitsModo(string modo, vector<ModoEnderecamento> vet){
	int i = 0;
	while(i<vet.size()){
		if(modo == vet[i].tipo){
			return vet[i].bits;
		}
		i++;
	}
}

string completaZeros(string str, bool is16){
	string ret = str;
	if(is16){
		while(ret.size() != 16){
			ret = "0" + ret;
		}
	}else{
		while(ret.size() != 8){
			ret = "0" + ret;
		}
	}
	return ret;
}

string converteBinario(string str, bool isMem){
	string ret;
	char c[16];
	itoa(atoi(str.c_str()),c,2);
	ret = c;
	if(ret != "0" && (atoi(str.c_str())>255 || isMem)){
		return completaZeros(ret,true);
	}else if(ret == "0"){
		return "0000000000000000";
	}else{
		return completaZeros(ret,false);
	}	
}

string intParaString(int i){
   stringstream ss;
   ss << i;
   return ss.str();
}

string pegaPosMemoria(string diretiva, vector<Diretiva> vet){
	int i = 0;
	string aux = "";
	while(i<diretiva.size()){
		if(diretiva[i] != '[' && diretiva[i] != ']'){
			aux += diretiva[i];
		}
		i++;
	}

	i = 0;
	while(i<vet.size()){
		if(vet[i].id == aux){
			string ret = "";
			ret = intParaString(vet[i].posDolar);
			return ret;
		}
		i++;
	}
}

string pegaOpcodeRegistrador(string reg, vector<Registrador> vet){
	int i = 0;
	while(i<vet.size()){
		if(reg == vet[i].nome){
			return vet[i].identificador;			
		}
		i++;
	}
}

string pegaPosicaoLabel(string label, vector<LabelPos> vet){
	int i = 0;
	while(i<vet.size()){
		if(label == vet[i].label){
			return intParaString(vet[i].pos);
		}
		i++;
	}
}

bool existeLabel(string op, vector<LabelPos> labelPosicoes){
	int i = 0;
	while(i<labelPosicoes.size()){
		if(op==labelPosicoes[i].label){
			return true;
		}
		i++;
	}
	return false;
}

vector<LabelPos> leTabelaFuncoes(string path){
	string pathIn = "";
	int i = 0;
	while(i<path.size()-4){
		pathIn += path[i];
		i++;
	}
	pathIn += "tbLabelsFunc.txt";

	//le
	vector<LabelPos> ret;
	ifstream fileIn;
	fileIn.open(pathIn.c_str());
	if(!fileIn.fail()){
		while(!fileIn.eof()){
			string strRead;
			string str = "";
			LabelPos lbl;
			getline(fileIn, strRead);
			int i = 0;
			while(i<strRead.size() && strRead[i] != '='){
				str += strRead[i];
				i++;
			}
			i++;
			lbl.label = str;
			str = "";
			while(i<strRead.size()){
				str += strRead[i];
				i++;
			}
			lbl.pos = atoi(str.c_str());
			if(lbl.label!= "")
				ret.push_back(lbl);
		}
	}
	fileIn.close();
	return ret;
}

bool montador(string path){
	string pathOutput = "bin";
	int i = 0;
	while(path[i] != '.'){
		pathOutput += path[i];
		i++;
	}
	pathOutput += ".txt";
	ifstream fileIn;
	ofstream fileOut;
	//arquivos default
	vector<Registrador> registradores = carregaRegistradores();	
	vector<Diretiva> todasDiretivas = carregaDiretivas();
	vector<ModoEnderecamento> modos = carregaModoDeEnderecamento();

	//arquivos montados
	vector<Diretiva> diretivas = leTabelaDiretivas(path);
	vector<LabelPos> labelPosicoes = leTabelaLabels(path);
	vector<LabelPos> funcoes = leTabelaFuncoes(path);

	fileIn.open(path.c_str());
	fileOut.open(pathOutput.c_str(), fstream::out);
	
	while(!fileIn.eof()){
		string strRead = "";
		string strOut = "";
		while(!fileIn.eof() && strRead =="")	getline(fileIn, strRead);	
		if(fileIn.eof() &&  strRead == "") break;
		if(!isComentario(strRead)){
			if(!isLabel(strRead)){
				if(!existeDiretiva(strRead, todasDiretivas)){
					Mnemonico mne = montaMnemonicoFromNome(getMneStringFromStringInstrucao(strRead));
					if(mne.qtdOperandos == 0){
						strOut = mne.opcode + pegaBitsModo("rr", modos);//hlt
					}else if(mne.qtdOperandos == 1){
						if(mne.nome == "call" || mne.nome == "push" || mne.nome == "pop" || mne.nome == "inc" || mne.nome == "dec" || mne.nome == "not" ){
							string op = getUnicoOp(strRead);	
							if(isMemory(op)){
								//strOut = mne.opcode + pegaBitsModo("mr", modos) + converteBinario(pegaPosMemoria(op, diretivas), true);
								cout << "existe memoria operando com inc,dec ou not!" << endl;
								return false;
							}else if(existeRegistrador(op, registradores)){
								strOut = mne.opcode + pegaBitsModo("rr", modos) + pegaOpcodeRegistrador(op, registradores);
							}else if(mne.nome == "call"){
								strOut = mne.opcode + pegaBitsModo("rr", modos) + converteBinario(pegaPosicaoLabel(op, funcoes),true);
							}
						}else if(isJump(mne.nome)){
							string op = getUnicoOp(strRead);
							if(existeLabel(op, labelPosicoes)){
								strOut = mne.opcode + pegaBitsModo("mr", modos) + converteBinario(pegaPosicaoLabel(op, labelPosicoes), true);
							}else{
								cout << "Erro na linha: " << strRead << endl;								
								fileOut.close();
								remove(pathOutput.c_str());
							}
						}else{
							cout << "erro de montagem na linha: " << strRead << endl;
							return false;
						}
					}else if(mne.qtdOperandos == 2){
						string op1 = getOp1(strRead);
						string op2 = getOp2(strRead);
						//op2 é hexa?
						if(!existeRegistrador(op2, registradores) && isHex(op2)){
							op2 = converteHexaParaBinario(op2);
						}

						if(existeRegistrador(op1, registradores) && existeRegistrador(op2, registradores)){ //rr							
							strOut = mne.opcode + pegaBitsModo("rr", modos) + pegaOpcodeRegistrador(op1, registradores) + (pegaOpcodeRegistrador(op2, registradores));
						}else if(existeRegistrador(op1, registradores) && isMemory(op2)){ // rm
							string aux1 = pegaOpcodeRegistrador(op1, registradores);
							string aux2 = converteBinario(pegaPosMemoria(op2, diretivas), true);
							strOut = mne.opcode + pegaBitsModo("rm", modos) + pegaOpcodeRegistrador(op1, registradores) + converteBinario(pegaPosMemoria(op2, diretivas),true);
						}else if(isMemory(op1) && existeRegistrador(op2, registradores)){//mr							
							strOut = mne.opcode + pegaBitsModo("mr", modos) + converteBinario(pegaPosMemoria(op1, diretivas), true) + pegaOpcodeRegistrador(op2, registradores);
						}else if(existeRegistrador(op1, registradores) && isBinario(op2) ){//ri
							if(op1 == "ax" || op1 == "bx" || op1 == "cx" || op1 == "dx"){
								strOut = mne.opcode + pegaBitsModo("ri", modos) + pegaOpcodeRegistrador(op1, registradores) + completaZeros(op2,true);
							}else{
								strOut = mne.opcode + pegaBitsModo("ri", modos) + pegaOpcodeRegistrador(op1, registradores) + completaZeros(op2,false);
							}
							
						}else{
							cout << "erro de montagem na linha: " + strRead << endl;
							return false;
						}
					}
					
				}else{
					if(strRead.find("proc") == -1 && strRead.find("endp") == -1){
						//verifica a diretiva e enxe de zeros o db
						string strAuxHexa = "";
						int cont = 0;
						while(strRead[cont] != ' '){
							cont ++;
						}
						cont++;
						while(strRead[cont] != ' '){
							cont ++;
						}
						cont ++;
						while(cont<strRead.size()){
							strAuxHexa += strRead[cont];
							cont++;
						}
						strOut = converteHexaParaBinario(strAuxHexa);	
					}
					
				
				}
			}
		}
		if(strOut != ""){
			//quebra de linha
			//strOut += '\n';
			//escreve no output
			fileOut.write(strOut.c_str(), strOut.size());
		}
	}
	//adicionar  no final o endereço do INTERRUPT
	// sao 32 bits
	int cAux = 0;
	bool encontrou = false;
	while(!encontrou && cAux< funcoes.size()){
		if(funcoes[cAux].label == "interrupt"){
			string output = "";			
			output += completaZeros("", true); // pega 16 bits de zeros para o CS
			output += completaZeros(converteBinario(intParaString(funcoes[cAux].pos), true), true);//monta o IP
			fileOut.write(output.c_str(), output.size());
			encontrou = true;
		}
		cAux++;
	}

	fileIn.close();
	fileOut.close();
	ifstream fp = ifstream(pathOutput.c_str());
	if(fp){
		cout << "Arquivo criado: " << pathOutput << endl;
	}else{
		cout << "Arquino não criado. " << endl;
	}
	
	return true;
}

bool existeArquivo(string path){
	fstream fIn;
	fIn.open(path.c_str());
	bool ret = fIn.is_open();
	fIn.close();
	return ret;
}

void doTelaInicial(){
	cout << "--------------------------------------------------------------------------------" << endl;
	cout << "------------------------------------MONTADOR------------------------------------" << endl;
	cout << "--------------------------------------------------------------------------------" << endl;
	cout << "+--------------+  +--------------+ +--------------+  +--------------" << endl;
	cout << "|              |  |              | |              |  |              " << endl;
	cout << "|              |  |              | |              |  |              " << endl;
	cout << "|              |  |              | |              |  |              " << endl;
	cout << "|              |  |              | |              |  |              " << endl;
	cout << "|--------------|  |              | |--------------|  |-------------+ " << endl;
	cout << "|              |  |              | |              |  |             | |       " << endl;
	cout << "|              |  |              | |              |  |             | |       " << endl;
	cout << "|              |  |              | |              |  |             | |_______" << endl;
	cout << "|              |  |              | |              |  |             | |       |" << endl;
	cout << "+--------------+  +--------------+ +--------------+  +-------------+ |_______|" << endl;
	cout << "--------------------------------------------------------------------------------" << endl;
	cout << "--------------------------------------------------------------------------------" << endl;
	cout << "ALUNOS" << endl;
	cout << "Jean Paul Barddal" << endl;
	cout << "Marianne Cruz de Andrade" << endl;
	getch();
}

int main(){
	try{
		doTelaInicial();
		system("cls");
		string path= "";
		//string path = "testeAssembly.txt";
		while(path == ""){
			cout << "Digite o path do arquivo ASM" << endl;
			cin >> path;
		}
		if(existeArquivo(path)){
			if(verificacao(path, false)){
				if(montaArquivoLabelVariavel(path)){
					if(montador(path)){
						cout << "Arquivo montado com sucesso" << endl << endl<< endl;
					}
				}
			}else{
				cout << "Arquivo invalido." << endl;
			}
		}else{
			cout << "Arquivo invalido." << endl;
		}
		//throw (new exception);
		system("pause");
	}catch(exception e){
		cout << "Excecao levantada." << endl;
	}
	
}