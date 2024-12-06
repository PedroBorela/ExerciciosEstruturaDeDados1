import java.util.Scanner;

public class Estacao {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int quantidadeDeVagoes = sc.nextInt();
            if (quantidadeDeVagoes == 0) {
                break;
            }

            while (true) {
                int entrada = sc.nextInt();
                if (entrada == 0) {
                    System.out.println();
                    break;
                }

                // Lê a sequência desejada
                int[] ordemDosVagoesDesejada = new int[quantidadeDeVagoes];
                ordemDosVagoesDesejada[0] = entrada;
                for (int i = 1; i < quantidadeDeVagoes; i++) {
                    ordemDosVagoesDesejada[i] = sc.nextInt();
                }

                // Pilha 
                Pilha pilha = new Pilha();
                int proximoVagao = 1;
                boolean possivel = true;

                for (int i = 0; i < quantidadeDeVagoes; i++) {
                    int desejado = ordemDosVagoesDesejada[i];

                    // Empilha vagões até encontrar o desejado
                    try {
                        while (proximoVagao <= quantidadeDeVagoes && (pilha.isVazia() || pilha.top() != desejado)) {
                            try {
                                pilha.push(proximoVagao++);
                            } catch (Exception e) {
                                possivel = false;
                                break;
                            }
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    // Verifica se o topo da pilha é o desejado
                    try {
                        if (pilha.top() == desejado) {
                            pilha.pop();
                        } else {
                            possivel = false;
                            break;
                        }
                    } catch (Exception e) {
                        possivel = false;
                        break;
                    }
                }

                if(possivel){
                    System.out.println("Yes");
                }else{
                    System.out.println("No");
                }
            }
        }

        sc.close();
    }
}
