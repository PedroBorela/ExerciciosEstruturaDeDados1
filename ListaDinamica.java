public class ListaDinamica {
    private final No cabeca = new No(null);
    private No cauda = null; 
    private int tamanho = 0;

    public void inserirOrdenado(Cliente cliente) {
        No novoNo = new No(cliente);

        if (cabeca.proximo == null) { 
            cabeca.proximo = novoNo;
            novoNo.anterior = cabeca;
            cauda = novoNo;
        } else if (cliente.getCodigo() < cabeca.proximo.cliente.getCodigo()) { 
            novoNo.proximo = cabeca.proximo;
            cabeca.proximo.anterior = novoNo;
            cabeca.proximo = novoNo;
            novoNo.anterior = cabeca;
        } else { 
            No atual = cabeca.proximo;

            while (atual.proximo != null && atual.proximo.cliente.getCodigo() < cliente.getCodigo()) {
                atual = atual.proximo;
            }

            novoNo.proximo = atual.proximo;
            novoNo.anterior = atual;

            if (atual.proximo != null) {
                atual.proximo.anterior = novoNo;
            } else {
                cauda = novoNo; 
            }

            atual.proximo = novoNo;
        }
        tamanho++;
    }

    public void exibirCrescente() {
        if (tamanho == 0) {
            System.out.println("A lista está vazia.");
            return;
        }
        No atual = cabeca.proximo; 
        while (atual != null) {
            System.out.println(atual.cliente.toString());
            atual = atual.proximo;
        }
    }

    public void exibirDecrescente() {
        if (tamanho == 0) {
            System.out.println("A lista está vazia.");
            return;
        }
        No atual = cauda;
        while (atual != null && atual!= cabeca) {
            System.out.println(atual.cliente.toString());
            atual = atual.anterior;
        }
    }
}
