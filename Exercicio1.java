public class Exercicio1 {

    public static void main(String[] args) {
        int[] vetor = new int[10];
        int ultimaPosicao = vetor.length - 1;
        for (int i = 0; i < vetor.length; i++)
            vetor[i] = (int) (Math.random() * 10);

        for (int i = 0; i < vetor.length; i++) {
            System.out.print(" " + vetor[i]);
        }

        try {
            excluiElementosPares(vetor, ultimaPosicao);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\no vetor após a exclusão:");
        for (int j = 0; j < vetor.length; j++)
            System.out.print(" " + vetor[j]);

    }

    public static void excluiElementosPares(int[] vet, int ultimaPosicao) throws Exception {
        if (ultimaPosicao == -1)
            throw new Exception("Vetor vazio");
        int posicao = 0;
        while (posicao <= ultimaPosicao) {
            if (vet[posicao] % 2 == 0) {
                for (int i = posicao; i < ultimaPosicao; i++)
                    vet[i] = vet[i + 1];
                vet[ultimaPosicao] = 0;
                --ultimaPosicao;
            } else {
                ++posicao;
            }
        }

      

    }

}