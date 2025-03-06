public class Arvore{
    No raiz =null;

    public void inserir(No no, Ano ano){
        if(no!= null){
            if(ano.temp < no.ano.temp){
                if(no.esquerda!=null)
                    inserir(no.esquerda,ano);
                else
                    no.esquerda = new No(ano);
            
        }else{
            if(no.direita!= null)
                inserir(no.direita,ano);
            else
                no.direita = new No(ano);
        }
    }else{
        raiz = new No(ano);
    }
}

public void inOrdem(No no){
    if(no!=null){
        inOrdem(no.esquerda);
        System.out.println("Ano: "+no.ano.ano+" Temperatura: " +no.ano.temp);
        inOrdem(no.direita);
    }
}

public Ano maiorTemp(No no){
    if(no!=null){
        if(no.direita==null)
         return no.ano;

    }

    return maiorTemp(no.direita);
  
}


}