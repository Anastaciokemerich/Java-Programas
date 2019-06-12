#include "validacoes.h"
#include "interface.h"
#include "arquivo.h"

bool valida_espacamento(char *string)
{
	int espacos = 0;
	char menemonico[20]; 
	strcpy(menemonico, string);

	// Espaço no fim
	if ( string[ strlen(string) - 1 ] == ' ') return false;

	// Conta espaços existentes na string
	for (int i = 0; i < string[i] != '\0'; i++)
	{
			if ( string[i] == ' ' ) 
				espacos++;
	}

	// HLT
	if ( strstr(menemonico, "HLT") || strstr(menemonico, "hlt") )
	{
		if ( espacos == 0 ) return true;
		else return false;
	}

	// Testa espaçamento label
	if ( eLabel(string) && (espacos == 0) ) return true;

	// Testa espaçamento de declaraçao de variável
	else if ( strstr(string, "db") || strstr(string, "dw") )
	{
		if (espacos == 2) 
			if ( strstr(string, " db ") || strstr(string, " dw ")) return true;
		else return false;
	}

	// Testa espaçamento de menemônicos
	else
	{
		strtok(menemonico, " ");
		strcat(menemonico, " ");
		if (espacos == 1)
		{
			if ( strstr(string, menemonico)) return true;
		}
		else return false;
	}
}
bool valor_hexa(char *string)
{
	for ( int i = 0; i < strlen(string) - 2; i++ )
	{
		if (string [i] != '0' && string [i] != '1' && string [i] != '2' && string [i] != '3' && string [i] != '4' && string [i] != '5' &&
			string [i] != '6' && string [i] != '7' && string [i] != '8' && string [i] != '9' && string [i] != 'a' && string [i] != 'b' &&
			string [i] != 'c' && string [i] != 'd' && string [i] != 'e' && string [i] != 'f' && string [i] != 'A' && string [i] != 'B' &&
			string [i] != 'C' && string [i] != 'D' && string [i] != 'E' && string [i] != 'F')
			return false;
	}
}
bool valida_variavel(char *string, int linha)
{
	char buffer[100]; strcpy(buffer, string);
	char variavel[100]; strcpy(variavel, strtok(buffer, " "));
	char comando[20];  strcpy(comando, strtok(NULL, " "));
	char valor[20]; strcpy(valor, strtok(NULL, "\0"));

	if ( eMenemonico(variavel) != -1 )
	{
		printcolor("", VERMELHO | CLARO);
		printf(" Linha %d - %s - Erro: A variavel nao pode ser um menemonico.\n", linha + 1, string);
		printcolor("", BRANCO | CLARO);
		return false;
	}
	else
	{
		if (strlen(valor) == 1)
		{
			if ( valor[0] != '?' )
			{
				printcolor("", VERMELHO | CLARO);
				printf(" Linha %d - %s - Erro: A variavel so pode ser inicializada com '?' e numero em hexa.\n", linha + 1, string);
				printcolor("", BRANCO | CLARO);
				return false;
			}
			return true;
		}
		else if (valor[strlen(valor) - 1] != 'h' && comando[strlen(valor) - 1] != 'H')
		{
			printcolor("", VERMELHO | CLARO);
			printf(" Linha %d - %s - Erro: Numero em hexa deve terminar com h.\n", linha + 1, string);
			printcolor("", BRANCO | CLARO);
			return false;
		}
		else if ( !valor_hexa(valor) )
		{
			printcolor("", VERMELHO | CLARO);
			printf(" Linha %d - %s - Erro: Valor hexa so pode ter numero e as letras: a, b, c, d, e, f.\n", linha + 1, string);
			printcolor("", BRANCO | CLARO);
			return false;
		}
		else if (strcmp(comando, "db") == 0 && strlen(valor) > 4)
		{
			printcolor("", VERMELHO | CLARO);
			printf(" Linha %d - %s - Erro: Variavel db so aceita 1 bytes.\n", linha + 1, string);
			printcolor("", BRANCO | CLARO);
			return false;
		}
		else if (strcmp(comando, "dw") == 0 && strlen(valor) > 6)
		{
			printcolor("", VERMELHO | CLARO);
			printf(" Linha %d - %s - Erro: Variavel dw so aceita 2 bytes.\n", linha + 1, string);
			printcolor("", BRANCO | CLARO);
			return false;
		}
	}
	return true;
}
bool valida(arquivo *arq, int quantidade_linhas)
{
	bool valida = true;
	printf("\n\n");
	for ( int i = 0; i < quantidade_linhas; i++ )
	{
		// Comentário
		if( arq[i].linha[0] == ';' )
			printf(" Linha %d - %s\n", i + 1, arq[i].linha);

		// Pulou Linha
		else if ( arq[i].linha[0] == '\0' )
		{
			printcolor("", VERMELHO | CLARO);
			printf(" Linha %d - Erro: nao pule linha.\n", i + 1);
			printcolor("", BRANCO | CLARO);
			valida = false;
		}
		// Erro quantidade de espaços
		else if (!valida_espacamento(arq[i].linha))
		{
			printcolor("", VERMELHO | CLARO);
			printf(" Linha %d - %s - Erro: espacamento incorreto.\n", i + 1, arq[i].linha);
			printcolor("", BRANCO | CLARO);
			valida = false;
			if (valida) printf(" Linha %d - %s\n", i + 1, arq[i].linha);
		}
		// Label
		else if ( eLabel(arq[i].linha) )
			printf(" Linha %d - %s\n", i + 1, arq[i].linha);
		// Verifica tudo de variáveis
		else if ( strstr(arq[i].linha, " db ") || strstr(arq[i].linha, " dw "))
		{
			if(!valida_variavel(arq[i].linha, i)) 
				valida = false;
			if (valida) printf(" Linha %d - %s\n", i + 1, arq[i].linha);
		}

		else
			printf(" Linha %d - %s\n", i + 1, arq[i].linha);
		/*// Verifica se o menemônico existe
		else if ( arq[i].linha )
		{
			char menemonico[20];
			if ( eMenemonico(strtok(arq[i].linha, " \0")) )
				printf(" ");
			printf("\t%s", arq[i].linha);

		}*/

	}
	return valida;
}