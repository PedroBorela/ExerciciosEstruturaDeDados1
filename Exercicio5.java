import java.util.*;

public class Exercicio5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try{
        System.out.println("\nDigite um número: ");
        int num = sc.nextInt();
        System.out.println("\nDigite um número: ");
        int num2 = sc.nextInt();

        System.out.printf("O mdc dos números %d e %d é %d\n", num, num2, mdc(num, num2));

        sc.close();
        }catch(Exception e){
            System.out.println("Não é uma entrada válida");
        }
    }

    public static int mdc(int num, int num2) {
        num = Math.abs(num);
        num2 = Math.abs(num2);

        if (num >= num2 && num%num2 == 0)
            return num2;
        else {
            if (num < num2) {
                return mdc(num2, num);
            }

            return mdc(num2, num % num2);
        }

    }
}
