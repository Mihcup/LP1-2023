package entity;

import jakarta.persistence.*;

@Entity // informa que a classe se refera a uma entidade do banco de dados
@Table (name="pessoa")// informa que a classe é uma tabela
public class Pessoa {
    @Id // é para falar que é chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // serve para que a tabela gere os valores automaticamente
    // strategy -> que estrategia vai ser usada para gerar o id
    //identity -> sequencial
    // uuid -> gera um número exclusivo
    private int id;
    @Column
    private String nome;
    @Column
    private String sobrenome;
    @Column
    private String email;
    @OneToOne (cascade = CascadeType.ALL) // coluna quando não é mais nada alem de coluna
    @JoinColumn(name="enderecoId")
    private Endereco endereco;
    public Pessoa(String nome, String sobrenome, String email, Endereco endereco) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.endereco = endereco;

    }
    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", email='" + email + '\'' +
                ", endereco=" + endereco +
                '}';
    }
}
