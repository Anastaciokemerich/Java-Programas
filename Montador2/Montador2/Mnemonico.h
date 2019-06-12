#pragma once
#include <string>
#include "ModoEnderecamento.h"


using namespace std;

class Mnemonico{
	public:
		string nome;
		string opcode;
		int qtdOperandos;
		ModoEnderecamento *modo;
		
		Mnemonico();

		/*string getNome();
		string getOpcode();
		int getQtdOperandos();
		ModoEnderecamento getModoEnderecamento();
		void setNome(string);
		void setOpcode(string);
		void setQtdOperandos(int);
		void setModoEnderacamento(ModoEnderecamento*);*/
};