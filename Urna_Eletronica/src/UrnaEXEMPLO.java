
//Algoritmo da Urna Eletrônica em Java
import javax.swing.*;

public class UrnaEXEMPLO {

    public static void
              main(String[] args) {
        String candidatos[]
                  = new String[10];
        int Numerocandidato[]
                  = new int[10];
        int votoscand = 0, votoscand2 = 0, votoscand3 = 0, votoscand4 = 0, selectcandidato = 0, confirmacao;
        int votostotal = 7, votosnulo = 0;//a variável votostotal é onumeros de votos na eleicao
        double percentual = 0, percentual2 = 0, percentual3 = 0, percentual4 = 0, votosvalidos = 0, titulo;
        boolean confirma
                  = true;
        candidatos[0] = "ANASTACIO KEMERICH; Partido SMS";
        candidatos[1] = "SYLVI LUIZ; PSDB";
        candidatos[2] = "RAFELA GELOCH; Partido daHonestidade";
        candidatos[3] = "Alemao DE SANTA; PDA";
        Numerocandidato[0] = 45;
        Numerocandidato[1] = 30;
        Numerocandidato[2] = 21;
        Numerocandidato[3] = 42;
        titulo = Integer.parseInt(JOptionPane.showInputDialog("Apresente seuTítulo Eleitoral ou Digite: -1 Para Finalizar a Votacão"));
        while ((titulo != -1) && (votostotal > 0)) {
            confirma = true;
            System.out.println("Seu título/documento é válido, prossigapara a Urna e Vote");
            while (confirma) {
                selectcandidato = Integer.
                          parseInt(JOptionPane.showInputDialog(" 1 - Candidato de n°45 \n 2 - Candidato de n°30 \n 3 -Candidato de n°21 \n 4 - Candidato de n°42 \n 5 - Votar em Branco/Nulo"));
                if (selectcandidato == 1) {
                    confirmacao = Integer.
                              parseInt(JOptionPane.showInputDialog(" 1 -Confirma o Voto em " + candidatos[0] + " de número " + Numerocandidato[0] + "\n2 - Corrige"));
                    if (confirmacao == 1) {
                        votoscand = votoscand + 1;
                        confirma = false;
                        System.out.println("A votacão foi efetuadacom Sucesso");
                    } else {
                        selectcandidato = Integer.parseInt(JOptionPane.showInputDialog(" 1 - Candidato de n°45 \n 2 - Candidato den°30 \n 3 - Candidato de n°21 \n 4 - Candidato de n°42 \n 5 - Votar emBranco/Nulo"));
                    }
                }
                if (selectcandidato == 2) {
                    confirmacao = Integer.parseInt(JOptionPane.showInputDialog(" 1 -Confirma o Voto em " + candidatos[1] + " de número " + Numerocandidato[1] + "\n2 - Corrige"));
                    if (confirmacao == 1) {
                        votoscand2 = votoscand2 + 1;
                        confirma = false;
                        System.out.println("A votacão foi efetuadacom Sucesso");
                    } else {
                        selectcandidato = Integer.parseInt(JOptionPane.showInputDialog(" 1 - Candidato de n°45 \n 2 - Candidato den°30 \n 3 - Candidato de n°21 \n 4 - Candidato de n°42 \n 5 - Votar emBranco/Nulo"));
                    }
                }
                if (selectcandidato == 3) {
                    confirmacao = Integer.parseInt(JOptionPane.showInputDialog(" 1 - Confirma o Voto em " + candidatos[2] + " de número " + Numerocandidato[2] + "\n 2 - Corrige"));
                    if (confirmacao == 1) {
                        votoscand3 = votoscand3 + 1;
                        confirma = false;
                        System.out.println("A votacão foi efetuadacom Sucesso");
                    } else {
                        selectcandidato = Integer.parseInt(JOptionPane.showInputDialog(" 1 - Candidato de n°45 \n 2 - Candidato den°30 \n 3 - Candidato de n°21 \n 4 - Candidato de n°42 \n 5 - Votar emBranco/Nulo"));
                    }
                }
                if (selectcandidato == 4) {
                    confirmacao = Integer.parseInt(JOptionPane.showInputDialog(" 1 -Confirma o Voto em " + candidatos[3] + " de número " + Numerocandidato[3] + "\n2 - Corrige"));
                    if (confirmacao == 1) {
                        votoscand4 = votoscand4 + 1;
                        confirma = false;
                        System.out.println("A votacão foi efetuadacom Sucesso");
                    } else {
                        selectcandidato = Integer.parseInt(JOptionPane.showInputDialog(" 1 - Candidato de n°45 \n 2 - Candidato den°30 \n 3 - Candidato de n°21 \n 4 - Candidato de n°42 \n 5 - Votar emBranco/Nulo"));
                    }
                }
                if (selectcandidato == 5) {
                    confirmacao = Integer.parseInt(JOptionPane.showInputDialog(" 1 -Confirma o Voto Nulo/em Branco?" + "\n 2 - Corrige"));
                    if (confirmacao == 1) {
                        votosnulo = votosnulo + 1;
                        confirma = false;
                        System.out.println("A votacão foi efetuadacom Sucesso");
                    } else {
                        selectcandidato = Integer.parseInt(JOptionPane.showInputDialog(" 1 - Candidato de n°45 \n 2 - Candidato de n°30 \n 3 - Candidato de n°21 \n 4 - Candidato de n°42 \n 5 - Votar emBranco/Nulo"));
                    }
                }
            }
            votostotal--;
            titulo = Integer.parseInt(JOptionPane.showInputDialog("Apresente seu Título Eleitoral ou Digite: -1 ParaFinalizar a Votacão"));
        }
        votosvalidos = votoscand + votoscand2 + votoscand3 + votoscand4;
        percentual = ((votoscand / votosvalidos) * 100);
        percentual2 = ((votoscand2 / votosvalidos) * 100);
        percentual3 = ((votoscand3 / votosvalidos) * 100);
        percentual4 = ((votoscand4 / votosvalidos) * 100);
        JOptionPane.showInputDialog("O Candidato ANASTACIO teve um percentual de votos de" + percentual + "%");
        JOptionPane.showInputDialog("O Candidato SYLVIO teve um percentual de votos de" + percentual2 + "%");
        JOptionPane.showInputDialog("O Candidato RAFAELA GELOCH teve um percentual de votos de" + percentual3 + "%");
        JOptionPane.showInputDialog("O Candidato Alemão teve um percentual de votosde " + percentual4 + "%");
        if ((percentual > percentual2) && (percentual > percentual3) && (percentual > percentual4)) {
            JOptionPane.showMessageDialog(null, "O CANDIDATO ANASTACIO GANHOU A ELEIÇÃO COM " + (int) percentual + " % dos votos");
        }
        if ((percentual2 > percentual) && (percentual2 > percentual3) && (percentual2 > percentual4)) {
            JOptionPane.showMessageDialog(null, "O CANDIDATO SYLVIO GANHOU A ELEIÇÃO COM " + (int) percentual2 + " % dos votos");
        }
        if ((percentual3 > percentual) && (percentual3 > percentual2) && (percentual3 > percentual4)) {
            JOptionPane.showMessageDialog(null, "O CANDIDATO RAFAELA GELOCH GANHOU A ELEIÇÃO COM" + (int) percentual3 + " % dos votos");
        }
        if ((percentual4 > percentual) && (percentual4 > percentual2) && (percentual4 > percentual3)) {
            JOptionPane.showMessageDialog(null, "O CANDIDATO ALEMÃO GANHOU A ELEIÇÃO COM " + (int) percentual4 + " % dos votos");

        }
    }
}
