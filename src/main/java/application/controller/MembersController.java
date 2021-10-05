package application.controller;

import application.model.Access;
import application.model.Members;
import application.service.DBEngine;

import java.util.ArrayList;
import java.util.List;

public class MembersController {

    DBEngine dbEngine;

    /**
     * felhasználók adatainak olvasása
     * csak admin, illetve a saját felhasználói adataihoz minden user hozzáfér
     * felhasználók adatainak módosítása
     * csak admin, illetve a saját felhasználói adatait minden user módosíthatja
     */

    private boolean readUser;
    private boolean modificationUser;
    private boolean deleteUser;

    ControllerUtil controllerUtil;

    public MembersController() {
    }

    /**
     * tartalmaz egy-egy metódust, amely teljesíti az alábbi feladatokat (egy feladat - egy metódus):
     * visszaadja adott szerepkörű felhasználók összes adatát (ok)
     * visszaadja egy adott felhasználó összes adatát (ok)
     * @return
     */

    public List<Members> memberByType (List<Members> membersList, Access access) {

        List <Members> memberByType = new ArrayList<>();

        for ( int i = 0; i < membersList.size(); i++) {
            if (membersList.get(i).getAccess().equals(access)) {
                memberByType.add(membersList.get(i));
            }
        }
        return memberByType;
    }


    public List<Members> allDataForMember(List<Members> membersList, long idUser) {

        List <Members> oneMember = new ArrayList<>();

        for ( int i = 0; i < membersList.size(); i++) {
            if (membersList.get(i).getIdUser() == idUser) {
                oneMember.add(membersList.get(i));
                return oneMember;
            }
        }
        return null;
    }

    public boolean isReadUser() {
        readUser = controllerUtil.isRead();
        return readUser;
    }

    public boolean isModificationUser() {
        modificationUser = controllerUtil.isModification();
        return modificationUser;
    }

    public boolean isDeleteUser() {
        deleteUser = controllerUtil.isDelete();
        return deleteUser;
    }
}
