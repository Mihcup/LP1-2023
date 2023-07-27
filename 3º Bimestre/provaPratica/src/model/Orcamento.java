package model;

import repository.ExibirInterface;
import java.util.List;
import java.util.ArrayList;

public class Orcamento implements ExibirInterface {
    private static Long idBase=0L;
    private Long id;
    private List<ItemPedido> itens = new ArrayList<>();
    private Double valorTotal = 0.0;

    public Orcamento() {
        id = idBase++;
    }

    public Long getId() {
        return id;
    }

    public static Long getIdBase() {
        return idBase;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void addItem(ItemPedido i){
        itens.add(i);
        valorTotal+= i.getValor();
    }


    public void removerItem(Long id) throws RuntimeException{
        Boolean intermediario = false;
        for (ItemPedido i : itens) {
            if (i.getId() == id) {
                itens.remove(i);
                valorTotal-=i.getValor();
                intermediario = true;
                break;
            }
        }
        if(intermediario==false)
            throw new RuntimeException("O item não foi encontrado");
    }

    @Override
    public void exibir (Boolean escolha){
        if(escolha==true){
            System.out.println("Orçamento: "+id);
            System.out.println("Itens: ");
            for(ItemPedido i: itens){
                i.exibir(false);
            }
            System.out.println("Valor total: R$" +valorTotal);
        }
        else{
            System.out.println("- "+id+", R$"+valorTotal);
        }
    }
}
