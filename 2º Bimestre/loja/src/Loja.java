import java.util.ArrayList;
import java.util.List;
public class Loja {
    private String nome;
    private List<Clientes> clientes = new ArrayList<>();
    private List<Pedidos> pedidos= new ArrayList<>();

    public Loja (String nome){
        this.nome = nome;
    }

    // getter e setter de nome
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public List<Clientes> getClientes(){
        return clientes;
    }
    public void setClientes(List<Clientes> cliente){
        this.clientes = cliente;
    }
    public void addCliente(Clientes cliente){
        this.clientes.add(cliente);
    }


    public List<Pedidos> getPedidos(){
        return pedidos;
    }
    public void setPedidos(List<Pedidos> pedido){
        this.pedidos = pedido;
    }
    public void addPedido(Pedidos pedido){
        this.pedidos.add(pedido);
    }
    
    public void mostrarListaClientes(){
        for (Clientes cliente: getClientes()){
            System.out.println(cliente.getNome() + "\n" + cliente.getCPF() + "\n" + cliente.getTelefone());
        }

    }
}
