package application.service;

import application.model.Members;
import application.model.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
public class MemberService implements UserDetailsService {


    @PersistenceContext
    private EntityManager em;

    private PasswordEncoder encoder;

    @Autowired
    public MemberService(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @Transactional
    public List<Members> getAllUsers() {
        return em.createQuery("SELECT member FROM Members member", Members.class)
                .getResultList();
    }

    @Transactional
    public List<Members> loadUserByAccess(Members acces) throws Exception {
        return em.createQuery("SELECT member FROM Members member WHERE member.access = :type", Members.class)
                .setParameter("type", acces)
                .getResultList();
    }

    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return em.createQuery("SELECT member FROM Members member WHERE member.userName = :name", Members.class)
                .setParameter("name", userName)
                .getSingleResult();
    }

    @Transactional
    public Members getLoggedInUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null) {
            Object principal = auth.getPrincipal();
            if (principal instanceof Members) {
                return (Members) principal;
            }
        }
        return null;
    }

    @Transactional
    public Members getOneUser(String username) {
        try {
            return (Members) loadUserByUsername(username);
        } catch (Exception e) {
            return null;
        }
    }


    @Transactional
    public boolean registerUsers() {
        try {
            String userPw = encoder.encode("user");
            String userOwnPw = encoder.encode("own");
            String userCommentPw = encoder.encode("comment");
            String adminPw = encoder.encode("admin");

            Members user = new Members("user", userPw, Access.USER);
            Members own = new Members("own", userOwnPw, Access.USER_OWN);
            Members comment = new Members("comment",userCommentPw, Access.USER_COMMENT);
            Members admin = new Members("admin", adminPw, Access.ADMIN);

            em.persist(user);
            em.persist(own);
            em.persist(comment);
            em.persist(admin);

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
