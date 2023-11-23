package br.dedigados.gerenciadordetarefas_lp1.model;
import jakarta.persistence.*;

@Table
@Entity
public class Tarefa {
    // essa classe vai ser responsável por armazenar informações das atividades do usuário
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String titulo;
    //nome da tarefa

    @Column
    private String descricao;
    //descrição da tarefa

    @Column
    private String dataDeVencimento;
    //data limite para conclusão da tarefa

    @Column
    private boolean status;
    // status da tarefa (concluída ou pendente)

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;
    //disciplina da tarefa



    public Tarefa(String titulo, String descricao, String dataDeVencimento, boolean status) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataDeVencimento = dataDeVencimento;
        this.status = status;
    }


    public Tarefa() {

    }

    public Tarefa(String titulo, String descricao, String dataDeVencimento, boolean status, Categoria categoria) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataDeVencimento = dataDeVencimento;
        this.status = status;
        this.categoria = categoria;
    } // construtor sem id, pois o mesmo será auto incrementado no MySQL

    @Override
    public String toString() {
        return "Tarefa{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataDeVencimento='" + dataDeVencimento + '\'' +
                ", status=" + status +
                ", categoria=" + categoria +
                '}';
    }


    //getters e setter dos atributos
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataDeVencimento() {
        return dataDeVencimento;
    }

    public void setDataDeVencimento(String dataDeVencimento) {
        this.dataDeVencimento = dataDeVencimento;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Categoria getDisciplina() {
        return categoria;
    }

    public void setDisciplina(Categoria categoria) {
        this.categoria = categoria;
    }

}
