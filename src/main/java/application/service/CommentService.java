package application.service;

import application.model.Access;
import application.model.Comments;
import application.model.Members;

import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class CommentService {

    @PersistenceContext
    private EntityManager em;



    /**
     * tartalmaz egy-egy metódust, amely teljesíti az alábbi feladatokat (egy feladat - egy metódus):
     * visszaadja egy adott blogbejegyzéshez tartozó összes kommentet
     */



    @Transactional
    public List<Comments> getCommentByBlog(long idBlog) {
        return em.createQuery("SELECT comment FROM Comments comment WHERE comment.blog =:byId", Comments.class)
                .setParameter("byId", idBlog)
                .getResultList();
    }


}
