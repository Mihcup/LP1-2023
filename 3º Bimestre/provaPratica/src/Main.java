import model.*;

public class Main {
    public static void main (String[] args) {
        ItemPedido item1 = new ItemPedido("Casaco", "Moletom", "M", 99.80);
        item1.exibir(true);
        item1.exibir(false);
        Orcamento orcamento = new Orcamento();
        orcamento.addItem(item1);
        orcamento.exibir(true);
        orcamento.exibir(false);

        ItemPedido item2 = new ItemPedido("Calça", "Wide leg", "M", 125.50);
        orcamento.addItem(item2);
        orcamento.exibir(true);
        try{
            orcamento.removerItem(item2.getId());
        } catch(RuntimeException e){
            System.out.println(e.getMessage());
            System.out.println(e.getMessage());
        }

        try {
            orcamento.removerItem(3L);;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }


        orcamento.exibir(true);

        Pedido pedido1 = new Pedido("24/05/23");
        pedido1.addItem(item1);
        pedido1.exibir(true);
        pedido1.exibir(false);
        try {
            pedido1.entregar();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        pedido1.exibir(false);
        try {
            pedido1.entregar();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        pedido1.exibir(false);
    }
}