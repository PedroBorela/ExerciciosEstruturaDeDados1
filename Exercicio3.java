import java.util.*;

public class Exercicio3{



    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        try{
        System.out.println("\nDigite um número: ");
        int num = sc.nextInt();
        System.out.printf(primo(num)? "O número %d é primo\n" : "O número %d não é primo\n",num);



        sc.close();
        }catch(Exception e){
            System.out.println("Não é uma entrada válida");
        }
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

    public static boolean primo(int num){
        return primo(num,2);
    }

}
