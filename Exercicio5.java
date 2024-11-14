

public class Exercicio5 {
    public static void main(String[] args) {
        int[] ve= {55,4,333,1,2,3,56,34,2323,545};
        imprimeCrescente(ve);
    }

   

    public static void imprimeCrescente(int[] vet){
        for(int i=0; i<vet.length;i++){
            int num=Integer.MAX_VALUE;
            int indiceMenor=-1;
            for(int j=0; j<vet.length;j++){
                if (vet[j] < num) {
                    num = vet[j];
                    indiceMenor = j;
                }
                
            }
            System.out.print(" "+num);
            vet[indiceMenor]=Integer.MAX_VALUE;
        }
    }

    
}
