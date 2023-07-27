package model;

import repository.ExibirInterface;

public class ItemPedido implements ExibirInterface {
    private static Long idBase=0L;
    private Long id;
    private String peca;
    private String modelo;
    private String tamanho;
    private Double valor;

    public ItemPedido(String peca, String modelo, String tamanho, Double valor) {
        this.peca = peca;
        this.modelo = modelo;
        this.tamanho = tamanho;
        this.valor = valor;
        id = idBase++;
    }

    public String getPeca() {
        return peca;
    }

    public void setPeca(String peca) {
        this.peca = peca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public static Long getIdBase() {
        return idBase;
    }
    @Override
    public void exibir(Boolean escolha){
        if(escolha==true){
            System.out.println("Item do pedido: "+ id);
            System.out.println("- Peça: "+peca);
            System.out.println("- Modelo: "+modelo);
            System.out.println("- Tamanho: "+tamanho);
            System.out.println("- Valor: R$"+valor);
        }
        else{
            System.out.println("- "+peca+", "+modelo+", "+tamanho+", R$"+valor);
        }
    }
}

