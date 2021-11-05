package application.config;

import application.model.Access;
import application.model.Members;
import application.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MembersConfig implements ApplicationRunner {
    private MemberService memberService;

    @Autowired
    public MembersConfig (MemberService memberService) {
        this.memberService = memberService;
    }


    public void run(ApplicationArguments args) throws Exception {
        addMember();
    }

    private void addMember() {
        if (!(createMembers().isEmpty())) {
            List<Members> members = createMembers();

            for (Members members1 : members) {
                memberService.registerUsers();
            }
        }
    }


    private List<Members> createMembers() {
        List<Members> members = new ArrayList<>();

        members.add(new Members("Süsü", "aSarkany", Access.NON_ACCESS));
        members.add(new Members( "Diablo", "theBest", Access.ADMIN));
        members.add(new Members( "DiabloII", "againAndAgain", Access.USER));
        members.add(new Members("Süsüke", "aSarkanyka", Access.USER_OWN));
        members.add(new Members( "Isabell", "abcd", Access.USER_COMMENT));
        return members;
    }

}
