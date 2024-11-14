public class Exercicio2 {
    public static void main(String[] args) {
        int[] vet = new int[10];
        int opcao = 0;
        int opcaoAnterior = 0;
        int elemento = 0;
        for (int i = 0; i < vet.length; i++) {
            int posicao = i;
            opcao = (int) (Math.random() * 3) + 1;
            elemento = (int) (Math.random() * 10) + 1;
            System.out.println("\nO elemento é " + elemento);
            try {
                if (opcao == 1) {
                    System.out.print("opção é 1(inicio)");
                    opcaoAnterior = adicionaInicio(vet, posicao, elemento);

                }
                if (opcao == 2) {
                    System.out.print("opção é 2(final)");

                    opcaoAnterior = adicionaFim(vet, posicao, elemento);
                }
                if (opcao == 3) {
                    System.out.print("opção é 3");
                    if (opcaoAnterior == 1 || opcaoAnterior == 0) {
                        if (opcaoAnterior == 1)
                            System.out.print("\nopção anterior é 1");
                        adicionaInicio(vet, posicao, elemento);
                    }
                    if (opcaoAnterior == 2) {
                        System.out.print("\nopção anterior é 2");
                        adicionaEntre(vet, posicao, elemento);
                    }

                }
                imprimeVetor(vet);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

    }

    public static int adicionaInicio(int[] vet, int posicao, int elemento) throws Exception {
        --posicao;
        if (posicao == vet.length - 1)
            throw new Exception("O vetor tá cheio");
        for (int i = posicao + 1; i > 0; --i) {
            vet[i] = vet[i - 1];
        }
        vet[0] = elemento;
        return 1;
    }

    public static int adicionaFim(int[] vet, int posicao, int elemento) throws Exception {
        --posicao;
        if (posicao == vet.length - 1)
            throw new Exception("O vetor está cheio");
        vet[++posicao] = elemento;
        return 2;
    }

    public static void adicionaEntre(int[] vet, int posicao, int elemento) throws Exception {
        --posicao;
        if (posicao == vet.length - 1)
            throw new Exception("O vetor está cheio");
        for (int i = posicao + 1; i > posicao; --i)
            vet[i] = vet[posicao];
        vet[posicao] = elemento;
    }

    public static void imprimeVetor(int[] vet) {
        System.out.println();
        for (int i = 0; i < vet.length; i++) {
            System.out.print(" " + vet[i]);
        }
        System.out.println();
    }
}
