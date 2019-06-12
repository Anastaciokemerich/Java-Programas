#ifndef MONTADOR_H
#define MONTADOR_H

#include "instrucoes.h"
#include "auxiliar.h"

typedef struct {
	char instrucao[10];
	int posdolar;
}tabela;


void fprintfmodo(FILE *fm, enderecamento *end, int modo);
void fprintfcomando(FILE *fm, registradores *reg, tabela *tab, char *string, int qtd, char *menemonico);

void geraarquivodolar(tabela *tab, int qtd);


tabela *dollar(arquivo *arq, int quantidade_linhas);

int contaLabel(arquivo *arq, int quantidade_linhas);

void geraMontador(arquivo *arq, int quantidade_linhas);

#endif