package main.com.java.dao.implementation;

import main.com.java.dao.interfaces.AuthoritiesDAO;
import main.com.java.entity.Authorities;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AuthoritiesDAOImpl implements AuthoritiesDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public AuthoritiesDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session createCurrentSession(SessionFactory sf){
        Session session = sf.getCurrentSession();
        return session;
    }

    @Override
    @Transactional
    public void addAuthorities(Authorities authorities) {
        try{
            Session currentSession = createCurrentSession(sessionFactory);
            currentSession.saveOrUpdate(authorities);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    @Transactional
    public void deleteAuthorities(Authorities authorities) {
        try{
            createCurrentSession(sessionFactory).remove(authorities);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
