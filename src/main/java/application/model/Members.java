package application.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Members {

    @Id
    private long idUser;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String userName;
    private String password;
    private LocalDateTime registryTime;
    private Access access;

    private List<Blog> blogs;

    public Members() {
    }

    public Members(
            long idUser,
            String firstName,
            String lastName,
            String emailAdress,
            String userName,
            String password,
            LocalDateTime registryTime,
            Access access)
    {
        this.idUser = idUser;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAdress;
        this.userName = userName;
        this.password = password;
        this.registryTime = registryTime;
        this.access = access;
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

    public String getPassword() {
        return password;
    }

    public LocalDateTime getRegistryTime() {
        return registryTime;
    }

    public Access getAccess() {
        return access;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public String toString() {
        return idUser + " - " +
                userName + ", " +
                access;
    }
}
