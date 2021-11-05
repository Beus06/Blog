package application.model;

public enum Access {

    NON_ACCESS(UserAuth.READ),
    USER_OWN(UserAuth.READ,UserAuth.WRITE,UserAuth.MODIFICATION,UserAuth.DELETE),
    USER(UserAuth.READ, UserAuth.WRITE),
    USER_COMMENT(UserAuth.READ, UserAuth.WRITE),
    ADMIN(UserAuth.READ, UserAuth.WRITE, UserAuth.DELETE);

    public final UserAuth[] AUTHS;

    Access(UserAuth... auths) {
        AUTHS = auths;
    }

}
