
import java.util.Scanner;
public class jogo {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        char[][] tabuleiro = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        int linha;
        int coluna;
        int cont = 0;

        System.out.println("Jogador 1 - x \nJogador 2 - 0");
        while (!vitoria(tabuleiro)) {
            cont++;
            exibirTabuleiro(tabuleiro);
            if(cont%2 != 0)
                System.out.println("Vez do jogador 1");
            else
                System.out.println("Vez do jogador 2");

            System.out.println("DEFININDO A POSIÇÃO");
            linha = lendoLinha();
            coluna = lendoColuna();
            while(tabuleiro[linha][coluna] != ' '){
                System.out.println("Posição já preenchida!");
                System.out.println("Digite a linha novamente: ");
                linha = scan.nextInt();
                System.out.println("Digite a coluna novamente: ");
                coluna = scan.nextInt();
            }
            if(cont%2 != 0)
                tabuleiro[linha][coluna] = 'x';
            else
                tabuleiro[linha][coluna] = '0';
        }
        exibirTabuleiro(tabuleiro);
        if(vitoria(tabuleiro) && !velha(tabuleiro)){
            if(cont%2!=0)
                System.out.println("Vitória do jogador 1!!");
            else
                System.out.println("Vitória do jogador 2!!");
        }
        if(velha(tabuleiro) && vitoria (tabuleiro))
            System.out.println("Deu velha #");

    }

    public static boolean vitoria (char[][] tabuleiro){
        if (tabuleiro[0][0] == tabuleiro[0][1] && tabuleiro[0][1]== tabuleiro[0][2]
                && tabuleiro[0][0]!= ' ' && tabuleiro[0][1]!= ' ' && tabuleiro[0][2]!= ' ')
            return true;
        else {
            if (tabuleiro[1][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[1][2]
                    && tabuleiro[1][0]!= ' ' && tabuleiro[1][1]!= ' ' && tabuleiro[1][2]!= ' ')
                return true;
            else {
                if (tabuleiro[2][0] == tabuleiro[2][1] && tabuleiro[2][1] == tabuleiro[2][2]
                        && tabuleiro[2][0]!= ' ' && tabuleiro[2][1]!= ' ' && tabuleiro[2][2]!= ' ')
                    return true;
                else {
                    if (tabuleiro[0][0] == tabuleiro[1][0] && tabuleiro [1][0] == tabuleiro[2][0]
                            && tabuleiro[0][0]!= ' ' && tabuleiro[1][0]!= ' ' && tabuleiro[2][0]!= ' ')
                        return true;
                    else {
                        if (tabuleiro[0][1] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][1]
                                && tabuleiro[0][1]!= ' ' && tabuleiro[1][1]!= ' ' && tabuleiro[2][1]!= ' ')
                            return true;
                        else {
                            if (tabuleiro[0][2] == tabuleiro[1][2] && tabuleiro[1][2]== tabuleiro[2][2]
                                    && tabuleiro[0][2]!= ' ' && tabuleiro[1][2]!= ' ' && tabuleiro[2][2]!= ' ')
                                return true;
                            else {
                                if (tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][2]
                                        && tabuleiro[0][0]!= ' ' && tabuleiro[1][1]!= ' ' && tabuleiro[2][2]!= ' ')
                                    return true;
                                else {
                                    if (tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][0]
                                            && tabuleiro[0][2]!= ' ' && tabuleiro[1][1]!= ' ' && tabuleiro[2][0]!= ' ')
                                        return true;
                                    else{
                                        if(velha(tabuleiro))
                                            return true;
                                        else
                                            return false;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }


    public static boolean velha(char[][] tabuleiro) {
        if(tabuleiro[0][0]!= ' ' && tabuleiro[0][1]!= ' ' && tabuleiro[0][2]!= ' ' && tabuleiro[1][0]!= ' ' && tabuleiro[1][1]!= ' ' &&
                tabuleiro[1][2]!= ' ' && tabuleiro[2][0]!= ' ' && tabuleiro[2][1]!= ' ' && tabuleiro[2][2]!= ' ')
            return true;
        else
            return false;
    }


    public static void exibirTabuleiro(char[][] tabuleiro) {
        int cont = 0;
        System.out.println("   0   1   2");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(j==0)
                    System.out.printf(cont+" |");
                else
                    System.out.printf(" |");
                System.out.printf("" + tabuleiro[i][j]);
                System.out.printf("|");
            }
            System.out.printf("\n");
            cont++;
        }
    }

    public static int lendoLinha(){
        int linha;
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite a linha: ");
        linha = scan.nextInt();
        while(linha!=0 && linha!=1 && linha!=2){
            System.out.println("Linha inexistente");
            System.out.println("Digite a linha (entre 0 e 2): ");
            linha = scan.nextInt();
        }
        return linha;
    }

    public static int lendoColuna(){
        int coluna;
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite a coluna: ");
        coluna = scan.nextInt();
        while(coluna!=0 && coluna!=1 && coluna!=2 ){
            System.out.println("Coluna inexistente");
            System.out.println("Digite a coluna (entre 0 e 2): ");
            coluna = scan.nextInt();
        }
        return coluna;
    }
}