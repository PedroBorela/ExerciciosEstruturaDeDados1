public class Pilha{
    static final int MAX_TAM =100;
    String[] pilha = new String[MAX_TAM];
    int topo=-1;
    public boolean isVazia(){
        return topo==-1;
    }
    public int getTamanho(){
        return topo+1;
    }
    public void push(String p ) throws Exception{
        if(topo==MAX_TAM-1)
        throw new Exception("Não há espaços disponíves");
        pilha[++topo]=p;

    }
    public String top() throws Exception{
        if(isVazia())
        throw new Exception("lista vazia");
        return pilha[topo];
    }

    public String pop()throws Exception{
        if(isVazia())
        throw new Exception("Lista vazia");
        return pilha[topo--];
    }
}
