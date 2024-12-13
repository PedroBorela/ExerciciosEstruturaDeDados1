package fibAoContrario;
import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pilha pilha = new Pilha();
        
        System.out.println("Informe a quantidade de elementos da sequência Iccanobif que você quer ver: ");
        int visuFibo = sc.nextInt();
        Iccanobif fibo = new Iccanobif(1);
        try {
            pilha.push(fibo);
            pilha.push(new Iccanobif(1));
        } catch (Exception e) {
            System.out.println("Erro em: "+e.getMessage());
        }
        for(int i=2;i<visuFibo;i++){
            try {
                Iccanobif elTopo = pilha.pop();
                Iccanobif elPenultimo = pilha.pop();
                int novoEl = elTopo.numeroSequencia+elPenultimo.numeroSequencia;
                pilha.push(elPenultimo);
                pilha.push(elTopo);
                pilha.push(new Iccanobif(novoEl));
            } catch (Exception e) {
                System.out.println("Erro em: "+e.getMessage());
            }
        }
        System.out.println("Sequência de iccanobif:");
        while(!pilha.isVazia()){
            try {
                System.out.print(pilha.pop().numeroSequencia +" ");
            } catch (Exception e) {
                System.out.println("Erro");
            }
        }


        sc.close();
        
    }
}