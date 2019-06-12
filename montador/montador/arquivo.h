#ifndef ARQUIVO_H
#define ARQUIVO_H

#include "auxiliar.h"

// Estrutura Arquivo
typedef struct {
	char linha[50];
}arquivo;

// Retorna a quantidade de linhas do arquivo lido
int quantidadeDeLinhas(FILE *fp);

// Armazena todas as linha do arquivo
arquivo *alocaLinhas(FILE *fp);

#endif