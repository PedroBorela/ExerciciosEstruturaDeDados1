import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ListaVeiculos lista = new ListaVeiculos();
        Scanner scanner = new Scanner(System.in);
        int opcao;
        try {

            do {
                System.out.println("\nMenu:");
                System.out.println("1. Cadastrar veículo");
                System.out.println("2. Excluir veículo pela placa");
                System.out.println("3. Exibir todos os veículos");
                System.out.println("4. Sair");
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        System.out.print("Digite a placa: ");
                        String placa = scanner.nextLine();
                        System.out.print("Digite a marca: ");
                        String marca = scanner.nextLine();
                        System.out.print("Digite o modelo: ");
                        String modelo = scanner.nextLine();
                        System.out.print("Digite o valor: ");
                        double valor = scanner.nextDouble();
                        lista.inserirVeiculo(new Veiculo(placa, marca, modelo, valor));
                        System.out.println("Veículo cadastrado com sucesso!");
                        break;

                    case 2:
                        System.out.print("Digite a placa do veículo a ser excluído: ");
                        String placaExcluir = scanner.nextLine();
                        if (lista.excluirVeiculo(placaExcluir)) {
                            System.out.println("Veículo excluído com sucesso!");
                        } else {
                            System.out.println("Veículo não encontrado.");
                        }
                        break;

                    case 3:
                        System.out.println("Veículos cadastrados:");
                        lista.exibirVeiculos();
                        break;

                    case 4:
                        System.out.println("Saindo...");
                        break;

                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } while (opcao != 4);

        } catch (Exception e) {
            System.out.println("Valor inválido: "+e.getMessage());
        }
        scanner.close();
    }
}
