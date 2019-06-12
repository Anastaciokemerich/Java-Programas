#ifndef VALIDACOES_H
#define VALIDACOES_H

#include "auxiliar.h"

bool valida_espacamento(char *string);
bool valida_variavel(char *string, int linha);

bool valida(arquivo *arq, int quantidade_linhas);

#endif