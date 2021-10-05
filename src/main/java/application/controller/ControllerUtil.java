package application.controller;

import application.model.Access;
import application.model.Blog;
import application.model.Comment;
import application.model.Members;

public class ControllerUtil {

    Members members;
    Blog blog;
    Comment comment;

    private boolean isRead;
    private boolean isWrite = false;
    private boolean isModification = false;
    private boolean isDelete = false;


    public boolean isRead() {
        return isRead;
    }

    public boolean isWrite() {

        if (!(members.getAccess().equals(Access.GUEST)
                && (members.getBlogs().contains(blog.getBlogSerial())))) {
            isWrite = true;
        }
        return isWrite;
    }

    public boolean isModification() {

        if (!(members.getAccess().equals(Access.GUEST)
                && (members.getBlogs().contains(blog.getBlogSerial())))) {
            isModification = true;
        }
        return isModification;
    }

    public boolean isDelete() {

        if (!(members.getAccess().equals(Access.GUEST)
                && (members.getBlogs().contains(blog.getBlogSerial())))) {
            isDelete = true;
        }
        return isDelete;
    }
}