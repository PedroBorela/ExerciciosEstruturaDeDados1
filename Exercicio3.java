import java.util.Scanner;

public class Exercicio3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {

            System.out.println("Digite um número para ver se existe no vetor: ");
            double num = sc.nextDouble();
            double[] vetor = { -22, 0.232, 2, 2.45, 3, 56.6, 341, 3331, 10000 };

            boolean existe = confere(vetor, num, 0, vetor.length);

            if (existe) {
                System.out.println("\nO número existe no vetor\n");
            } else {
                System.out.println("\nO número não existe no vetor\n");
            }

        } catch (Exception e) {
            System.out.println("Entrada inválida");
        }

        sc.close();
    }

    public static boolean confere(double[] vetor, double num, int inicio, int fim) {
        if (inicio > fim) {
            return false;
        }
        int meio = (fim + inicio) / 2;
        if (vetor[meio] == num) {
            return true;
        } else if (num > vetor[meio]) {
                return confere(vetor, num, meio + 1, fim);
            } else if (num < vetor[meio]) {
                return confere(vetor, num, inicio, meio - 1);
            }

        
        return false;

    }
}
