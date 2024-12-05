public class ListaCidades {
    private No cabeca = new No();
    private No cauda = cabeca;
    private int tamanho = 0;

    public void insereDecrescente(Cidade cidade) {
        No novoNo = new No(cidade);
        if (cabeca.proximo == null) { // lista vazia
            cabeca.proximo = novoNo;
            novoNo.anterior = cabeca;
            cauda = novoNo;
            cauda.anterior = cabeca;
        } else if (cidade.getAvaliacao() > cabeca.proximo.cidade.getAvaliacao()) {
            novoNo.proximo = cabeca.proximo;
            cabeca.proximo.anterior = novoNo;
            cabeca.proximo = novoNo;
            novoNo.anterior = cabeca;
        } else { // inserir no meio ou no final
            No atual = cabeca.proximo;

            while (atual.proximo != null && atual.proximo.cidade.getAvaliacao() > cidade.getAvaliacao()) {
                atual = atual.proximo;
            }

            novoNo.proximo = atual.proximo;
            novoNo.anterior = atual;

            if (atual.proximo != null) {
                atual.proximo.anterior = novoNo;
            } else {
                cauda = novoNo;
                cauda.anterior = atual;
            }

            atual.proximo = novoNo;
        }
        tamanho++;
    }

    public No exibirPrimeiraVez() throws Exception {
        if (tamanho == 0)
            throw new Exception("A lista está vazia");

        System.out.println(cabeca.proximo.cidade.toString());
        return cabeca.proximo;
    }

    public No exibirProximo(No atual) throws Exception {
        if (atual == null || atual.proximo == null) { // Verifique se o próximo nó existe
            System.out.println("Fim da lista.");
            return null;
        } else {
            atual = atual.proximo;
            System.out.println(atual.cidade.toString());
            return atual;
        }
    }
    
    public No exibirAnterior(No atual) throws Exception {
        if (atual == null || atual.anterior == cabeca) { // Verifique se o anterior existe
            System.out.println("Início da lista.");
            return null;
        } else {
            atual = atual.anterior;
            System.out.println(atual.cidade.toString());
            return atual;
        }
    }

    public boolean excluirPorNome(String nome) {
        No atual = cabeca.proximo;
        No anterior = cabeca;

        while (atual != null) {
            if (atual.cidade.getNome().equals(nome)) {
                anterior.proximo = atual.proximo;

                if (atual == cauda) {
                    cauda = anterior;
                }else{
                    if(atual.proximo!= null)
                    atual.proximo.anterior=anterior;
                }

                tamanho--;
                return true;
            }
            anterior = atual;
            atual = atual.proximo;
        }
        return false;
    }

    public boolean excluirPorPais(String pais) {
        No atual = cabeca.proximo;
        No anterior = cabeca;

        while (atual != null) {
            if (atual.cidade.getPais().equals(pais)) {
                anterior.proximo = atual.proximo;

                if (atual == cauda) {
                    cauda = anterior;
                }else{
                    if(atual.proximo!= null){
                        atual.proximo.anterior=anterior;
                    }
                }

                tamanho--;
                return true;
            }
            anterior = atual;
            atual = atual.proximo;
        }
        return false;
    }

}
