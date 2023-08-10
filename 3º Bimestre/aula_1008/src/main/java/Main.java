import entity.Pessoa;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa("Mih", "Cupolillo", "millenacupolillo@aluno.ifsp");
        Pessoa p2 = new Pessoa("Juan", "Oliveira", "juanjuan@gmail.com");
        Pessoa p3 = new Pessoa("Josi", "Agroboia","agroboiazo@gmail");
        Pessoa p4 = new Pessoa("Mariah", "PopePepe", "mariahpopepepe@gmail.com");

        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction(); // começo a transação -> inicio uma transacao (varias ações que eu posso realizar ) na minha sessao
        session.persist(p1);
        session.persist(p2);
        session.persist(p3);
        session.persist(p4);

        transaction.commit();
        List<Pessoa> pessoas = session.createQuery("from Pessoa", Pessoa.class).list(); // tenho uma lista das pessoas que tenho no meu banco de dados
        pessoas.forEach(p-> System.out.println(p)); // foreach diferente -> não precisa falar o tipo da variável p
    }
}
