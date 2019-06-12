package Modelo;


public class Senha {

private int senha;
private Boolean chamada;
private DateTime inicioAtendimento;
private  Boolean prioritaria;


    public int getSenha() {
        return senha;
    }


    public void setSenha(int senha) {
        this.senha = senha;
    }


    public Boolean getChamada() {
        return chamada;
    }

    public void setChamada(Boolean chamada) {
        this.chamada = chamada;
    }


    public DateTime getInicioAtendimento() {
        return inicioAtendimento;
    }


    public void setInicioAtendimento(DateTime inicioAtendimento) {
        this.inicioAtendimento = inicioAtendimento;
    }


    public Boolean getPrioritaria() {
        return prioritaria;
    }


    public void setPrioritaria(Boolean prioritaria) {
        this.prioritaria = prioritaria;
    }
    }