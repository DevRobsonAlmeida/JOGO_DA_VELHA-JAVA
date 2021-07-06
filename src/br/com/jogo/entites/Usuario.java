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

    private int x;
    private int o;
    String objeto = "X";
    private String position[][] = new String[3][3];
    private boolean start = false;

    public Usuario() {
    }

    public Usuario(int x, int o) {
        this.x = x;
        this.o = o;
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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getO() {
        return o;
    }

    public void setO(int o) {
        this.o = o;
    }

    public void obterPosition() {
        StringBuilder sb = new StringBuilder();
        sb.append(" ").append(position[0][0]).append(" |").append(" ").append(position[0][1]).append(" |").append(" ").append(position[0][2]).append("\n");
        sb.append("--- --- ---").append("\n");
        sb.append(" ").append(position[1][0]).append(" |").append(" ").append(position[1][1]).append(" |").append(" ").append(position[1][2]).append("\n");
        sb.append("--- --- ---").append("\n");
        sb.append(" ").append(position[2][0]).append(" |").append(" ").append(position[2][1]).append(" |").append(" ").append(position[2][2]).append("\n");
        for (int i = 0; i < position.length; i++) {

            for (int j = 0; j < position[i].length; j++) {

                if (j == 2) {
                    sb.append("\n");
                }
               
            }
            if (i < 2) {
             sb.append("--- --- ---").append("\n");
            }
        }
    }

    public void addPosition(int linha, int coluna) {
        if (linha < 3 && coluna < 3) {
            position[linha][coluna] = objeto;
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

}
