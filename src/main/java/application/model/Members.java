package application.model;

import java.time.LocalDateTime;

public class Members {

    private long idUser;
    private String userName;
    private String firstName;
    private String lastName;
    private String emilAddress;
    private String password;
    private LocalDateTime registryTime;
    private Access access;


    public Members() {
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

    public String getEmilAddress() {
        return emilAddress;
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
}
