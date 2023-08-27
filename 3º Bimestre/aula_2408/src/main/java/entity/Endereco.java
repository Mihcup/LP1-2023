package entity;

import jakarta.persistence.*;

@Entity(name="enderecos")
//estrutura que vai armazenar dados
@Table(name="enderecos")
/*classe que representa uma tabela
uma entidade pode não formar uma tabela
o nome da tabela vai ser o mesmo nome da classe se não for modificados
 */
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // assinatura que vai gerar os valores automaticamente -> os ids podem ser gerados de forma sequencial, aleatória
    //IDENTITY -> sequencial 1,2,3
    private int id;
    // como demarca a identidade de uma classe primária
    @Column
    private String rua;
    @Column
    private String cidade;

    public Endereco( String rua, String cidade) {
        this.rua = rua;
        this.cidade = cidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "id=" + id +
                ", rua='" + rua + '\'' +
                ", cidade='" + cidade + '\'' +
                '}';
    }
}
