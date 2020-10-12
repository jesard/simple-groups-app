package simplegroupsapp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Group {

    private int id;
    private String number;
    private List<Student> students = new ArrayList<>();

    public Group(String number, List<Student> students) {
        this.number = number;
        this.students = students;
    }

    public Group(String number) {
        this(number, new ArrayList<>());
    }

    public Group() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Group)) return false;
        Group group = (Group) o;
        return getId() == group.getId() &&
                Objects.equals(getNumber(), group.getNumber()) &&
                Objects.equals(getStudents(), group.getStudents());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNumber(), getStudents());
    }
}
