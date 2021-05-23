package com.example.fourart.repository;

import com.example.fourart.entity.Member;
import org.springframework.security.oauth2.client.web.AuthorizationRequestRepository;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Repository
public class SocialLoginRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Member member){em.persist(member);}



    public List<Member> findByEmail(String email){
        return em.createQuery("select m from Member m where m.email = :email",Member.class)
                .setParameter("email",email)
                .getResultList();
    }
}
