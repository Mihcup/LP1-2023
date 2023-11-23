package br.dedigados.gerenciadordetarefas_lp1.service;

import br.dedigados.gerenciadordetarefas_lp1.model.Tarefa;
import br.dedigados.gerenciadordetarefas_lp1.util.HibernateUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class TarefaService {
    private Session session = HibernateUtil.getSessionFactory().openSession();

    public void salvarTarefa(Tarefa tarefa){
        Transaction transaction = session.beginTransaction();
        session.persist(tarefa);
        transaction.commit();
    }

    public List<Tarefa> listaTarefas(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        TypedQuery<Tarefa> query = session.createQuery("from Tarefa ", Tarefa.class);
        return query.getResultList();
    }

    public Tarefa buscarTarefa(Integer id) {
        return session.get(Tarefa.class, id);
    }

    public void deletarTarefa(Integer id) {
        Tarefa tarefa = session.get(Tarefa.class, id);
        if (tarefa != null) {
            // Exclui o objeto
            session.beginTransaction();
            session.remove(tarefa);
            session.getTransaction().commit();
        }
    }

    public void editarTarefa(Tarefa tarefa){
        session.beginTransaction();
        session.merge(tarefa);
        session.getTransaction().commit();
    }
}
