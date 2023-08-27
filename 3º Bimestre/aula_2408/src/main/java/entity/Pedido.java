package entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne (cascade = CascadeType.ALL) // cascade garamte que salva o que está interno
    @JoinColumn(name="pessoaId") // coluna de junção
    private Pessoa pessoa;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="pedido_produto",
            joinColumns = @JoinColumn(name="pedidoId"),//criando nessa tabela
            inverseJoinColumns = @JoinColumn(name="produtoId")
    ) // uma tabela que armazena duas chaves estrangeiras
    private List<Produto> produtos = new ArrayList<>();
    @Column
    private float saldoTotal=0;

    public Pedido (Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Pedido(Pessoa pessoa, List<Produto> produtos) {
        this.pessoa = pessoa;
        this.produtos = produtos;   for(Produto p: produtos){
            this.saldoTotal+=p.getPreco();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }


    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", pessoa=" + pessoa +
                ", produtos=" + produtos +
                ", saldoTotal=" + saldoTotal +
                '}';
    }

    public void addProduto(Produto p){
        produtos.add(p);
        this.saldoTotal+=p.getPreco();
    }
}
