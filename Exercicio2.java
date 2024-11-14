public class Exercicio2 {

    public static void main(String[] args) {
        int[] numeros = {1,2,5,3,22,6,3,2};

        System.out.printf(
                "\nOs três primeiros maiores números são %d,%d,%d\n",
                maiorEMenor3(numeros)[0],maiorEMenor3(numeros)[1], maiorEMenor3(numeros)[2]);
    }

    public static int[] maiorEMenor3(int[] nums) {
        int[] maiorNumero = { nums[0],nums[0],nums[0]};
        

        for(int num: nums){
            if(num>maiorNumero[0]){
                maiorNumero[2]=maiorNumero[1];
                maiorNumero[1]=maiorNumero[0];
                maiorNumero[0]=num;
            }else if(num>maiorNumero[1]){
                maiorNumero[2]=maiorNumero[1];
                maiorNumero[1]=num;
            }else if(num>maiorNumero[2]){
                maiorNumero[2]=num;
            }

        }
        int[] mm =  maiorNumero;
        return mm;

    }
}
