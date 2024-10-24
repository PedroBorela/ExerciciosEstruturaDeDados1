import java.util.*;

public class Exercicio4{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        try{

        System.out.println("Insira o primeiro número: ");
        int n1= sc.nextInt();
        
        System.out.println("Insira o segundo número: ");
        int n2= sc.nextInt();

        int resultado= soma(n1, n2);
        System.out.printf("O resultado da multiplicação através de soma entre %d e %d é %d\n",n1,n2,resultado);
        sc.close();
        }catch(Exception e){
            System.out.println("Não é uma entrada válida");
        }
    }

    public static int soma(int num,int num2){
        if(num2==0){
            return 0;
        }
        if(num2>0){

            return num+soma(num,num2-1);
        }else if(num2<0){

            return -(num+soma(num,(-num2)-1));
        }
        
        return num;
    }
}
