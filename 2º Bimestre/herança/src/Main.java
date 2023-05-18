public class Main {
    public static void main (String[] args){
        Lazer lazer1 = new Lazer("Viajar", 1200,true);
        lazer1.mudarValor(lazer1.getValor());
        System.out.println("Lazer: \n" + lazer1.getNome() +" "+ lazer1.getValor() +" ");

        Variavel variavel1 = new Variavel("Shopping", 100, 12);
        System.out.println("Variavel: \n"+ variavel1.getNome() +" " + variavel1.getValor()+" "+variavel1.getTempoMeses()+" meses");

        Fixo fixo1 = new Fixo("Telefone", 120);
        System.out.println("Fixo: \n"+  fixo1.getNome() + " " + fixo1.getValor());
    }
}
