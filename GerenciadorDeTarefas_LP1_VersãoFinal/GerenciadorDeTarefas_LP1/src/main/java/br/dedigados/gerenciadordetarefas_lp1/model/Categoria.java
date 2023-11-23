package br.dedigados.gerenciadordetarefas_lp1.model;
import jakarta.persistence.*;

@Table
@Entity
public class Categoria {
    //classe que será usada para categorizar as tarefas
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nome;
    //nome da disciplina


    public Categoria(String nome) {
        this.nome = nome;

    }// construtor sem id, pois o mesmo será auto incrementado no MySQL

    public Categoria() {
    }

    public Categoria(String nome,int id) {
        this.nome = nome;
        this.id = id;
    }
    @Override
    public String toString() {
        return "Cateogoria{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }

    //getters e setter dos atributos
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



}
