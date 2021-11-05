package application.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
public class Comments{
    /**
     * CREATE TABLE IF NOT EXISTS comment (
     * id_comment INT UNSIGNED NOT NULL UNIQUE AUTO_INCREMENT,
     * comment_text VARCHAR(500),
     * comment_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
     * PRIMARY KEY(id_comment)
     * );
     */

    @Id
    @GeneratedValue
    private long idComment;
    private String commentText;

    @CreationTimestamp
    private LocalDateTime commentTime;
    private boolean isEnable;

    @ManyToOne
    private Members user;

    @ManyToOne
    private Blog blog;


    public Comments() {
    }


    public Comments(long idComment, String commentText, LocalDateTime commentTime, boolean isEnable) {
        this.idComment = idComment;
        this.commentText = commentText;
        this.commentTime = commentTime;
        this.isEnable = isEnable;
    }

    public long getIdComment() {
        return idComment;
    }

    public String getCommentText() {
        return commentText;
    }

    public LocalDateTime getCommentTime() {
        return commentTime;
    }

    public boolean isEnable() {
        return isEnable;
    }

    public Members getUser() {
        return user;
    }

    public Blog getBlog() {
        return blog;
    }
}
