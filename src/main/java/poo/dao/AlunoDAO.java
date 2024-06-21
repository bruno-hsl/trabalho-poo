package poo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import poo.model.Aluno;

public class AlunoDAO {
    
    private static final SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration().configure();
            sessionFactory = configuration.buildSessionFactory();
        } catch (Exception e) {
            throw new ExceptionInInitializerError();
        }
    }

    public void close(){
        sessionFactory.close();
    }

    public void cadastrarAluno(Aluno aluno){
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            session.save(aluno);
            transaction.commit(); 
        } catch (Exception e) {
            if(transaction != null && transaction.isActive()){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Aluno getAlunoById(Long id){
        try (Session session = sessionFactory.openSession()){
            return session.get(Aluno.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void atualizarAluno(Aluno aluno){
        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            session.update(aluno);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deletarAluno(Aluno aluno){
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            session.delete(aluno);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null && transaction.isActive()){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void mostarAlunos(){
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            
            List<Aluno> alunos = session.createQuery("select a from Aluno a", Aluno.class).list();

            alunos.forEach(System.out::println);
            
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null && transaction.isActive()){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /* public List<Aluno> listarAlunos() {
        try (Session session = sessionFactory.openSession()) {
            Query<Aluno> query = session.createQuery("from Aluno", Aluno.class);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    } */


}
