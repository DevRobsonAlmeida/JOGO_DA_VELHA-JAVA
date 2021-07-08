/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jogo.entites;

/**
 *
 * @author 99030499
 */
public class Usuario {

    private String objeto = "X";
    //
    //
    private boolean perguntaInicial = true;
    private boolean start = false;
    private boolean exit = false;
    //
    private String[][] position = new String[3][3];

    public Usuario() {
    }

    public void pergunta() {
        StringBuilder sb = new StringBuilder();
        if (perguntaInicial == true) {
            sb.append("Iniciar Partida?").append("\n");
        } else {
            sb.append("Iniciar nova Partida?").append("\n");
        }
        sb.append("1 - Sim").append("\n");
        sb.append("2 - Não").append("\n");
        sb.append("R: ");
        System.out.print(sb.toString());
    }

    public boolean iniciarPartida(int resposta) {

        if (resposta == 1) {
            return start = true;
        } else if (resposta == 2) {
            exit = true;
            return start = false;
        } else {
            msn("OpcaoErrada");
            exit = false;
            return start = false;
        }

    }

    public void msn(String motivo) {
        if (motivo == "OpcaoErrada") {
            System.out.println("Opção não encontrada, tente novamete.");
        }

        if (motivo == "vencedor") {
            System.out.println("Vitoria do " + objeto);
        }
    }

    public void obterPosition() {

        int cont = 0;
        StringBuilder sb = new StringBuilder();
        for (int linha = 0; linha < position.length; linha++) {
            for (int coluna = 0; coluna < position[linha].length; coluna++) {
                sb.append(" ");
                if (position[linha][coluna] == null) {
                    cont++;
                    sb.append(" ");
                } else {
                    sb.append(position[linha][coluna]);
                }
                sb.append(" ");

                if (coluna < 2) {
                    sb.append("|");
                }
                if (coluna == 2) {
                    sb.append("\n");
                }

            }
            if (linha < 2) {
                sb.append("--- --- ---").append("\n");
            }
        }

        System.out.println(sb.toString());

        if (verificarVencedor()) {
            perguntaInicial = false;
            start = false;
        } else if (cont == 0) {
            System.out.println("Empate!");
            perguntaInicial = false;
            start = false;
        } 
    }

    public boolean verificarVencedor() {
        int count = 0;
        boolean verificar = false;
        for (int j = 0; j < 2; j++) {
            objeto = (objeto == "X") ? "O" : "X";

            for (int i = 0; i < position.length; i++) {

                // Por linha - if
                // Por Coluna - else if
                if (position[i][0] == objeto
                        && position[i][1] == objeto
                        && position[i][2] == objeto) {
                    verificar = true;
                } else if (position[0][i] == objeto
                        && position[1][i] == objeto
                        && position[2][i] == objeto) {
                    verificar = true;
                }

                //diagonal
                if (position[0][0] == objeto & position[1][1] == objeto && position[2][2] == objeto
                        || position[2][0] == objeto & position[1][1] == objeto && position[0][2] == objeto) {
                    count++;
                }

                if (count == 3) {
                    verificar = true;
                }

                if (verificar) {
                    msn("vencedor");
                    return true;
                }
            }
        }
        return false;
    }

    public void addPosition(int linha, int coluna) {
        if (linha < 3 && coluna < 3) {
            if (position[linha][coluna] == null) {
                position[linha][coluna] = objeto;

                if (objeto == "X") {
                    objeto = "O";
                } else {
                    objeto = "X";
                }
            } else {
                System.out.println("Campo já preenchido!");
            }

        } else {
            System.out.println("Os valores setados não existem");
        }
    }

    public boolean isStart() {
        return start;
    }

    public void setStart(boolean start) {
        this.start = start;
    }

    public String getObjeto() {
        return objeto;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    public boolean isExit() {
        return exit;
    }

}
