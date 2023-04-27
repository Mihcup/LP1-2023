import java.util.Scanner;
public class jogodavelha {
    public static void main (String args[]){
        Scanner scan = new Scanner (System.in);
        char [][] tabuleiro = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        int linha;
        int coluna;
        char x;



        while(!vitoria(tabuleiro) || !velha()){
            exibirTabuleiro(tabuleiro);
            System.out.println("DEFININDO A POSIÇÃO");
            System.out.println("Digite a linha: ");
            linha = scan.nextInt ();
            System.out.println("Digite a coluna: ");
            coluna = scan.nextInt ();
            System.out.println("Entre com o seu caracter: ");
            tabuleiro[linha][coluna] = scan.next().charAt(0);
        }
    }

   public static boolean vitoria(char[][]tabuleiro){
    return false;

    }

    public static boolean velha (){
        return true;

    }

    public static void exibirTabuleiro (char[][] tabuleiro){
        for (int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                System.out.printf(" |");
                System.out.printf(""+tabuleiro[i][j]);
                System.out.printf("|");
            }

            System.out.printf("\n");
        }

    }
}
