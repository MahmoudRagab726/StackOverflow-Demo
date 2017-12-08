/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package user.dao;

import java.util.List;
import model.Answers;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Mahmoud Ragab
 */
public class AnswerDao implements IAnswerDAO{
    private SessionFactory sessionFactory;
    @Override
    public void addAnswer(Answers answer) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.save(answer);
        session.getTransaction().commit();
        session.close();
        
    }

    @Override
    public List<Answers> getAllAnswers(int id) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        List<Answers> list = session.createQuery("from Answers where Quesion_Id = "+id+" order by Answer_Date").list();
        return list;
    }
    
    
    public SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = new Configuration().configure().buildSessionFactory();

        }
        return sessionFactory;
    }
}
