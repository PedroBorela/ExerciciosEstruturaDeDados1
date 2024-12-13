package jogo21;
public class Pilha {
    static final int MAX_TAM = 100;
    int tamanho = 0;
    Carta topo;

    public Pilha() {
        this.topo = null;
    }

    public boolean isVazia() {
        return tamanho == 0;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void push(Carta p) throws Exception {
        if (tamanho != 0)
            p.proximo = topo;
        topo = p;
        ++tamanho;

    }

    public Carta pop() throws Exception {
        if (isVazia())
            throw new Exception("pilha vazia");
        Carta p = topo;
        topo = topo.proximo;
        --tamanho;
        return p;
    }

    public Carta top() throws Exception {
        if (isVazia())
            throw new Exception("Lista vazia");
        return topo;
    }
}