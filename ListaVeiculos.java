public class ListaVeiculos {

    private final No cabeca = new No(null);
    private No cauda = cabeca;
    private int tamanho = 0;

    public void inserirVeiculo(Veiculo veiculo) {
        No novoNo = new No(veiculo);

        if (tamanho == 0) {
            cabeca.proximo = novoNo;
        } else {
            cauda.proximo = novoNo; 
        }

        cauda = novoNo; 
        tamanho++;
    }

    public boolean excluirVeiculo(String placa) {
        No atual = cabeca.proximo;
        No anterior = cabeca;

        while (atual != null) {
            if (atual.veiculo.placa.equals(placa)) {
                anterior.proximo = atual.proximo;

                if (atual == cauda) {
                    cauda = anterior;
                }

                tamanho--;
                return true;
            }
            anterior = atual;
            atual = atual.proximo;
        }
        return false;
    }

    public void exibirVeiculos() {
        if (tamanho == 0) {
            System.out.println("Nenhum veículo cadastrado.");
            return;
        }

        No atual = cabeca.proximo;
        while (atual != null) {
            System.out.println(atual.veiculo);
            atual = atual.proximo;
        }
    }

}
