#pragma once
#include "ModoEnderecamento.h"
#include "Mnemonico.h"
#include "Registrador.h"


using namespace std;

class Instrucao{
	public:
		Mnemonico *mne;
		Registrador *reg1;
		Registrador *reg2;
		
		Instrucao();

		/*Mnemonico *getMne();
		ModoEnderecamento *getModo();
		Registrador *getReg1();
		Registrador *getReg2();
		void setMne(Mnemonico *);
		void setModo(ModoEnderecamento *);
		void setReg1(Registrador *);
		void setReg2(Registrador *);
		*/
};