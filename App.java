import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ListaDinamica lista = new ListaDinamica();
        Scanner scanner = new Scanner(System.in);
        int opcao;
        try {
            do {
                System.out.println("\nMENU");
                System.out.println("1. Adicionar Cliente");
                System.out.println("2. Exibir Lista em Ordem Crescente");
                System.out.println("3. Exibir Lista em Ordem Decrescente");
                System.out.println("0. Sair");
                System.out.print("Escolha uma opção: ");

                opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        System.out.print("Digite o código do cliente: ");
                        int codigo = scanner.nextInt();
                        scanner.nextLine(); 
                        System.out.print("Digite o nome do cliente: ");
                        String nome = scanner.nextLine();
                        System.out.print("Digite o telefone do cliente: ");
                        String telefone = scanner.nextLine();
                        lista.inserirOrdenado(new Cliente(codigo, nome, telefone));
                        break;

                    case 2:
                        System.out.println("\nLista em Ordem Crescente:");
                        lista.exibirCrescente();
                        break;

                    case 3:
                        System.out.println("\nLista em Ordem Decrescente:");
                        lista.exibirDecrescente();
                        break;

                    case 0:
                        System.out.println("Saindo...");
                        break;

                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } while (opcao != 0);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}
