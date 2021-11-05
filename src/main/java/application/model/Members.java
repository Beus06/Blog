package application.model;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Members  implements UserDetails {

    @Id
    @GeneratedValue
    private long idUser;

    private String firstName;
    private String lastName;
    private String emailAddress;
    private String userName;
    private String password;

    @CreationTimestamp
    private LocalDateTime registryTime;

    @Enumerated(EnumType.STRING)
    private Access access;
    private boolean isLocked;

   // private List<Blog> blogs;

    public Members() {
    }

    public Members(String userName, String password, Access access) {
        this.userName = userName;
        this.password = password;
        this.access = access;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRegistryTime(LocalDateTime registryTime) {
        this.registryTime = registryTime;
    }

    public void setAccess(Access access) {
        this.access = access;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public long getIdUser() {
        return idUser;
    }

    public String getUserName() {
        return userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> list = new ArrayList<>();

        for (UserAuth auth : access.AUTHS) {
            list.add(new SimpleGrantedAuthority(auth.toString()));
        }
        return list;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return !isLocked;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !isLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !isLocked;
    }

    @Override
    public boolean isEnabled() {
        return !isLocked;
    }

    public LocalDateTime getRegistryTime() {
        return registryTime;
    }

    public Access getAccess() {
        return access;
    }


    public String toString() {
        return idUser + " - " +
                userName + ", " +
                access;
    }
}
