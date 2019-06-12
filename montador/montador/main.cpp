#include "arquivo.h"
#include "interface.h"
#include "validacoes.h"
#include "montador.h"

void cabecalho()
{
	printf("\n %c", 201);
	for ( int i = 0; i < 76; i++)
		printf("%c", 205);
	printf("%c", 187); 
	printf("\n %c Pontificia Universidade Caatolica do Parana - PUCPR                        %c", 186, 186); 
	printf("\n %c Arquitetura e Organizacao de Computadores                                  %c", 186, 186);
	printf("\n %c Alunos: Cristian Simioni Milani & Cicero Lemes Grokoski                    %c", 186, 186);
	printf("\n %c", 200);
	for ( int i = 0; i < 76; i++)
		printf("%c", 205);
	printf("%c\n", 188);

	printf(" %c", 201);
	for ( int i = 0; i < 76; i++)
		printf("%c", 205);
	printf("%c", 187);
	printf("\n %c                        MONTADOR 8086 (8/16 BITS)                           %c", 186, 186); 
	printf("\n %c", 200);
	for ( int i = 0; i < 76; i++)
		printf("%c", 205);
	printf("%c\n ", 188);
}

void main (int argc, char *argv[])
{
	printcolor("", BRANCO | CLARO);
	cabecalho();


	char filename[100];
	printf("\n Digite o nome do arquivo: ");
	fflush(stdin);
	gets(filename);
	
	FILE *fp;
	fp = fopen(filename, "r");

	//FILE *fp;
	//fp = fopen("teste.txt", "r");

	if (fp != NULL)
	{
		printf("\n - Arquivo aberto.");
		arquivo *arq = alocaLinhas(fp);
		int quantidade_linhas = quantidadeDeLinhas(fp);

		if( valida(arq, quantidade_linhas) )
		{
			printcolor("\n - Arquivo carregado com sucesso.", VERDE | CLARO);
			
			geraMontador(arq, quantidade_linhas);
			

			printf("\n - Arquivo dolar gerado com sucesso.");
			printf("\n - Arquivo output gerado com sucesso.");
			printcolor("", BRANCO | CLARO);
		}
		else
		{
			printcolor("\n - Arquivo com erros.", VERMELHO | CLARO);
			printcolor("", BRANCO | CLARO);
		}

		free(arq);
	}

	else
	{
		printcolor("\n - Arquivo nao existe.", VERMELHO | CLARO);
		printcolor("", BRANCO | CLARO);
	}

	getch();
}