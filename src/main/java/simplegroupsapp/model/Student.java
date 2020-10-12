package simplegroupsapp.model;

import java.time.LocalDate;
import java.util.Objects;

public class Student {

    private int id;
    private String name;
    private LocalDate date;

    public Student(int id, String name, LocalDate date){
        this.id = id;
        this.name = name;
        this.date = date;
    }

    public Student(String name) {
        this(0, name, LocalDate.now());
    }

    public Student() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return getId() == student.getId() &&
                Objects.equals(getName(), student.getName()) &&
                Objects.equals(getDate(), student.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDate());
    }
}
