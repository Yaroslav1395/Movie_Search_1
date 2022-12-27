import java.util.Objects;

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
        return  "Имя: " + fullName +
                " Роль: " + role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return fullName.equals(actor.fullName) && role.equals(actor.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, role);
    }
}
