/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.dao;

import java.util.List;
import model.Questions;
import model.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Mahmoud Ragab
 */
public class QuestionDao implements IQuestionDAO {

    private SessionFactory sessionFactory;

    @Override
    public void addQuestion(Questions question) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.save(question);
        session.getTransaction().commit();

        session.close();

    }

    @Override
    public List<Questions> getAllQuestions() {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        List<Questions> list = session.createQuery("from Questions order by Question_Date DESC").list();
        return list;
    }

    @Override
    public List<Questions> getQuestionsByEmail(String email) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        List<Questions> list = session.createQuery("from Questions where User_Email='" + email + "' order by Question_Date DESC").list();
        return list;
    }

    @Override
    public void updateQuestion(Questions question) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.createQuery("update Questions set Title='"+question.getTitle().trim()+"', Question ='"+question.getQuestion().trim()+"' where id="+question.getId()+"").executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteQuestion(int id) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.createQuery("delete from Questions where id=" + id + "").executeUpdate();
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public List<Questions> getOneQuestion(int id) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        return session.createQuery("from Questions where Id=" + id+"").list();
        
    }
    

    public SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = new Configuration().configure().buildSessionFactory();

        }
        return sessionFactory;
    }

}
