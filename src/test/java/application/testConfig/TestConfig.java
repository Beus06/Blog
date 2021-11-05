package application.testConfig;

import application.model.Access;
import application.model.Members;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.Arrays;

@TestConfiguration
public class TestConfig {

    @Bean
    @Primary
    public UserDetailsService userDetailsService() {
        Members userOwn = createUser("akármi", "userOwn", Access.USER_OWN);
        Members admin = createUser("bármi", "admin", Access.ADMIN);
        Members userComment = createUser("valami", "userComment", Access.USER_COMMENT);
        Members userNon = createUser("semmi", "semmi", Access.NON_ACCESS);
        return new InMemoryUserDetailsManager(Arrays.asList(userOwn, admin, userComment, userNon));

    }

    private Members createUser(String userName, String password, Access access) {
       Members member = new Members();
       member.setUserName(userName);
       member.setPassword(password);
       member.setAccess(access);

        return member;
    }
}
