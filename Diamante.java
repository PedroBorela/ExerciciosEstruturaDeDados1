import java.util.Scanner;

public class Diamante {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String[] mineracao;
        int qtdCasos;
        Pilha pilha;
        int diamantes=0;

        try{    
            qtdCasos = sc.nextInt();
            sc.nextLine();
            mineracao= new String[qtdCasos];
            int i = 0;
            while(i< qtdCasos){
                mineracao[i] = sc.nextLine();
                pilha = new Pilha();
                for(int j=0;j<mineracao[i].length();j++){
                   String letra = String.valueOf( mineracao[i].charAt(j));
                   //System.out.println(letra);
                    if(letra.equals("<")&& !letra.equals(".")){
                        pilha.push(letra);
                    }
                    if(letra.equals(">") && !pilha.isVazia()){ 
                        pilha.pop();
                            ++diamantes;
                    }
                }
                System.out.println(diamantes);
                diamantes=0;
                i++;
            }










        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            sc.close();
        }







    }
}
