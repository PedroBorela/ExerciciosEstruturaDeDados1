public class Exercicio1 {

    public static void main(String[] args) {
        int[] numeros = { 506,-234,-5,1, 3, 56, 34, 23, 2432, 45, 32, 1, 24, 67, 85 };

        System.out.printf("O maior número do vetor é %d e o menor número do vetor é %d\n", maiorEMenor(numeros)[0],
                maiorEMenor(numeros)[1]);
    }

    // A complexidade assintótica do código é linear
    public static int[] maiorEMenor(int[] nums) {
        int maiorNumero = nums[0];
        int menorNumero = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > maiorNumero) {
                maiorNumero = nums[i];
            }
            if (nums[i] < menorNumero) {
                menorNumero = nums[i];

            }
            
        }
        int[] mm = { maiorNumero, menorNumero };
        return mm;
        
    }

}