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

    String objeto = "X";
    private String position[][] = new String[3][3];
    private boolean start = false;

    public Usuario() {
    }

    public boolean iniciarPartida(int resposta) {

        if (resposta == 1) {
            return start = true;
        } else if (resposta == 2) {
            return start = false;
        } else {
            aviso("OpcaoErrada");
        }

        return false;
    }

    public void aviso(String motivo) {
        if (motivo == "OpcaoErrada") {
            System.out.println("Opção não encontrada, tente novamete.");
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
        if (cont == 0) {
            start = false;
        }

        System.out.println(sb.toString());
    }

    public void addPosition(int linha, int coluna) {
        if (linha < 3 && coluna < 3) {
            if (position[linha][coluna] == null) {
                position[linha][coluna] = objeto;
            } else {
                System.out.println("Campo já preenchido!");
            }

            if (objeto == "X") {
                objeto = "O";
            } else {
                objeto = "X";
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

}
