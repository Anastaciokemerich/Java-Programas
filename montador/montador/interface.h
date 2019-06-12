#ifndef INTERFACE_H
#define INTERFACE_H

#include "auxiliar.h"

#define AZUL 0X0001
#define VERDE 0X0002
#define AZULPISCINA 0X0003
#define VERMELHO 0X0004
#define ROXO 0X0005
#define AMARELO 0X0006
#define BRANCO 0X0007
#define CINZA 0X0008
#define CLARO 0X0008

void InitConsoleApp();
void GotoXY(int X, int Y);
void printcolor(const char* str, WORD wTextColor);
void PutsXY(int X, int Y, const char* str, WORD wTextColor);
void DrawBorder(int iLeft, int iTop, int iWidth, int iHeight, WORD wBorderColor);

#endif