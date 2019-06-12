#ifndef INSTRUCOES_H
#define INSTRUCOES_H

#include "auxiliar.h"

// Estrutura da tabela de registradores:
typedef struct {
	// Registradores de 8 bits:
	char AL[9];
	char BL[9];
	char CL[9];
	char DL[9];
	char AH[9];
	char BH[9];
	char CH[9];
	char DH[9];
	// Registradores de 16 bits:
	char AX[17];
	char BX[17];
	char CX[17];
	char DX[17];
	char SP[17];
	char BP[17];
	char SI[17];
	char DI[17];
	char CS[17];
	char DS[17];
	char ES[17];
	char SS[17];
}registradores;

// Estrutura da tabela de endereçamento:
typedef struct {
	char RR[3];
	char MR[3];
	char RM[3];	
	char RI[3];
}enderecamento;

// Estrutura da tabela de menemônicos:
typedef struct {
	char  ADD[7];
	char  AND[7];
	char CALL[7];
	char  CMP[7];
	char  DEC[7];
	char  DIV[7];
	char  HLT[7];
	char IDIV[7];
	char IMUL[7];
	char  INC[7];
	char   JE[7];
	char   JG[7];
	char  JGE[7];
	char   JL[7];
	char  JLE[7];
	char  JMP[7];
	char  JNE[7];
	char  MOV[7];
	char  MUL[7];
	char  NOT[7];
	char   OR[7];
	char  POP[7];
	char PUSH[7];
	char  RET[7];
	char  SUB[7];
	char  XOR[7];
}menemonicos;

// Aloca a tabela de registradores (8/16 bits):
registradores *alocaRegistradores();

// Aloca a tabela de endereçamento:
enderecamento *alocaEnderecamento();

// Aloca a tabela de menemônicos:
menemonicos *alocaMenemonicos();

#endif