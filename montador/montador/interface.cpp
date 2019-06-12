#include "interface.h"

HANDLE m_hStdOut;

void PutsXY(int X, int Y, const char* str, WORD wTextColor)
{
	m_hStdOut = GetStdHandle(STD_OUTPUT_HANDLE);

	GotoXY(X,Y);
	SetConsoleTextAttribute (m_hStdOut, wTextColor);
	printf("%s", str);

}

void printcolor(const char* str, WORD wTextColor)
{
	m_hStdOut = GetStdHandle(STD_OUTPUT_HANDLE);
	SetConsoleTextAttribute (m_hStdOut, wTextColor);
	printf("%s", str);
}

void DrawBorder(int iLeft, int iTop, int iWidth, int iHeight, WORD wBorderColor)
{
	COORD xyPos;

	int iControle = 0;
	int iNumChar = 0;

	m_hStdOut = GetStdHandle(STD_OUTPUT_HANDLE);

	xyPos.X = iLeft;
	xyPos.Y = iTop;
	SetConsoleCursorPosition (m_hStdOut, xyPos);
	printf("%c", 201);

	xyPos.X = iLeft + iWidth;
	xyPos.Y = iTop;
	SetConsoleCursorPosition (m_hStdOut, xyPos);
	printf("%c", 187);

	xyPos.X = iLeft;
	xyPos.Y = iTop + iHeight;
	SetConsoleCursorPosition (m_hStdOut, xyPos);
	printf("%c", 200);


	xyPos.X = iLeft + iWidth;
	xyPos.Y = iTop + iHeight;
	SetConsoleCursorPosition (m_hStdOut, xyPos);
	printf("%c", 188);


	//BORDA SUPERIOR
	xyPos.X = iLeft + 1;
	xyPos.Y = iTop;
	SetConsoleCursorPosition (m_hStdOut, xyPos);
	iNumChar = iWidth - 2;
	for( iControle = 0; iControle <= iNumChar; iControle ++)
	{
		printf("%c", 205);
	}
	
	//BORDA INFERIOR
	xyPos.X = iLeft + 1;
	xyPos.Y = iTop + iHeight;
	SetConsoleCursorPosition (m_hStdOut, xyPos);
	for( iControle = 0; iControle <= iNumChar; iControle ++)
	{
		printf("%c", 205);
	}

	//BORDA ESQUERDA
	xyPos.X = iLeft;
	xyPos.Y = iTop + 1;
	iNumChar = iHeight - 2;
	for( iControle = 0; iControle <= iNumChar; iControle ++)
	{
		SetConsoleCursorPosition (m_hStdOut, xyPos);
		printf("%c", 186);
		xyPos.Y++;
	}

	//BORDA DIREITA
	xyPos.X = iLeft + iWidth;
	xyPos.Y = iTop + 1;
	iNumChar = iHeight - 2;
	for( iControle = 0; iControle <= iNumChar; iControle ++)
	{
		SetConsoleCursorPosition (m_hStdOut, xyPos);
		printf("%c", 186);
		xyPos.Y++;
	}
}

void InitConsoleApp()
{
	m_hStdOut = GetStdHandle(STD_OUTPUT_HANDLE);
}

void GotoXY(int X, int Y)
{
	COORD xyPos;

	xyPos.X = X;
	xyPos.Y = Y;

	SetConsoleCursorPosition (m_hStdOut, xyPos);
}