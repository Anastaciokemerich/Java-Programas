#include "auxiliar.h"

// Converte de Hexadecimal para Binário:
char *HexaBin(char *hex)
{
	int i = 0;
	char bin[20] = "";
	while( i<strlen(hex) )
	{
		switch( hex[i] )
		{
			case '0':
				strcat(bin,"0000");
				break;
			case '1':
				strcat(bin,"0001");
				break;
			case '2':
				strcat(bin,"0010");
				break;
			case '3':
				strcat(bin,"0011");
				break;
			case '4':
				strcat(bin,"0100");
				break;
			case '5':
				strcat(bin,"0101");
				break;
			case '6':
				strcat(bin,"0110");
				break;
			case '7':
				strcat(bin,"0111");
				break;
			case '8':
				strcat(bin,"1000");
				break;
			case '9':
				strcat(bin,"1001");
				break;
			case 'a':
			case 'A':
				strcat(bin,"1010");
				break;
			case 'b':
			case 'B':
				strcat(bin,"1011");
				break;
			case 'c':
			case 'C':
				strcat(bin,"1100");
				break;
			case 'd':
			case 'D':
				strcat(bin,"1101");
				break;
			case 'e':
			case 'E':
				strcat(bin,"1110");
				break;
			case 'f':
			case 'F':
				strcat(bin,"1111");
				break;
		}
	i++;
	}
	return bin;
} 

// Preenche uma string com zeros:
// -- 'qtde' é a quantidade de bits
char *preencheZeros(char *bin, int qtde)
{
    qtde = qtde - strlen(bin);
    char aux[20];
    strcpy(aux,"");
    while(qtde != 0)
    {
        strcat(aux,"0");
        qtde--;
    }
    strcat(aux, bin);
    return aux;
}

// Verifica se a string passada é um menemônico:
// -- Retorna  1 caso seja de um operador
// -- Retorna  0 caso seja de dois operadores
// -- Retorna -1 caso não seja um menemônico
int eMenemonico(char *string)
{
	if (		strcmp(string, "ADD") == 0  || strcmp(string, "AND") == 0 || strcmp(string, "CMP") == 0  ||
				strcmp(string, "MOV") == 0  || strcmp(string, "OR") == 0  || strcmp(string, "SUB") == 0  ||
				strcmp(string, "XOR") == 0)
				return 0;
	else if (
				strcmp(string, "CALL") == 0 || strcmp(string, "DIV") == 0  || strcmp(string, "IDIV") == 0 ||
				strcmp(string, "IMUL") == 0 || strcmp(string, "JE") == 0   || strcmp(string, "JG") == 0   || 
				strcmp(string, "JGE") == 0  || strcmp(string, "JL") == 0   || strcmp(string, "JLE") == 0  || 
				strcmp(string, "JMP") == 0  || strcmp(string, "JNE") == 0  || strcmp(string, "MUL") == 0  || 
				strcmp(string, "POP") == 0  || strcmp(string, "PUSH") == 0 || strcmp(string, "INC") == 0  || 
				strcmp(string, "DEC") == 0  || strcmp(string, "NOT") == 0 || strcmp(string, "HLT") == 0 )
				return 1;
	else return -1;
}

// Verifica se a string passada é um registrador:
bool eRegistrador(char *string)
{
	return ( strcmp(string, "AL") == 0 || strcmp(string, "AX") == 0 || strcmp(string, "BL") == 0 ||
			 strcmp(string, "BX") == 0 || strcmp(string, "CL") == 0 || strcmp(string, "CX") == 0 || 
			 strcmp(string, "DL") == 0 || strcmp(string, "DX") == 0 || strcmp(string, "AH") == 0 ||
			 strcmp(string, "SP") == 0 || strcmp(string, "BH") == 0 || strcmp(string, "BP") == 0 ||
			 strcmp(string, "CH") == 0 || strcmp(string, "SI") == 0 || strcmp(string, "DH") == 0 ||
			 strcmp(string, "DI") == 0 || strcmp(string, "CS") == 0 || strcmp(string, "DS") == 0 ||
			 strcmp(string, "ES") == 0 || strcmp(string, "SS") == 0 );
}

// Verifica se a string passada é uma memória:
bool eMemoria(char *string)
{
	return (string[0] == '[' && string[ strlen(string) -1] == ']');
}

// Verifica se a string passada é uma label:
bool eLabel(char *string)
{
	return ( string[ strlen(string) - 1 ] == ':'  && strlen(string) >= 2 );
}

// Verifica o modo de endereçamento da string passada:
// -- Retorna 0 se o modo for: Registrador - Registrador
// -- Retorna 1 se o modo for: Memória - Registrador
// -- Retorna 2 se o modo for: Registrador - Memória
// -- Retorna 3 se o modo for: Registrador - Imediato
int modoEnderecamento(char *string)
{

	char *operador1, *operador2;
	operador1 = strtok(string, ",");
	operador2 = strtok(NULL, " ");

	if ( eRegistrador(operador1) && eRegistrador(operador2) )  return 0;
	else if ( eMemoria(operador1) && eRegistrador(operador2) ) return 1;
	else if ( eRegistrador(operador1) && eMemoria(operador2) ) return 2;
	else return 3;
}