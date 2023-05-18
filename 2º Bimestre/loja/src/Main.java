public class Main {
    public static void main (String[]args){
        Loja loja = new Loja("RENNER");
        System.out.println(loja.getNome());
        loja.addCliente(new Clientes( "Millena", "12345678912","990876543"));
        loja.addCliente(new Clientes( "Nalu", "13567690876","997654312"));
        loja.addCliente(new Clientes( "Marcelo", "45678910807","22134587"));
        Clientes cliente1 = new Clientes("Sonia", "12345674569", "947314609");
        loja.addCliente(cliente1);
        loja.addPedido(new Pedidos(cliente1, "Lápis", 3.20, 124));
        loja.addPedido(new Pedidos(cliente1, "Borracha", 1.50, 125));
        loja.addPedido(new Pedidos(cliente1, "Caderno", 15.50, 126));


        System.out.println("Lista de clientes: ");
        loja.mostrarListaClientes();

        System.out.println("\nCliente específico: ");
        Clientes novo = new Clientes();
        for (Clientes cl: loja.getClientes()) {
            if (cl.getNome() == "Nalu")
                novo = cl;
        }
        Pedidos pedido = new Pedidos (novo, "Caderno", 15.50, 123);
        loja.addPedido(pedido);
        System.out.println(pedido.getCliente().getNome());
        System.out.println(pedido.getProduto()+"\n");

        System.out.println("Pedidos do mesmo cliente: ");
        for (Pedidos pedido2:loja.getPedidos()){
            if(pedido2.getCliente().getNome() == "Sonia"){
                System.out.println(pedido2.getCliente().getNome()+ " "+ pedido.getCodigo() + " " + pedido.getProduto()+ " " + pedido.getValor() );
            }
        }



    }
}
