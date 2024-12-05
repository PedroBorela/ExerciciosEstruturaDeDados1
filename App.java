import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ListaCidades lista = new ListaCidades();
        Scanner scanner = new Scanner(System.in);
        String nome, pais, atrativos;
        No exibido = null;
        int opcao;
        try {
            do {
                System.out.println("\nMENU");
                System.out.print("=======================\n");
                System.out.println("Se você chegou no depois do último\n ou antes do primeiro elemento\n da lista e apertar 2 ou 3\nele exibirá a lista\nnovamente do início");
                System.out.print("\n=======================\n");
                System.out.println("1. Adicionar cidade turística");                
                System.out.println("2. exibir próximo");
                System.out.println("3. Exibir anterior");
                System.out.println("4. Excluir cidade por nome");
                System.out.println("5. Excluir cidade por país");
                System.out.println("0. Sair");
                System.out.print("Escolha uma opção: ");

                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        System.out.print("\n====================\n");
                        System.out.print("Digite o nome da cidade: ");
                        nome = scanner.nextLine();
                        System.out.println(nome);
                        System.out.print("Digite o nome do país: ");
                        pais = scanner.nextLine();
                        System.out.println(pais);
                        System.out.print("Digite o nome dos atrativos da cidade: ");
                        atrativos = scanner.nextLine();
                        System.out.println(atrativos);
                        System.out.print("Digite a avaliação da cidade: ");
                        while (!scanner.hasNextInt()) {
                            System.out.println("Avaliação inválida. Digite um número.");
                            scanner.next();
                        }
                        int avaliacao = scanner.nextInt();

                        lista.insereDecrescente(new Cidade(nome, pais, atrativos, avaliacao));
                        System.out.println("\n====================");
                        if (exibido == null) {
                            exibido = lista.exibirPrimeiraVez();
                        } else {
                            System.out.println("\n====================");
                            lista.exibirPrimeiraVez(); 
                        }
                        break;

                    case 2:
                        System.out.print("\n====================\n");
                        if (exibido == null) {
                            exibido = lista.exibirPrimeiraVez();
                        } else {
                            System.out.println("\nExibindo próximo:");
                            exibido = lista.exibirProximo(exibido);
                        }
                        System.out.print("\n====================");

                        break;

                    case 3:
                        System.out.print("\n====================\n");

                        if (exibido == null) {
                            exibido = lista.exibirPrimeiraVez();
                        } else {
                            System.out.println("\nExibindo anterior:");
                            exibido = lista.exibirAnterior(exibido);
                        }
                        System.out.print("\n====================\n");

                        break;

                    case 4:
                        System.out.print("\nDigite o nome da cidade para excluir: ");
                        nome = scanner.nextLine();
                        if (lista.excluirPorNome(nome)) {
                            System.out.println("Cidade excluída com sucesso.");
                        } else {
                            System.out.println("Cidade não encontrada.");
                        }
                        break;
                    case 5:
                        System.out.print("\nDigite o nome do país para excluir: ");
                        pais = scanner.nextLine();
                        if (lista.excluirPorPais(pais)) {
                            System.out.println("Cidade excluída com sucesso.");
                        } else {
                            System.out.println("Cidade não encontrada.");
                        }
                        break;

                    case 0:
                        System.out.println("Saindo...");
                        break;

                    default:
                        System.out.print("\n====================");
                        System.out.println("\nOpção inválida. Tente novamente.");
                        System.out.print("\n====================");

                }
            } while (opcao != 0);

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            scanner.close();

        }

    }
}
