package application.controller;


import application.model.Blog;
import application.model.Members;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BlogController {

    Members members;
    Blog blog;
    ControllerUtil controllerUtil;

    public BlogController(Members members, Blog blog, ControllerUtil controllerUtil ) {
        this.members = members;
        this.blog = blog;
        this.controllerUtil = controllerUtil;
    }

    /**
     * tartalmaz egy-egy metódust, amely teljesíti az alábbi feladatokat (egy feladat - egy metódus):
     * visszaadja egy adott felhasználó összes blogját (ok)
     * visszaadja egy adott blog összes blogbejegyzését (ok)
     * @return
     */

    public List<Blog> blogByMember (List<Blog> blogList, long idUser) {
       //TODO
        return null;
    }

    public List<Blog> allBlog (List<Blog> blogList, long blogSerial){
        //TODO
        return null;
    }


}
