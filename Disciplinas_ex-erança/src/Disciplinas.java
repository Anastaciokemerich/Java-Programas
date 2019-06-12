/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Anastacio
 */
public class Disciplinas {

    /**
     * Erança comtiniação de orientação ao objeto classe B-> A,classe A erda da
     * classe A menos os dados privados. erança de duas classe não pode (super
     * Classe e de quem se erda e Sub classe quem qerda as variaveis); se a
     * classe for em cascasta A <- B <- C dai C erda das duas classes anterior
     * @author Anastacio @param args
     * @param args
     *
     */
    public static void main(String[] args) {
        String nome = "Linguagen de programação";
        Professor professor = new Professor();
        Aluno aluno = new Aluno();
        professor.nome = "Reiner";
        professor.matricula = 1234;
        professor.salario = 250;
        //um professor e mais de um aluno
        /*
        Aluno[] vetAluno=new Aluno[2];
        vetAluno[0] = Aluno;
        vetAluno[1] = Aluno2;
        Systen.out.println(vetAluno.nome.matricula.nota);       
        */
        aluno.nome = "Anastacio";
        aluno.matricula = 2012020092;
        aluno.nota = 8,5;
        System.out.println(nome);
    }    
}
