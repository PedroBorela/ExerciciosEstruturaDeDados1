public class No {
    No proximo;
     No anterior;
     Cidade cidade;
    public No(Cidade c){
        this.cidade=c;
    }
    public No(){
        this.anterior=null;
        this.proximo= null;
        this.cidade = null;
    }

}
