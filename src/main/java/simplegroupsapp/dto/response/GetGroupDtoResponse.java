package simplegroupsapp.dto.response;

public class GetGroupDtoResponse {

    private int id;
    private String number;
    private int studentCount;

    public GetGroupDtoResponse(int id, String number, int studentCount) {
        this.id = id;
        this.number = number;
        this.studentCount = studentCount;
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

    public int getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }
}
