package application.controller;

import application.model.Blog;
import application.model.Comments;
import application.model.Members;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentController {

    Blog blog;
    Members members;
    ControllerUtil controllerUtil;
    /**
     * kommentek írása
     * admin, moderator, user
     */
    //TODO

    /**
     * tartalmaz egy-egy metódust, amely teljesíti az alábbi feladatokat (egy feladat - egy metódus):
     * visszaadja egy adott blogbejegyzéshez tartozó összes kommentet
     */

    public List<Comments> commentByBlog (List<Blog> blogList, List<Comments> comments, long idBlog) {
        //TODO
        return null;
    }
}
