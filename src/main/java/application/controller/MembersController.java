package application.controller;

import application.model.Members;
import application.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class MembersController {

    private MemberService service;

    @Autowired
    public MembersController(MemberService service) {
        this.service = service;
    }

    @GetMapping(value = {"/", "/home"})
    public String getHello() {
        return "hello";
    }


    @GetMapping("/user")
    public Members getLoggedInUser() {
        return service.getLoggedInUser();
    }

    @GetMapping("/allUser")
    public List<Members> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping(value = {"/myAccount/", "/myAccount/{username}"})
    public Members getOneUser(
            @PathVariable("username") String userName
    ) {
        if (userName != null) {
            return service.getOneUser(userName);
        }
        return null;
    }

    @GetMapping("/register")
    public String registerUser() {
        boolean registered = service.registerUsers();
        if (registered) {
            return "ok";
        }
        return "not ok";
    }
}