import java.util.*;

public class Exercicio3{



    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.println("\nDigite um número: ");
        int num = sc.nextInt();
        System.out.printf(primo(num,2)? "O número %d é primo" : "O número %d não é primo",num);



        sc.close();
    }

    public static boolean primo(int num,int div){
        if(num<=1)
            return false;
        else{
            if(div*div>num){
                return true;
            }else if(num%div==0){
                    return false;
                }
        }
        return primo(num,div+1);
    }

}