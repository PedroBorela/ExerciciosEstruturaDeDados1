import java.util.Scanner;

public class Exercicio6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o tamanho do vetor:");
        try {
            int n = sc.nextInt();
        int[] v1= new int[n];
        int[] v2= new int[n];
        int[] v3= new int[n];

        for(int j=0;j<v1.length;j++){
            v1[j]= (int)(Math.random()*1500)+1;
            v2[j]= (int)(Math.random()*1500)+1;
        }
        v3= novoVetor(v1, v2);
        imprimeVetor(v1);
        imprimeVetor(v2);
        imprimeVetor(v3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        sc.close();
    }

    public static int[] novoVetor(int[] v1,int[] v2){
        int[] v3= new int[v1.length];
        int indicev1=0;
        int indicev2=0;
        for(int i=0;i<v1.length;i++){
            int aleatorio = (int)(Math.random()*100)+1;
            System.out.println("O número sorteado foi: "+aleatorio);
            if(aleatorio%2==0){
                v3[i]=v1[indicev1];
                indicev1++;
            }else{
                v3[i]=v2[indicev2];
                indicev2++;
            }
        }

        return v3;

    }

    public static void imprimeVetor(int[] vet) {
        System.out.println();
        
        for (int i = 0; i < vet.length; i++) {
            System.out.print(" " + vet[i]);
        }
        System.out.println();
    }
}
