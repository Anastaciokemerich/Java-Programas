#include "arquivo.h"

// Retorna a quantidade de linhas do arquivo lido
int quantidadeDeLinhas(FILE *fp)
{
	rewind(fp); // Garante que o ponteiro esteja no come�o do arquivo;
	int quantidade = 0;
	char *linha;
	while(!feof(fp))
	{
		linha = (char*) malloc (sizeof(char) * 50); 
		fgets(linha, 20, fp);
		quantidade++;
		free(linha); // Garante que o char 'linha' n�o estoure;
	}
	return quantidade;
}

// Armazena todas as linha do arquivo
arquivo *alocaLinhas(FILE *fp)
{
	arquivo *arq = (arquivo*) malloc (sizeof(arquivo) * quantidadeDeLinhas(fp)); // Aloca a quantidade de linhas do arquivo;
	rewind(fp); // Garante que o ponteiro esteja no come�o do arquivo;
	char *linha;
	for ( int i = 0; !feof(fp); i++ )
	{
		linha = (char*) malloc (sizeof(char) * 50);
		fgets(linha, 50, fp);
		if ( linha[ strlen(linha) - 1 ] == 10 ) // �ltima linha n�o pega o caracter ASCII 10, n�o precisa atribuir \0
			linha[ strlen(linha) - 1 ] = '\0'; // Garante que o �ltimo elemento seja \0 pois 'gets' pega um char a mais;
		strcpy(arq[i].linha, linha);
		free(linha);
	}
	return arq;
}