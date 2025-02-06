import java.util.Scanner;

public class AppFinanciamento {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe o valor a ser financiado: ");
        double valorTotal = scanner.nextDouble();
        System.out.print("Informe o número de parcelas: ");
        int numeroParcelas = scanner.nextInt();

        Deque<Parcela> deque = new Deque<>();
        double valorBase = valorTotal / numeroParcelas;

        for (int mes = 1; mes <= numeroParcelas; mes++) {
            Parcela parcela = new Parcela(valorBase, mes);
            deque.addLast(parcela);
        }

        System.out.println("Parcelas com juros:");
        try {
            deque.print();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        double valorTotalPago = 0; 

        while (!deque.isEmpty()) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Pagar primeira parcela");
            System.out.println("2 - Pagar última parcela");
            System.out.println("0 - Sair");
            int opcao = scanner.nextInt();

            if (opcao == 0) {
                break;
            }
            try {
                switch (opcao) {
                    case 1:
                        Parcela primeira = deque.removeFirst();
                        double valorPagarPrimeira = primeira.getValorBase() * (1 + 0.01 * primeira.getMes());
                        valorTotalPago += valorPagarPrimeira;
                        System.out.printf("Pagando primeira parcela: R$ %.2f\n", valorPagarPrimeira);
                        break;
                    case 2:
                        Parcela ultima = deque.removeLast();
                        double valorPagarUltima = ultima.getValorBase();
                        valorTotalPago += valorPagarUltima;
                        System.out.printf("Pagando última parcela: R$ %.2f\n", valorPagarUltima);
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }

                System.out.println("Deque atual:");
                deque.print();

                System.out.printf("Valor total pago até o momento: R$ %.2f\n", valorTotalPago);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        // Exibir valor total pago ao final
        System.out.printf("\nValor total pago: R$ %.2f\n", valorTotalPago);

        scanner.close();
    }
}