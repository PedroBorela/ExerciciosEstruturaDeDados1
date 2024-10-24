import java.util.*;;

public class Exercicio2 {
 
    public static void main(String[] args){
    Scanner sc= new Scanner(System.in);
        System.out.println("Informe um número:");
        double p =sc.nextInt();

        double total= potencia2(p);
        System.out.println(total);

        sc.close();

    }


    public static double potencia2(double num){
            
        if(num==0){
            return 1;
        }else if(num>0){
            return 2*potencia2(num-1);
        }else{
            return 1/potencia2((-num)-1);
        }


    }


}
