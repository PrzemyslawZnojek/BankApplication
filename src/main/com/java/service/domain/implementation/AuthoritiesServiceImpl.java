package main.com.java.service.domain.implementation;

import main.com.java.dao.interfaces.AuthoritiesDAO;
import main.com.java.entity.Authorities;
import main.com.java.service.domain.interfaces.AuthoritiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthoritiesServiceImpl implements AuthoritiesService {

    private final AuthoritiesDAO authoritiesDAO;

    @Autowired
    public AuthoritiesServiceImpl(AuthoritiesDAO authoritiesDAO) {
        this.authoritiesDAO = authoritiesDAO;
    }

    @Override
    @Transactional
    public void addAuthorities(Authorities authorities) {
        authoritiesDAO.addAuthorities(authorities);
    }

    @Override
    public void deleteAuthorities(Authorities authorities) {
        authoritiesDAO.deleteAuthorities(authorities);
    }
}
