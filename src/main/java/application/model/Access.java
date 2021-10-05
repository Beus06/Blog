package application.model;

public enum Access {
    ADMIN,
    MODERATOR,
    USER,
    GUEST;


    public static Access find(String name) {
        for (Access access : Access.values()) {
            if (access.toString().equalsIgnoreCase(name)) {
                return access;
            }
        }
        return Access.GUEST;
    }
}
