package application.service;

import application.model.Blog;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class BlogService {

    /**
     * tartalmaz egy-egy metódust, amely teljesíti az alábbi feladatokat (egy feladat - egy metódus):
     * visszaadja egy adott felhasználó összes blogját
     * visszaadja egy adott blog összes blogbejegyzését
     */


    @PersistenceContext
    private EntityManager em;


    public BlogService(EntityManager em) {
        this.em = em;
    }

    @Transactional
    public List<Blog> getBlogByMember(String userName) {
        return em.createQuery("SELECT blog FROM Blog blog WHERE blog.owners =:user", Blog.class)
                .setParameter("user", userName)
                .getResultList();
    }

    @Transactional
    public List<Blog> getBlogById(long idBlog) {
        return em.createQuery("SELECT blog FROM Blog blog WHERE blog.idBlog =:byBlogId", Blog.class)
                .setParameter("byBlogId", idBlog)
                .getResultList();
    }


}
