/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jogo.application;

import br.com.jogo.entites.Usuario;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author 99030499
 */
public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Usuario user = new Usuario();

        System.out.println("## Jogo Da Velha ##");
        StringBuilder sb = new StringBuilder();
        System.out.println("  0  1  2");
        sb.append("0").append("__|__|__").append("\n");
        sb.append("1").append("__|__|__").append("\n");
        sb.append("3").append("  |  |  ").append("\n");
        System.out.println(sb.toString());
        System.out.println("Deseja iniciar uma partida?");
        do{
        System.out.println("1 - Sim");
        System.out.println("2 - Não");
        System.out.print("R: ");
        user.iniciarPartida(sc.nextInt());
        }while(user.isStart() == false);
        sb = new StringBuilder();

        System.out.println("Escolha uma linha e Coluna que deseja marcar.");
        do {
            System.out.println("Turno do " + user.getObjeto());
            System.out.print("L: ");
            int linha = sc.nextInt();
            System.out.print("C: ");
            int coluna = sc.nextInt();
            user.addPosition(linha, coluna);
            user.obterPosition();
        } while (user.isStart());

        sc.close();
    }
}
