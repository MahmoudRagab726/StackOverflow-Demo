package user.dao;

import java.util.List;
import model.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Mahmoud Ragab
 */
public class UserDao implements IUserDAO{
    private SessionFactory sessionFactory;
   
	public UserDao() {
             
	}

    public SessionFactory getSessionFactory() {
        if(sessionFactory==null){
            sessionFactory = new Configuration().configure().buildSessionFactory();
            
        }
        return sessionFactory;
    }



        
        @Override
	public void addUser(Users user) {
            //Session session=sessionFactory
            Session session= getSessionFactory().openSession();
		 session.beginTransaction();
                 session.save(user);
                session.getTransaction().commit();
                session.close();
	}

        @Override
	public Users getUserByEmail(String email) {
                Session session= getSessionFactory().openSession();
                session.beginTransaction();
                List<Users> list=session.createQuery("from Users where Email= '"+email+"'").list();
                
		
                        //session.createQuery("from Users where Email='"+email+"'").list();
                if(list.size()>0)
        		return list.get(0);
                else
                    return null;
	}

	
}
