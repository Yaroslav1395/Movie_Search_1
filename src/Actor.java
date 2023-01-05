public class Actor {
    private String fullName;
    private String role;

    public Actor() {
    }

    public Actor(String fullName, String role) {
        this.fullName = fullName;
        this.role = role;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Имя: " + fullName +
                " Роль: " + role;
    }
}
