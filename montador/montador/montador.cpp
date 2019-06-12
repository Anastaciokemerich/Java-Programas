#include "montador.h"

int contaLabel(arquivo *arq, int quantidade_linhas)
{
	int qtd = 0;
	for( int i = 0; i < quantidade_linhas; i++)
	{
		if ( arq[i].linha[0] == ';' );
			

		else if ( arq[i].linha[ strlen(arq[i].linha) - 1] == ':' && 
			!( strstr(arq[i].linha, "CALL") || strstr(arq[i].linha, "JE") || 
			 strstr(arq[i].linha, "JG")  || strstr(arq[i].linha, "JGE") || strstr(arq[i].linha, "JL") ||
			 strstr(arq[i].linha, "JLE") || strstr(arq[i].linha, "JMP") || strstr(arq[i].linha, "JNE")) 
		   )
		   qtd++;
		else if ( strstr(arq[i].linha, "db") || strstr(arq[i].linha, "dw") ) 
			qtd++;
	}
	return qtd;
}
tabela *dollar(arquivo *arq, int quantidade_linhas)
{
	int qtd = contaLabel(arq, quantidade_linhas);
	tabela *tab;
	tab = (tabela*) malloc (sizeof(tabela) * qtd);

	int dolar = 0, k = 0;
	char aux[20];
	
	for( int i = 0; i < quantidade_linhas; i++)
	{
		if ( arq[i].linha[0] == ';' );
		
		else if ( strstr(arq[i].linha, "db") )
		{
			dolar++;
			strcpy(aux, arq[i].linha);
			strcpy(tab[k].instrucao, strtok(aux, " "));
			tab[k].posdolar = dolar;
			k++;
		}
		else if ( strstr(arq[i].linha, "dw") )
		{
			dolar+=2;
			strcpy(aux, arq[i].linha);
			strcpy(tab[k].instrucao, strtok(aux, " "));
			tab[k].posdolar = dolar;
			k++;
		}

		else if( arq[i].linha[ strlen(arq[i].linha) - 1] == ':' && 
			  !( strstr(arq[i].linha, "CALL") || strstr(arq[i].linha, "JE") || strstr(arq[i].linha, "JG") || 
			     strstr(arq[i].linha, "JGE")  || strstr(arq[i].linha, "JL") || strstr(arq[i].linha, "JLE")||  
				 strstr(arq[i].linha, "JMP")  || strstr(arq[i].linha, "JNE")))
		{
			strcpy(tab[k].instrucao, arq[i].linha);
			tab[k].posdolar = dolar + 1;
			k++;
		}
		
		else if (strcmp(arq[i].linha, "HLT") == 0)
		{
			dolar++;
		}
		else
		{
			char menemonico[10], op1[10], op2[10];
			strcpy(aux, arq[i].linha);
			strcpy(menemonico, strtok(aux, " "));
			strcpy(op1, strtok(NULL, ","));

			if ( strstr(arq[i].linha, ",") )
				strcpy(op2, strtok(NULL, "\0"));
		
			if ( eMenemonico(menemonico) == 0 )
			{
				dolar++;
				strcat(op1, ",");
				strcat(op1, op2);

				int modo = modoEnderecamento(op1);
				if (modo == 0) dolar += 2;
				else if (modo == 1) dolar +=3;
				else if (modo == 2) dolar +=3;
				else dolar +=2;
			}
			if ( eMenemonico(menemonico) == 1 )
			{
				dolar++;
				if ( eRegistrador(op1) ) 
					dolar++;
				else if ( eMemoria(op1) ) 
					dolar +=2;
				else
					dolar +=2;
			}
		}
	}
	geraarquivodolar(tab, qtd);
	return tab;
}
void geraarquivodolar(tabela *tab, int qtd)
{
	FILE *dolar;
	dolar = fopen("dolar.txt", "w");
	for ( int i = 0; i < qtd; i++)
	{
		fprintf(dolar, "%s=%d\n", tab[i].instrucao, tab[i].posdolar);
	}
	fclose(dolar);
}


void fprintfmodo(FILE *fm, enderecamento *end, int modo)
{
	// Registrador - Registrador
	if ( modo == 0)
		fprintf(fm, "%s", end->RR);
	// Memória - Registrador
	else if ( modo == 1 )
		fprintf(fm, "%s", end->MR);
	// Registrado - Memória
	else if ( modo == 2 )
		fprintf(fm, "%s", end->RM);
	// Registrador - Imediato
	else
		fprintf(fm, "%s", end->RI);
}

void fprintfcomando(FILE *fm, registradores *reg, tabela *tab, char *string, int qtd, char *menemonico)
{
	char aux[20], operador1[20], operador2[20];
	for (int i = 0; i < 20; i++)
	{
		operador1[i] = '\0';
		operador2[1] = '\0';
	}
	strcpy(operador1, strtok(string, ",\0"));
	if ( (eRegistrador(operador1) || eMemoria(operador1)) && eMenemonico(menemonico) == 0 )
	{
		strcpy(operador2, strtok(NULL, "\0"));
	}
	
	// COMANDO 1
	if ( strcmp(operador1, "AL") == 0 ) 
		fprintf(fm, "%s", reg->AL);
	else if (  strcmp(operador1, "AX") == 0 )
		fprintf(fm, "%s", reg->AX);
	else if (  strcmp(operador1, "BL") == 0 )
		fprintf(fm, "%s", reg->BL);
	else if (  strcmp(operador1, "BX") == 0 )
		fprintf(fm, "%s", reg->BX);
	else if (  strcmp(operador1, "CL") == 0 )
		fprintf(fm, "%s", reg->CL);
	else if (  strcmp(operador1, "CX") == 0 )
		fprintf(fm, "%s", reg->CX);
	else if (  strcmp(operador1, "DL") == 0 )
		fprintf(fm, "%s", reg->DL);
	else if (  strcmp(operador1, "DX") == 0 )
		fprintf(fm, "%s", reg->DX);
	else if (  strcmp(operador1, "AH") == 0 )
		fprintf(fm, "%s", reg->AH);
	else if (  strcmp(operador1, "SP") == 0 )
		fprintf(fm, "%s", reg->SP);
	else if (  strcmp(operador1, "BP") == 0 )
		fprintf(fm, "%s", reg->BP);
	else if (  strcmp(operador1, "CH") == 0 )
		fprintf(fm, "%s", reg->CH);
	else if (  strcmp(operador1, "SI") == 0 )
		fprintf(fm, "%s", reg->SI);
	else if (  strcmp(operador1, "DH") == 0 )
		fprintf(fm, "%s", reg->DH);
	else if (  strcmp(operador1, "DI") == 0 )
		fprintf(fm, "%s", reg->DI);
	else if (  strcmp(operador1, "CS") == 0 )
		fprintf(fm, "%s", reg->CS);
	else if (  strcmp(operador1, "DS") == 0 )
		fprintf(fm, "%s", reg->DS);
	else if (  strcmp(operador1, "ES") == 0 )
		fprintf(fm, "%s", reg->ES);
	else if (  strcmp(operador1, "SS") == 0 )
		fprintf(fm, "%s", reg->SS);
	else
	{
		char bin[10], test[20];
		if (menemonico[0] == 'j' || menemonico[0] == 'J')
		{
			for ( int i = 0; i < 20; i++)
			{
				if (operador1[i] == '\0') 
				{
					operador1[i] = ':';
					break;
				}
			}

		}
		if ( strstr(operador1, "[") && strstr(operador1, "]") )
		{
			char aux[20];
			for (int i = 0; i < 20; i++)
				aux[i] = '\0';
			
			int k = 0;
			for ( int i = 0; i < 20; i++)
			{
				if(operador1[i] != '[' && operador1[i] != ']'){
					aux[k] = operador1[i]; k++;}
			}
			
			strcpy(operador1, aux);
		}
		for ( int i = 0; i<qtd; i++)
		{
			if ( strcmp(operador1, tab[i].instrucao) == 0)
			{
				itoa(tab[i].posdolar, bin, 2);
				strcpy(test, preencheZeros(bin, 16));
				fprintf(fm, "%s", test);
			}
		}
	}

	// COMANDO 2
	if(operador2 != NULL)
	{
		if ( strcmp(operador2, "AL") == 0 ) 
			fprintf(fm, "%s", reg->AL);
		else if (  strcmp(operador2, "AX") == 0 )
			fprintf(fm, "%s", reg->AX);
		else if (  strcmp(operador2, "BL") == 0 )
			fprintf(fm, "%s", reg->BL);
		else if (  strcmp(operador2, "BX") == 0 )
			fprintf(fm, "%s", reg->BX);
		else if (  strcmp(operador2, "CL") == 0 )
			fprintf(fm, "%s", reg->CL);
		else if (  strcmp(operador2, "CX") == 0 )
			fprintf(fm, "%s", reg->CX);
		else if (  strcmp(operador2, "DL") == 0 )
			fprintf(fm, "%s", reg->DL);
		else if (  strcmp(operador2, "DX") == 0 )
			fprintf(fm, "%s", reg->DX);
		else if (  strcmp(operador2, "AH") == 0 )
			fprintf(fm, "%s", reg->AH);
		else if (  strcmp(operador2, "SP") == 0 )
			fprintf(fm, "%s", reg->SP);
		else if (  strcmp(operador2, "BP") == 0 )
			fprintf(fm, "%s", reg->BP);
		else if (  strcmp(operador2, "CH") == 0 )
			fprintf(fm, "%s", reg->CH);
		else if (  strcmp(operador2, "SI") == 0 )
			fprintf(fm, "%s", reg->SI);
		else if (  strcmp(operador2, "DH") == 0 )
			fprintf(fm, "%s", reg->DH);
		else if (  strcmp(operador2, "DI") == 0 )
			fprintf(fm, "%s", reg->DI);
		else if (  strcmp(operador2, "CS") == 0 )
			fprintf(fm, "%s", reg->CS);
		else if (  strcmp(operador2, "DS") == 0 )
			fprintf(fm, "%s", reg->DS);
		else if (  strcmp(operador2, "ES") == 0 )
			fprintf(fm, "%s", reg->ES);
		else if (  strcmp(operador2, "SS") == 0 )
			fprintf(fm, "%s", reg->SS);
		else if ( operador2[ strlen(operador2) - 1 ] == 'h' || operador2[ strlen(operador2) - 1 ] == 'H' )
		{
			strcpy( operador2, HexaBin(operador2) );
			strcpy( operador2, preencheZeros(operador2, 8) );
			fprintf(fm, "%s", operador2);
		}
		else
		{
			char bin[10], test[20];
			for ( int i = 0; i<qtd; i++)
			{
				if ( strstr(operador2, tab[i].instrucao))
				{
					itoa(tab[i].posdolar, bin, 2);
					strcpy(test, preencheZeros(bin, 16));
					fprintf(fm, "%s", test);
				}
			}
		}	
	}
	fprintf(fm, "\n");
}

void geraMontador(arquivo *arq, int quantidade_linhas)
{
	FILE *fm;
	fm = fopen("montador.txt", "w");

	registradores *reg = alocaRegistradores();
	enderecamento *end = alocaEnderecamento();
	menemonicos *men = alocaMenemonicos();

	tabela *tab = dollar(arq, quantidade_linhas);
	int qtd = contaLabel(arq, quantidade_linhas);

	char aux[100];
	int modo;
	int magic = 0;

	for ( int i = 0; i < quantidade_linhas; i++ )
	{
		// Comentário
		if ( arq[i].linha[0] == ';' );
		
		//Label:
		else if ( arq[i].linha[ strlen(arq[i].linha) - 1 ] == ':' );

		// Variável
		else if( strstr(arq[i].linha, "db") )
		{
			char buffer[100]; strcpy(buffer, arq[i].linha);
			char variavel[100]; strcpy(variavel, strtok(buffer, " "));
			char comando[20];  strcpy(comando, strtok(NULL, " "));
			char valor[20]; strcpy(valor, strtok(NULL, "\0"));
			if ( strcmp(comando, "db") == 0 && strstr(valor, "?") )
				strcpy(valor, "00000000");
			else if ( strcmp(comando, "dw") == 0 && strstr(valor, "?") )
				strcpy(valor, "0000000000000000");
			else
				strcpy( valor, HexaBin(valor) );
			
			fprintf(fm, "%s\n", valor);
		}

		//Menemônico
		else
		{
			char menemonico[10], op1[10], op2[10], aux[100];
			strcpy(aux, arq[i].linha);
			strcpy(menemonico, strtok(aux, " \0"));
			if (!strcmp(menemonico, "HLT") == 0)
				strcpy(op1, strtok(NULL, ","));

			if ( strstr(arq[i].linha, ",") )
				strcpy(op2, strtok(NULL, "\0"));

			if ( eMenemonico(menemonico) == 0 )
			{
				strcat(op1, ",");
				strcat(op1, op2);
				strcpy(aux, op1);

				if ( strcmp("ADD", menemonico) == 0 )
				{
					fprintf(fm, "%s", men->ADD);
					modo = modoEnderecamento(op1);
					fprintfmodo(fm, end, modo);
					fprintfcomando(fm, reg, tab, aux, qtd, menemonico);
				}
				else if ( strcmp("AND", menemonico) == 0 )
				{
					fprintf(fm, "%s", men->AND);
					modo = modoEnderecamento(op1);
					fprintfmodo(fm, end, modo);
					fprintfcomando(fm, reg, tab, aux, qtd, menemonico);
				}
				else if ( strcmp("CMP", menemonico) == 0 )
				{
					fprintf(fm, "%s", men->CMP);
					modo = modoEnderecamento(op1);
					fprintfmodo(fm, end, modo);
					fprintfcomando(fm, reg, tab, aux, qtd, menemonico);
				}
				else if ( strcmp("MOV", menemonico) == 0 )
				{
					fprintf(fm, "%s", men->MOV);
					modo = modoEnderecamento(op1);
					fprintfmodo(fm, end, modo);
					fprintfcomando(fm, reg, tab, aux, qtd, menemonico);
				}
				else if ( strcmp("OR", menemonico) == 0 )
				{
					fprintf(fm, "%s", men->OR);
					modo = modoEnderecamento(op1);
					fprintfmodo(fm, end, modo);
					fprintfcomando(fm, reg, tab, aux, qtd, menemonico);
				}
				else if ( strcmp("SUB", menemonico) == 0 )
				{
					fprintf(fm, "%s", men->SUB);
					modo = modoEnderecamento(op1);
					fprintfmodo(fm, end, modo);
					fprintfcomando(fm, reg, tab, aux, qtd, menemonico);
				}
				else if ( strcmp("XOR", menemonico) == 0 )
				{
					fprintf(fm, "%s", men->XOR);
					modo = modoEnderecamento(op1);
					fprintfmodo(fm, end, modo);
					fprintfcomando(fm, reg, tab, aux, qtd, menemonico);
				}
			}
			else if ( eMenemonico(menemonico) == 1 )
			{
				if ( strcmp("CALL", menemonico) == 0 )
				{
					fprintf(fm, "%s", men->CALL);
					fprintf(fm, "%s", end->RR);
					fprintfcomando(fm, reg, tab, op1, qtd, menemonico);
				}
				else if ( strcmp("DIV", menemonico) == 0 )
				{
					fprintf(fm, "%s", men->DIV);
					fprintf(fm, "%s", end->RR);
					fprintfcomando(fm, reg, tab, op1, qtd, menemonico);
				}
				else if ( strcmp("IDIV", menemonico) == 0 )
				{
					fprintf(fm, "%s", men->IDIV);
					fprintf(fm, "%s", end->RR);
					fprintfcomando(fm, reg, tab, op1, qtd, menemonico);
				}
				else if ( strcmp("IMUL", menemonico) == 0 )
				{
					fprintf(fm, "%s", men->IMUL);
					fprintf(fm, "%s", end->RR);
					fprintfcomando(fm, reg, tab, op1, qtd, menemonico);
				}
				else if ( strcmp("JE", menemonico) == 0 )
				{
					fprintf(fm, "%s", men->JE);
					fprintf(fm, "%s", end->RR);
					fprintfcomando(fm, reg, tab, op1, qtd, menemonico);
				}
				else if ( strcmp("JG", menemonico) == 0 )
				{
					fprintf(fm, "%s", men->JG);
					fprintf(fm, "%s", end->RR);
					fprintfcomando(fm, reg, tab, op1, qtd, menemonico);
				}
				else if ( strcmp("JGE", menemonico) == 0 )
				{
					fprintf(fm, "%s", men->JGE);
					fprintf(fm, "%s", end->RR);
					fprintfcomando(fm, reg, tab, op1, qtd, menemonico);
				}
				else if ( strcmp("JL", menemonico) == 0 )
				{
					fprintf(fm, "%s", men->JL);
					fprintf(fm, "%s", end->RR);
					fprintfcomando(fm, reg, tab, op1, qtd, menemonico);
				}
				else if ( strcmp("JLE", menemonico) == 0 )
				{
					fprintf(fm, "%s", men->JLE);
					fprintf(fm, "%s", end->RR);
					fprintfcomando(fm, reg, tab, op1, qtd, menemonico);
				}
				else if ( strcmp("JMP", menemonico) == 0 )
				{
					fprintf(fm, "%s", men->JMP);
					fprintf(fm, "%s", end->RR);
					fprintfcomando(fm, reg, tab, op1, qtd, menemonico);
				}
				else if ( strcmp("JNE", menemonico) == 0 )
				{
					fprintf(fm, "%s", men->JNE);
					fprintf(fm, "%s", end->RR);
					fprintfcomando(fm, reg, tab, op1, qtd, menemonico);
				}
				else if ( strcmp("MUL", menemonico) == 0 )
				{
					fprintf(fm, "%s", men->MUL);
					fprintf(fm, "%s", end->RR);
					fprintfcomando(fm, reg, tab, op1, qtd, menemonico);
				}
				else if ( strcmp("POP", menemonico) == 0 )
				{
					fprintf(fm, "%s", men->POP);
					fprintf(fm, "%s", end->RR);
					fprintfcomando(fm, reg, tab, op1, qtd, menemonico);
				}
				else if ( strcmp("PUSH", menemonico) == 0 )
				{
					fprintf(fm, "%s", men->PUSH);
					fprintf(fm, "%s", end->RR);
					fprintfcomando(fm, reg, tab, op1, qtd, menemonico);
				}
				else if ( strcmp("INC", menemonico) == 0 )
				{
					fprintf(fm, "%s", men->INC);
					fprintf(fm, "%s", end->RR);
					fprintfcomando(fm, reg, tab, op1, qtd, menemonico);
				}
				else if ( strcmp("DEC", menemonico) == 0 )
				{
					fprintf(fm, "%s", men->DEC);
					fprintf(fm, "%s", end->RR);
					fprintfcomando(fm, reg, tab, op1, qtd, menemonico);
				}
				else if ( strcmp("NOT", menemonico) == 0 )
				{
					fprintf(fm, "%s", men->DEC);
					fprintf(fm, "%s", end->RR);
					fprintfcomando(fm, reg, tab, op1, qtd, menemonico);
				}
				else if ( strcmp("HLT", menemonico) == 0 )
				{
					fprintf(fm, "%s", men->HLT);
					fprintf(fm, "%s\n", end->RR);
					//fprintfcomando(fm, reg, tab, op1, qtd, menemonico);
				}
			}
		}
	}

	fclose(fm);
	free(reg);
	free(end);
	free(men);
	free(tab);
}