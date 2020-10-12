package simplegroupsapp.dto.response;

import simplegroupsapp.model.Student;

import java.util.ArrayList;
import java.util.List;

public class GetSpecificGroupDtoResponse {

    private String number;
    private List<Student> students = new ArrayList<>();

    public GetSpecificGroupDtoResponse(String number, List<Student> students) {
        this.number = number;
        this.students = students;
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
}
