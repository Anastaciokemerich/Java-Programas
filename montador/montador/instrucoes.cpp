#include "instrucoes.h"

// Aloca a tabela de registradores (8/16 bits):
registradores *alocaRegistradores()
{
	registradores *reg;
	reg = (registradores*) malloc (sizeof(registradores));

	// Registradores de 8 bits:
	strncpy(reg->AL, "00000000", 8); reg->AL[8] = '\0';
	strncpy(reg->BL, "00000001", 8); reg->BL[8] = '\0';
	strncpy(reg->CL, "00000010", 8); reg->CL[8] = '\0';
	strncpy(reg->DL, "00000011", 8); reg->DL[8] = '\0';
	strncpy(reg->AH, "00000100", 8); reg->AH[8] = '\0';
	strncpy(reg->BH, "00000101", 8); reg->BH[8] = '\0';
	strncpy(reg->CH, "00000110", 8); reg->CH[8] = '\0';
	strncpy(reg->DH, "00000111", 8); reg->DH[8] = '\0';
	// Registradores de 16 bits:
	strncpy(reg->AX, "00001000", 8); reg->AX[8] = '\0';
	strncpy(reg->BX, "00001001", 8); reg->BX[8] = '\0';
	strncpy(reg->CX, "00001010", 8); reg->CX[8] = '\0';
	strncpy(reg->DX, "00001011", 8); reg->DX[8] = '\0';
	strncpy(reg->SP, "00001100", 8); reg->SP[8] = '\0';
	strncpy(reg->BP, "00001101", 8); reg->BP[8] = '\0';
	strncpy(reg->SI, "00001110", 8); reg->SI[8] = '\0';
	strncpy(reg->DI, "00001111", 8); reg->DI[8] = '\0';
	strncpy(reg->CS, "00010000", 8); reg->CS[8] = '\0';
	strncpy(reg->DS, "00010001", 8); reg->DS[8] = '\0';
	strncpy(reg->ES, "00010010", 8); reg->ES[8] = '\0';
	strncpy(reg->SS, "00010011", 8); reg->SS[8] = '\0';
	 
	return reg;
}

// Aloca a tabela de endereçamento:
enderecamento *alocaEnderecamento()
{
	enderecamento *end;
	end = (enderecamento*) malloc (sizeof(enderecamento));

	strncpy(end->RR, "00", 2); end->RR[2] = '\0';
	strncpy(end->MR, "01", 2); end->MR[2] = '\0';
	strncpy(end->RM, "10", 2); end->RM[2] = '\0';
	strncpy(end->RI, "11", 2); end->RI[2] = '\0';

	return end;
}

// Aloca a tabela de menemônicos:
menemonicos *alocaMenemonicos()
{
	menemonicos *men;
	men = (menemonicos*) malloc (sizeof(menemonicos));

	strncpy(men->ADD,  "000001", 6); men->ADD[6]  = '\0';
	strncpy(men->AND,  "000010", 6); men->AND[6]  = '\0';
	strncpy(men->CALL, "000011", 6); men->CALL[6] = '\0';
	strncpy(men->CMP,  "000100", 6); men->CMP[6]  = '\0';
	strncpy(men->DEC,  "000101", 6); men->DEC[6]  = '\0';
	strncpy(men->DIV,  "000110", 6); men->DIV[6]  = '\0';
	strncpy(men->HLT,  "000111", 6); men->HLT[6]  = '\0';
	strncpy(men->IDIV, "001000", 6); men->IDIV[6] = '\0';
	strncpy(men->IMUL, "001001", 6); men->IMUL[6] = '\0';
	strncpy(men->INC,  "001010", 6); men->INC[6]  = '\0';
	strncpy(men->JE,   "001011", 6); men->JE[6]   = '\0';
	strncpy(men->JG,   "001100", 6); men->JG[6]   = '\0';
	strncpy(men->JGE,  "001101", 6); men->JGE[6]  = '\0';
	strncpy(men->JL,   "001110", 6); men->JL[6]   = '\0';
	strncpy(men->JLE,  "001111", 6); men->JLE[6]  = '\0';
	strncpy(men->JMP,  "010000", 6); men->JMP[6]  = '\0';
	strncpy(men->JNE,  "010001", 6); men->JNE[6]  = '\0';
	strncpy(men->MOV,  "010010", 6); men->MOV[6]  = '\0';
	strncpy(men->MUL,  "010011", 6); men->MUL[6]  = '\0';
	strncpy(men->NOT,  "010100", 6); men->NOT[6]  = '\0';
	strncpy(men->OR,   "010101", 6); men->OR[6]   = '\0';
	strncpy(men->POP,  "010110", 6); men->POP[6]  = '\0';
	strncpy(men->PUSH, "010111", 6); men->PUSH[6] = '\0';
	strncpy(men->RET,  "011000", 6); men->RET[6]  = '\0';
	strncpy(men->SUB,  "011001", 6); men->SUB[6]  = '\0';
	strncpy(men->XOR,  "011010", 6); men->XOR[6]  = '\0';

	return men;
}