package application.model;

import java.time.LocalDateTime;

public class Posts extends Members {

    private long idBlog;
    private String blogText;
    private String comment;
    private LocalDateTime blogTime;
    private LocalDateTime commentTime;

    public Posts() {
    }

    public long getIdBlog() {
        return idBlog;
    }

    public String getBlogText() {
        return blogText;
    }

    public String getComment() {
        return comment;
    }

    public LocalDateTime getBlogTime() {
        return blogTime;
    }

    public LocalDateTime getCommentTime() {
        return commentTime;
    }
}
