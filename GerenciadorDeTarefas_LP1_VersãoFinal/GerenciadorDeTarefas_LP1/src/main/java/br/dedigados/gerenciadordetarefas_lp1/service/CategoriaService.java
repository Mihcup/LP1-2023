package br.dedigados.gerenciadordetarefas_lp1.service;

import br.dedigados.gerenciadordetarefas_lp1.model.Categoria;
import br.dedigados.gerenciadordetarefas_lp1.util.HibernateUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CategoriaService {
    private Session session = HibernateUtil.getSessionFactory().openSession();

    public void salvarCategoria(Categoria categoria){
        Transaction transaction = session.beginTransaction();
        session.persist(categoria);
        transaction.commit();
    }
    public List<Categoria> listaCategoria(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        TypedQuery<Categoria> query = session.createQuery("from Categoria ", Categoria.class);
        return query.getResultList();
    }

    public void deletarCategoria(Integer id) {
        Categoria categoria = session.get(Categoria.class, id);
        if (categoria != null) {
            // Exclui o objeto
            session.beginTransaction();
            session.remove(categoria);
            session.getTransaction().commit();
        }
    }
    public Categoria buscarCategoria(Integer id) {
        return session.get(Categoria.class, id);
    }
    public void editarCategoria(Categoria categoria){
        session.beginTransaction();
        session.merge(categoria);
        session.getTransaction().commit();
    }
}
