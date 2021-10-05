package application.model;

import application.controller.BlogController;

import java.time.LocalDateTime;
import java.util.List;

public class Blog extends Members{

    private long idBlog;
    private long blogSerial;
    private String blogText;
    private LocalDateTime blogTime;

    private List<Comment> comments;

    BlogController blogController;
    BlogSablon blogSablon;

    public Blog() {
    }

    public Blog(BlogSablon blogSablon){
        this.blogSablon = blogSablon;
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
        if (blogController.isModification() == true){
            this.blogText = blogText;
        }
    }

    public String getBlogText() {
        return blogText;
    }

    public LocalDateTime getBlogTime() {
        return blogTime;
    }

    public List<Comment> getComments() {
        return comments;
    }
}


