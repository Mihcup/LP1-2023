import entity.Endereco;
import entity.Pedido;
import entity.Pessoa;
import entity.Produto;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.Arrays;
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
         gerenciarPedido();
    }
    public static void gerenciarPedido(){
        Session session = HibernateUtil.getSessionFactory().openSession();

        Endereco e1 = new Endereco("Rua das Palmeiras","São Paulo");
        Pessoa p1 = new Pessoa("Mih","Cupolillo", "millenacupolillo@aluno.ifsp",e1);
        Pedido ped = new Pedido(p1);

        Transaction transaction = session.beginTransaction();
        session.persist(ped);
        transaction.commit();
        List<Pedido> pedidos = session.createQuery("from Pedido", Pedido.class).list(); // tenho uma lista das pessoas que tenho no meu banco de dados
        pedidos.forEach(p-> System.out.println(p));

        Produto produto1 = new Produto("Blusa",50);
        Produto produto2 = new Produto("Calça",35);
        List<Produto> produtoList = new ArrayList<>();
        produtoList.add(produto1);
        produtoList.add(produto2);
        Pedido pedido = new Pedido(p1,new ArrayList<>(List.of(produto1,produto2)));

        transaction = session.beginTransaction();
        session.persist(pedido);
        transaction.commit();
        List<Pedido> pedidos2 = session.createQuery("from Pedido", Pedido.class).list(); // tenho uma lista das pessoas que tenho no meu banco de dados
        pedidos2.forEach(p2-> System.out.println(p2));

        pedidos.get(0).addProduto(produto1);
        pedidos.get(0).addProduto(produto1);
        transaction = session.beginTransaction();
        session.persist(pedidos.get(0));
        transaction.commit();
        List<Pedido> peds = session.createQuery("from Pedido", Pedido.class).list();
        pedidos.forEach(p2-> System.out.println(p2));

        pedidos2.get(1).addProduto(produto1);
        pedidos2.get(1).addProduto(produto1);
        transaction = session.beginTransaction();
        session.persist(pedidos2.get(1));
        transaction.commit();
        List<Pedido> peds2 = session.createQuery("from Pedido", Pedido.class).list();
        peds2.forEach(p2-> System.out.println(p2));
    }

}
