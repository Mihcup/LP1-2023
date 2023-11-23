package br.dedigados.gerenciadordetarefas_lp1.service;

import br.dedigados.gerenciadordetarefas_lp1.model.Usuario;
import br.dedigados.gerenciadordetarefas_lp1.util.HibernateUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UsuarioService {
    private Session session = HibernateUtil.getSessionFactory().openSession();

    public List<Usuario> listaUsuarios(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        TypedQuery<Usuario> query = session.createQuery("from Usuario ", Usuario.class);
        return query.getResultList();
    }

    public void salvarUsuario(Usuario usuario){
        Transaction transaction = session.beginTransaction();
        session.persist(usuario);
        transaction.commit();
    }

    public void editarUsuario(Usuario usuario){
        session.beginTransaction();
        session.merge(usuario);
        session.getTransaction().commit();
    }
}
