package application.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Blog {


    @Id
    @GeneratedValue
    private long idBlog;
    private long blogSerial;
    private String blogText;

    @CreationTimestamp
    private LocalDateTime blogTime;

    @ManyToOne
    private Members owners;


    //private List<Comments> commentsList;

    public Blog() {
    }


    public Blog(long idBlog, long blogSerial, String blogText, LocalDateTime blogTime) {
        this.idBlog = idBlog;
        this.blogSerial = blogSerial;
        this.blogText = blogText;
        this.blogTime = blogTime;

    }

    public long getIdBlog() {
        return idBlog;
    }

    public long getBlogSerial() {
        return blogSerial;
    }

    public void setBlogText(String blogText) {
            this.blogText = blogText;
        }

    public String getBlogText() {
        return blogText;
    }

    public LocalDateTime getBlogTime() {
        return blogTime;
    }

    public Members getOwners() {
        return owners;
    }

}


