import java.util.Scanner;
public class matrizevetor {
        public static void main (String [] args){
            Scanner scan = new Scanner(System.in);
            String [] nomes = new String[3];
            double [][]  contas = new double [4][4];
            double [] intermediario = new double [3];
            int op;
            int cont=0;
            int cont2=0;

           while(cont<3){
               System.out.println("Digite o "+ (cont+1) +"° nome");
               nomes[cont] = scan.nextLine();
               cont++;
           }
            Exibirvetor(nomes);
            System.out.println("\n 1 - retorna o primeiro nome \n 2 a 10 - retorna o segundo nome \n maior que 10 - retorna o terceiro nome");
            while(cont2<4){
                System.out.println("Digite um número inteiro de opção: ");
                op = scan.nextInt ();
                VerificaNumero(op, nomes);
                cont2++;
            }
            cont =0;
            while(cont<3){
                System.out.println("Digite o " + (cont+1) + "° numero: ");
                intermediario[cont] = scan.nextDouble();
                cont++;
            }
            Exibirmatriz(contas,intermediario);

        }

        public static void Exibirvetor(String [] nomes){
            int i;
            System.out.println("Nomes digitados: ");
            for(i=0; i<3; i++){
                System.out.printf(nomes[i] + " ");
            }

        }
        public static void Exibirmatriz (double[][]contas, double[] intermediario){
            Scanner scan = new Scanner (System.in);
            for(int i = 0; i <4; i++){
                for(int j =0; j<4; j++){
                    if(i==0 && j==0)
                        contas[0][0] = 0;
                    else if(j==0)
                        contas[i][j] = intermediario[i-1];
                    else if(i==0)
                        contas[i][j] = intermediario[j-1];
                    else if(i!=j)
                        contas[i][j] = intermediario[i-1] - intermediario[j-1];
                    else if(i==j)
                        contas[i][j] = intermediario[i-1]*intermediario[j-1];

                }
            }

            for(int i = 0; i<4; i++){
                for(int j = 0; j<4; j++){
                    System.out.print(" " +contas[i][j]);
                }
                System.out.printf("\n");
            }

            }


        public static void VerificaNumero (int op, String [] nomes){
            if(op==1)
                System.out.println("Nome: "+nomes[0]);
            else
            if(op>=2 && op<=10)
                System.out.println("Nome: "+nomes[1]);
            else
            if(op>10)
                System.out.println("Nome: " +nomes[2]);
            else
                System.out.println("Opção inválida!");
        }


    }

