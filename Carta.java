package jogo21;
public class Carta {
    int cartaAtual;
    Carta proximo;

    public Carta(int card) {
        this.cartaAtual = card;
        this.proximo = null;
    }

    Carta() {
    }

}
