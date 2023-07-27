package model;

import repository.ExibirInterface;

public class Pedido extends Orcamento implements ExibirInterface {
    private String dataEntrega;
    private Boolean entregue;

    public Pedido(String dataEntrega) {
        this.dataEntrega = dataEntrega;
        entregue=false;
    }

    public String getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(String dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public Boolean getEntregue() {
        return entregue;
    }

    public void entregar()throws Exception{
        if(entregue==true)
            throw new Exception("O pedido já foi entregue");
        entregue=true;
    }

    @Override
    public void exibir(Boolean escolha) {
        if (escolha == true) {
            System.out.println("Pedido: " + getId());
            System.out.println("Itens: ");
            for (ItemPedido i : super.getItens()) {
                i.exibir(false);
            }
            System.out.println("Data de entrega: " + dataEntrega);
            if (entregue == true) {
                System.out.println("Situação: Entregue");
            } else
                System.out.println("Situação: Não entregue");

            System.out.println("Valor Total: R$" + super.getValorTotal());
        } else {
            System.out.printf("- " +super.getId() + ", " + dataEntrega + ", ");
            if (entregue == true) {
                System.out.printf("Entregue, ");
            }
            else
                System.out.printf("Não entregue, ");
            System.out.println("R$"+super.getValorTotal());
        }
    }

}