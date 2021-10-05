package application.model;

import java.time.LocalDateTime;

public class Comment extends Blog{
    /**
     * CREATE TABLE IF NOT EXISTS comment (
     * id_comment INT UNSIGNED NOT NULL UNIQUE AUTO_INCREMENT,
     * comment_text VARCHAR(500),
     * comment_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
     * PRIMARY KEY(id_comment)
     * );
     */

    private long idComment;
    private String commentText;
    private LocalDateTime commentTime;


    public Comment(long idComment, String commentText, LocalDateTime commentTime) {
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
