package application.controller;


import application.model.Blog;
import application.model.Members;

import java.util.ArrayList;
import java.util.List;

public class BlogController {
    /**
     * blogbejegyzések olvasása
     * nem kell hozzá jogosultság, sőt regisztráció sem
     * blogbejegyzések módosítása
     * admin, moderator; illetve a saját blogbejegyzéseit minden user módosíthatja
     * blogbejegyzések törlése
     * admin, moderator; illetve a saját blogbejegyzéseit minden user törölheti
     */

    private boolean read;
    private boolean write;
    private boolean modification = false;
    private boolean delete = false;

    Members members;
    Blog blog;
    ControllerUtil controllerUtil;

    public BlogController() {
    }

    /**
     * tartalmaz egy-egy metódust, amely teljesíti az alábbi feladatokat (egy feladat - egy metódus):
     * visszaadja egy adott felhasználó összes blogját (ok)
     * visszaadja egy adott blog összes blogbejegyzését (ok)
     * @return
     */

    public List<Blog> blogByMember (List<Blog> blogList, long idUser) {
        List <Blog> blogByUser = new ArrayList<>();

        for ( int i = 0; i < blogList.size(); i++) {
            if (blogList.get(i).getIdUser() == idUser) {
                blogByUser.add(blogList.get(i));
            }
        }
        return blogByUser;
    }

    public List<Blog> allBlog (List<Blog> blogList, long blogSerial){

        List<Blog> allBlog = new ArrayList<>();

        for ( int i = 0; i < blogList.size(); i++) {
            if (blogList.get(i).getBlogSerial() == blogSerial) {
                allBlog.add(blogList.get(i));
            }
        }

        return allBlog;
    }

    public boolean isRead() {
        read = controllerUtil.isRead();
        return read;
    }

    public boolean isWrite() {
        write = controllerUtil.isWrite();
        return write;
    }

    public boolean isModification() {
        modification = controllerUtil.isModification();
        return modification;
    }

    public boolean isDelete() {
        delete = controllerUtil.isDelete();
        return delete;
    }
}
