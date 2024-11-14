import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] vet = new int[10]; // Vetor de 10 posições
        int ultimaPosicao = -1; // Índice da última posição usada no vetor

        while (true) {
            System.out.println("Selecione uma das opções:");
            System.out.println("(1) Adicionar no final");
            System.out.println("(2) Adicionar no início");
            System.out.println("(3) Adicionar entre os elementos");
            System.out.println("(4) Excluir no início");
            System.out.println("(5) Excluir no final");
            System.out.println("(6) Excluir entre elementos");
            System.out.println("(0) Sair");
            try {
                int escolha = sc.nextInt();
                if (escolha == 0)
                    break;

                int numeroEscolhido = 0;
                int posicao = -1;
                if (escolha != 4 && escolha != 5 && escolha != 6) {
                    System.out.print("Digite o número a ser inserido: ");
                    numeroEscolhido = sc.nextInt();
                }

                if (escolha == 3)
                    if (ultimaPosicao != -1)
                        System.out.println("Você pode adicionar entre as posições 0 e " + ultimaPosicao);
                if (escolha == 6)
                    if (ultimaPosicao != -1)
                        System.out.println("Você pode excluir entre as posições 0 e " + ultimaPosicao);

                if (escolha == 3 || escolha == 6) {
                    System.out.print("Digite a posição: ");
                    posicao = sc.nextInt();
                }

                switch (escolha) {
                    case 1:
                        ultimaPosicao = adicionaFim(vet, ultimaPosicao, numeroEscolhido);
                        break;
                    case 2:
                        ultimaPosicao = adicionaInicio(vet, ultimaPosicao, numeroEscolhido);
                        break;
                    case 3:
                        ultimaPosicao = adicionaEntre(vet, ultimaPosicao, numeroEscolhido, posicao);
                        break;
                    case 4:
                        ultimaPosicao = excluiInicio(vet, ultimaPosicao);
                        break;
                    case 5:
                        ultimaPosicao = excluiFinal(vet, ultimaPosicao);
                        break;
                    case 6:
                        ultimaPosicao = excluiEntre(vet, ultimaPosicao, posicao);
                        break;
                    default:
                        System.out.println("Opção inválida");
                        break;
                }
                imprimeVetor(vet, ultimaPosicao);
            } catch (Exception e) {
                System.out.println("digite uma entrada válida " + e.getMessage());
                sc.nextLine();

            }
        }
        sc.close();
    }

    public static int adicionaInicio(int[] vet, int ultimaPosicao, int elemento) throws Exception {
        if (ultimaPosicao == vet.length - 1)
            throw new Exception("O vetor está cheio");

        for (int i = ultimaPosicao; i >= 0; i--) {
            vet[i + 1] = vet[i];
        }
        vet[0] = elemento;
        return ultimaPosicao + 1;
    }

    public static int adicionaFim(int[] vet, int ultimaPosicao, int elemento) throws Exception {
        if (ultimaPosicao == vet.length - 1)
            throw new Exception("O vetor está cheio");

        vet[ultimaPosicao + 1] = elemento;
        return ultimaPosicao + 1;
    }

    public static int adicionaEntre(int[] vet, int ultimaPosicao, int elemento, int posicao) throws Exception {
        if (ultimaPosicao == vet.length - 1)
            throw new Exception("O vetor está cheio");
        if (posicao < 0 || posicao > ultimaPosicao)
            throw new Exception("Posição inválida");

        for (int i = ultimaPosicao; i >= posicao; i--) {
            vet[i + 1] = vet[i];
        }
        vet[posicao] = elemento;

        return ultimaPosicao + 1;
    }

    public static int excluiInicio(int[] vet, int ultimaPosicao) throws Exception {
        if (ultimaPosicao == -1)
            throw new Exception("O vetor está vazio");

        for (int i = 0; i < ultimaPosicao; i++) {
            vet[i] = vet[i + 1];
        }
        vet[ultimaPosicao] = 0;
        return ultimaPosicao - 1;
    }

    public static int excluiFinal(int[] vet, int ultimaPosicao) throws Exception {
        if (ultimaPosicao == -1)
            throw new Exception("O vetor está vazio");

        vet[ultimaPosicao] = 0;
        return ultimaPosicao - 1;
    }

    public static int excluiEntre(int[] vet, int ultimaPosicao, int posicao) throws Exception {
        if (ultimaPosicao == -1)
            throw new Exception("O vetor está vazio");
        if (posicao < 0 || posicao > ultimaPosicao)
            throw new Exception("Posição inválida");

        for (int i = posicao; i < ultimaPosicao; i++) {
            vet[i] = vet[i + 1];
        }
        vet[ultimaPosicao] = 0;
        return ultimaPosicao - 1;
    }

    public static void imprimeVetor(int[] vet, int ultimaPosicao) {
        System.out.println("Vetor:");
        for (int i = 0; i < vet.length; i++) {
            System.out.print(vet[i] + " ");
        }
        System.out.println();
    }
}
