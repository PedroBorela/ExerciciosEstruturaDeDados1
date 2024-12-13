package fibAoContrario;
public class Pilha {
    int tamanho = 0;
    Iccanobif topo;

    public Pilha() {
        this.topo = null;
    }

    public boolean isVazia() {
        return tamanho == 0;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void push(Iccanobif p) throws Exception {
        if (tamanho != 0)
            p.proximo = topo;
        topo = p;
        ++tamanho;

    }

    public Iccanobif pop() throws Exception {
        if (isVazia())
            throw new Exception("pilha vazia");
        Iccanobif p = topo;
        topo = topo.proximo;
        --tamanho;
        return p;
    }

    public Iccanobif top() throws Exception {
        if (isVazia())
            throw new Exception("Lista vazia");
        return topo;
    }
}