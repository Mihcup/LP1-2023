import entity.Endereco;
import entity.Pedido;
import entity.Pessoa;
import entity.Produto;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Endereco e1 = new Endereco("Rua das Palmeiras","São Paulo");
        Endereco e2 = new Endereco("Rua de Jardim","Sorocaba");
        Endereco e3 = new Endereco("Rua de Bento","Rio de janeiro");
        Endereco e4 = new Endereco("Rua Canindé","São Paulo");

        Transaction transaction1 = session.beginTransaction();
        session.persist(e1);
        session.persist(e2);
        session.persist(e3);
        session.persist(e4);
        // métodos persist manda para o bdd
        transaction1.commit();

        List<Endereco> enderecos = session.createQuery("from enderecos", Endereco.class).list();// guardar o
        enderecos.forEach(e-> System.out.println(e));

        Pessoa p1 = new Pessoa("Mih", "Cupolillo", "millenacupolillo@aluno.ifsp",e1);
        Pessoa p2 = new Pessoa("Juan", "Oliveira", "juanjuan@gmail.com",e2);
        Pessoa p3 = new Pessoa("Josi", "Agroboia","agroboiazo@gmail",e3);
        Pessoa p4 = new Pessoa("Mariah", "PopePepe", "mariahpopepepe@gmail.com",e4);



        Transaction transaction = session.beginTransaction(); // começo a transação -> inicio uma transacao (varias ações que eu posso realizar ) na minha sessao
        // pode colocar o mesmo objeto, como se fosse uma variável
        // transaction1 = session.beginTransaction(); -> reutilizando a transação
        session.persist(p1);
        session.persist(p2);
        session.persist(p3);
        session.persist(p4);
        transaction.commit(); // SESSÃO PODE SER A MESMA, A TRANSAÇÃO PRECISA SER OUTRA
        //commit transação fecha a transação
        List<Pessoa> pessoas = session.createQuery("from Pessoa", Pessoa.class).list(); // tenho uma lista das pessoas que tenho no meu banco de dados
        pessoas.forEach(p-> System.out.println(p)); // foreach diferente -> não precisa falar o tipo da variável p

        // adicionando endereco ao BDD
        /*Endereco e1 = new Endereco("Rua das Palmeiras","São Paulo");
        Endereco e2 = new Endereco("Rua de Jardim","Sorocaba");
        Transaction transaction1 = session.beginTransaction();
        session.persist(e1);
        session.persist(e2);
        // métodos persist manda para o bdd
        transaction1.commit();
        List<Endereco> enderecos = session.createQuery("from enderecos", Endereco.class).list();// guardar o
        enderecos.forEach(e-> System.out.println(e));

         */

        Produto p01 = new Produto("Calça","R$ 50,00");
        Produto p02 = new Produto("Blusa","R$ 30,00");
        transaction = session.beginTransaction();
        session.persist(p01);
        session.persist(p02);
        transaction.commit();

        List<Produto> produto = session.createQuery("from Produto", Produto.class).list(); // tenho uma lista das pessoas que tenho no meu banco de dados
        pessoas.forEach(p-> System.out.println(p));

        Pedido pedido1 = new Pedido(p1);
        Pedido pedido2 = new Pedido(p2);
        pedido1.addProduto(p01);
        pedido1.addProduto(p02);
        pedido2.addProduto(p01);
        pedido2.addProduto(p02);
        transaction = session.beginTransaction();
        session.persist(pedido1);
        session.persist(pedido2);
        transaction.commit();
        List<Pedido> pedidos = session.createQuery("from Pedido", Pedido.class).list(); // tenho uma lista das pessoas que tenho no meu banco de dados
        pessoas.forEach(p-> System.out.println(p));

    }
}
