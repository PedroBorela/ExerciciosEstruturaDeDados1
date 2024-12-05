class No {
    Cliente cliente;
    No anterior;
    No proximo;

    public No(Cliente cliente) {
        this.cliente = cliente;
    }
    public No(){
        this.cliente = null;
        this.proximo = null;
        this.anterior = null;
    }
}
