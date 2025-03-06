
import java.util.*;
public class App {

    


public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    Ano ano ;
    int anoMaior;
    Arvore arvore = new Arvore();
    int valorAno, maiorTemp;
    double temp;
    int qtdEntrada= sc.nextInt();
    sc.nextLine();
    while(true){
        if(qtdEntrada==0){
            break;
        }
        try{
        for(int i =0 ; i<qtdEntrada;i++){
            valorAno = sc.nextInt();
            temp = sc.nextDouble();
            sc.nextLine();
            ano = new Ano(valorAno,temp);
            //System.out.println(ano);
            arvore.inserir(arvore.raiz,ano);

        }
        System.out.println(arvore.maiorTemp(arvore.raiz));
        maiorTemp = arvore.maiorTemp(arvore.raiz).ano;
        }catch(Exception e){
            System.out.println(e.getMessage());
                break;
    }
    qtdEntrada = sc.nextInt();
    sc.nextLine();
    for(int i =0 ; i<qtdEntrada;i++){
        anoMaior = sc.nextInt();
        if(anoMaior == maiorTemp){
            System.out.println("correto");
        }else{
            System.out.println("incorreto");

        }

    }
    sc.close();

}
}
}