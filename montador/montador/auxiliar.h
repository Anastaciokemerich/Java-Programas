#ifndef AUXILIAR_H
#define AUXILIAR_H

#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <conio.h>
#include <Windows.h>
#include <iostream>
#include <math.h>
#include <ctype.h>
#include "arquivo.h"

// Converte de Hexadecimal para Binário:
char *HexaBin(char *hex); 

// Preenche uma string com zeros:
// -- 'qtde' é a quantidade de bits
char *preencheZeros(char *bin, int qtde);

// Verifica se a string passada é um menemônico:
// -- Retorna  0 caso seja de um operador
// -- Retorna  1 caso seja de dois operadores
// -- Retorna -1 caso não seja um menemônico
int eMenemonico(char *string);

// Verifica se a string passada é um registrador:
bool eRegistrador(char *string);

// Verifica se a string passada é uma memória:
bool eMemoria(char *string);

// Verifica se a string passada é uma label:
bool eLabel(char *string);

// Verifica o modo de endereçamento da string passada:
// -- Retorna 0 se o modo for: Registrador - Registrador
// -- Retorna 1 se o modo for: Memória - Registrador
// -- Retorna 2 se o modo for: Registrador - Memória
// -- Retorna 3 se o modo for: Registrador - Imediato
int modoEnderecamento(char *string);

#endif