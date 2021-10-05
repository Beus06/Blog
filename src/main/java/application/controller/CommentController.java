package application.controller;

import application.model.Blog;
import application.model.Comment;
import application.model.Members;

import java.util.ArrayList;
import java.util.List;

public class CommentController {

    Blog blog;
    Members members;
    ControllerUtil controllerUtil;
    /**
     * kommentek írása
     * admin, moderator, user
     */
    private boolean writeComment = false;
    private boolean deleteComment = false;
    /**
     * tartalmaz egy-egy metódust, amely teljesíti az alábbi feladatokat (egy feladat - egy metódus):
     * visszaadja egy adott blogbejegyzéshez tartozó összes kommentet
     */

    public List<Comment> commentByBlog (List<Blog> blogList, List<Comment> comments, long idBlog) {

        List <Comment> commentByBlog = new ArrayList<>();

        for ( int i = 0; i < blogList.size(); i++) {
            if (blogList.get(i).getIdBlog() == idBlog) {
                commentByBlog = blogList.get(i).getComments();
            }
        }
        return commentByBlog;
    }


    public boolean isWriteComment() {
        writeComment = controllerUtil.isWrite();
        return writeComment;
    }

    public boolean isDeleteComment() {
        deleteComment = controllerUtil.isDelete();
        return deleteComment;
    }
}
