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

// Converte de Hexadecimal para Bin�rio:
char *HexaBin(char *hex); 

// Preenche uma string com zeros:
// -- 'qtde' � a quantidade de bits
char *preencheZeros(char *bin, int qtde);

// Verifica se a string passada � um menem�nico:
// -- Retorna  0 caso seja de um operador
// -- Retorna  1 caso seja de dois operadores
// -- Retorna -1 caso n�o seja um menem�nico
int eMenemonico(char *string);

// Verifica se a string passada � um registrador:
bool eRegistrador(char *string);

// Verifica se a string passada � uma mem�ria:
bool eMemoria(char *string);

// Verifica se a string passada � uma label:
bool eLabel(char *string);

// Verifica o modo de endere�amento da string passada:
// -- Retorna 0 se o modo for: Registrador - Registrador
// -- Retorna 1 se o modo for: Mem�ria - Registrador
// -- Retorna 2 se o modo for: Registrador - Mem�ria
// -- Retorna 3 se o modo for: Registrador - Imediato
int modoEnderecamento(char *string);

#endif