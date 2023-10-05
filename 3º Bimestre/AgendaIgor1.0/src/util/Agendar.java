package util;

public abstract class  Agendar {
    private String nome;
    private String data;
    private String descricao=null;
    private int id;

    // construtor com descrição
    public Agendar(String nome, String data, String descricao) {
        this.nome = nome;
        this.data = data;
        this.descricao = descricao;
    }


    // construtor sem descrição
    public Agendar(String nome, String data) {
        this.nome = nome;
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }


    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    //método de visualização dos agendamentos
    public abstract void visualizar(int descricao);
}


