public class Main {
    public static void main (String[]args){
        Loja loja = new Loja("Renner");
        loja.addCliente(new Clientes( "Millena", 123456,987639610));
        loja.addCliente(new Clientes( "Naluzinha", 135676,997383065));
        loja.addCliente(new Clientes( "Marcelo", 4567891,22122037));

        System.out.println("Lista de clientes: ");
        for(Clientes cliente: loja.getClientes()){
            System.out.println(cliente.getNome());
        }

       Clientes cliente = new Clientes("Millena", 1234578, 123456789);
        Pedidos pedido = new Pedidos (cliente, "Caderno", 15.50, 123);
        System.out.println(pedido.getCliente().getNome());
        System.out.println(pedido.getProduto());

    }
}
