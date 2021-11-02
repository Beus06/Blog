package application.model;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;


@Entity
public class Comments extends Blog{
    /**
     * CREATE TABLE IF NOT EXISTS comment (
     * id_comment INT UNSIGNED NOT NULL UNIQUE AUTO_INCREMENT,
     * comment_text VARCHAR(500),
     * comment_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
     * PRIMARY KEY(id_comment)
     * );
     */

    @Id
    private long idComment;
    private String commentText;

    @CreationTimestamp
    private LocalDateTime commentTime;


    public Comments() {
    }

    public Comments(long idComment, String commentText, LocalDateTime commentTime) {
        this.idComment = idComment;
        this.commentText = commentText;
        this.commentTime = commentTime;
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
}
