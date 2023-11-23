package br.dedigados.gerenciadordetarefas_lp1.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table
@Entity
public class Usuario {
    // a classe contém as informações sobre o usuário
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nome;
    //nome do usuário

    @Column
    private String login;
    //login do usuário

    @Column
    private String senha;
    //senha para acessar o gerenciador de tarefas

    @OneToMany(cascade = CascadeType.ALL)
    private List<Tarefa> tarefas = new ArrayList<>();
    // lista de tarefas do usuário

    public Usuario(){

    }
    public Usuario(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }// construtor sem id, pois o mesmo será auto incrementado no MySQL


    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", senha='" + senha + '\'' +
                ", tarefas=" + tarefas +
                '}';
    }

    public void addTarefa(Tarefa tarefa){
        tarefas.add(tarefa);
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

}
