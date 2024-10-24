import  java.util.*;

public class Exercicio1{


    public static void main(String[] args){
        

        Scanner sc=new Scanner(System.in);
        try{
        System.out.print("\nInforme um número: ");
        int numSugerido = sc.nextInt();
        

        System.out.println("Que operação deseja realizar?\n (1)Fibonacci\n(2)Fatorial");
        int escolha = sc.nextInt();
        switch(escolha){
            case 1:
            Fibonacci(numSugerido);
            break;
            case 2:
            Fatorial(numSugerido);
            break;
            default:
            System.out.println("Não há opção compatível");
            break;
        }
        

        // Fibonacci(numSugerido);
        // Fatorial(numSugerido);
    
       
    
        sc.close();
    }catch(Exception e){
        System.out.println("Não é um número");
    }
        

    }

    public static void Fibonacci(int num){
        int numAnterior=0,numAtual=1,numProximo=0;
        System.out.print("===========================");

        if(num>0){
            for(int i=0;i<num;i++){
                numProximo=numAnterior+numAtual;
                numAnterior=numAtual;
                numAtual=numProximo;
                
            }
            System.out.printf("\nO %dº número fibonacci é %d",num,numAnterior);
            }else{
        
            System.out.print("\nO número não pode ser negativo");
        }
        System.out.print("\n===========================");

    }


    public static void Fatorial(int num){
        double total=1;
        System.out.print("\n===========================");
        if(num<0){
            System.out.print("\nNão existe fatorial para esse número");
        }
        else if(num ==0 || num==1){
            total=1;
        System.out.printf("\nO fatorial de %d é %.0f",num,total);

        }else{
        for(int i=1; i <= num;i++){
            total*=i;
        }
        System.out.printf("\nO fatorial de %d é %.0f",num,total);
       
    }
    System.out.print("\n===========================");

    }




}
