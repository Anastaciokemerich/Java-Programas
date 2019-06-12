public class ManipulaçãoStrings {

    public static void main (String args[]) {

        String palavra = "Programação";

        System.out.println("O tamanho da palavra é: " + palavra.length());
        System.out.println("O quinto caractere palavra é: " + palavra.charAt(4));
        System.out.println("A palavra em maiúsculas: " + palavra.toUpperCase());
        System.out.println("A palavra em minúsculas: " + palavra.toLowerCase());
        System.out.println("Obter uma parte da palavra " + palavra.substring(3,8));
        System.out.println("Substituir as letras a por W: " + palavra.replace('a', 'W'));
        System.out.println("Concatenar a palavra: " + palavra.concat(" Java"));
        System.out.println("Posição da primeira letra r: " + palavra.indexOf('r'));
        System.out.println("Posição da última letra r: " + palavra.lastIndexOf('r'));

        int i = 10;
double d = 10.5;
String s1 = "20";
String s2 = "20.5";

//converter inteiro para float
float f2 = (float) i;

//converter inteiro para double
double d2 = (double) i;

//converter float para inteiro
int i2 = (int) f2;

//converter String para inteiro
int i3 = Integer.parseInt(s1);

//converter String para double;
double d3 = Double.parseDouble(s2);

//Converter int para String
String s3 = i + "";
// ou
String s4 = String.valueOf(i);

System.out.println(f2);
System.out.println(d2);
System.out.println(i2);
System.out.println(i3);
System.out.println(d3);
System.out.println(s3);
System.out.println(s4);
    }

}