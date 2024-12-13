package jogo21;

import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pontuacaoJ1 = 0;
        int pontuacaoJ2 = 0;
        int acompanhajogado1 = 1;
        int acompanhajogado2 = 1;
        Pilha cartasJ1 = new Pilha();
        Pilha cartasJ2 = new Pilha();
        String player1;
        String player2;
        System.out.println("Digite o nome do jogador 1: ");
        player1 = sc.nextLine();

        System.out.println("Digite o nome do jogador 2: ");
        player2 = sc.nextLine();

        while (true) {
            int sort = Exercicio2.sortearCarta();
            System.out.println("---------------------------------");
            System.out.printf("Vez de jogador 1 \n");
            pontuacaoJ1 += sort;
            try {
                cartasJ1.push(new Carta(sort));
                System.out.println(player1 + " recebeu a carta " + sort + " Pontuação final: " + pontuacaoJ1);

                if (pontuacaoJ1 > 21) {
                    System.out.println("---------------------------------");

                    System.out.println("\n" + player1 + " ultrapssou 21 pontos e sofreu penalidade de 5 pontos.");
                    pontuacaoJ1 -= 5;
                    int cartaDescartada = cartasJ1.pop().cartaAtual;
                    --acompanhajogado1;
                    System.out.println(" A última carta foi eliminada: " + cartaDescartada);
                    pontuacaoJ1 -= cartaDescartada;
                    break;
                }

            } catch (Exception e) {
                System.out.println("ERRO em: " + e.getMessage());
            }
            System.out.println("Deseja continuar? (s/n)");
            String continuar = sc.nextLine().toLowerCase();
            if (!continuar.equals("s"))
                break;
            ++acompanhajogado1;
        }

        while (true) {
            int sort = Exercicio2.sortearCarta();
            System.out.println("---------------------------------");
            System.out.printf("Vez de jogador 2 \n");
            pontuacaoJ2 += sort;
            try {
                cartasJ2.push(new Carta(sort));
                System.out.println(player2 + " recebeu a carta " + sort + " Pontuação final: " + pontuacaoJ2);

                if (pontuacaoJ2 > 21) {
                    System.out.println("---------------------------------");

                    System.out.println("\n" + player2 + " ultrapssou 21 pontos e sofreu penalidade de 5 pontos.");
                    pontuacaoJ2 -= 5;
                    --acompanhajogado2;

                    int cartaDescartada = cartasJ2.pop().cartaAtual;
                    System.out.println(" A última carta foi eliminada: " + cartaDescartada);
                    pontuacaoJ2 -= cartaDescartada;
                    break;
                }

            } catch (Exception e) {
                System.out.println("ERRO em: " + e.getMessage());
            }
            System.out.println("Deseja continuar? (s/n)");
            String continuar = sc.nextLine().toLowerCase();
            if (!continuar.equals("s"))
                break;
            ++acompanhajogado2;
        }
        System.out.println("---------------------------------");

        System.out.println("A pontuação dos jogadores foi:\n" + player1 + "\t" + pontuacaoJ1 + "\n" + player2 + "\t"
                + pontuacaoJ2);
        System.out.println("---------------------------------");

        int diferenca1 = 21 - pontuacaoJ1;
        int diferenca2 = 21 - pontuacaoJ2;
        if (diferenca1 < diferenca2) {
            System.out.println(player1 + " venceu!!");
            System.out.println("Cartas jogadas: ");

            for (int i = 0; i < acompanhajogado1; i++) {
                try {
                    System.out.print(" " + cartasJ1.pop().cartaAtual);
                } catch (Exception e) {
                    System.out.println("Erro " + e.getMessage());
                }
            }
        } else if (diferenca2 < diferenca1) {
            System.out.println(player2 + " venceu!!");
            System.out.println("Cartas jogadas: ");
            for (int i = 0; i < acompanhajogado2; i++) {
                try {
                    System.out.print(" " + cartasJ2.pop().cartaAtual);
                } catch (Exception e) {
                    System.out.println("Erro " + e.getMessage());

                }
            }
        } else {
            System.out.println("Deu empate!");
        }

    }

    public static int sortearCarta() {

        return (int) ((Math.random() * 10) + 1);
    }

}
