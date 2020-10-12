package simplegroupsapp.dao;

import simplegroupsapp.error.ServerException;
import simplegroupsapp.model.Group;
import simplegroupsapp.model.Student;

import java.util.List;

public interface GroupDao {

    Group insertGroup(Group group) throws ServerException;

    Student insertStudent(Student student, int groupId);

    void deleteStudent(int studentId);

    List<Group> getAllGroups();

    Group getGroupById(int id);

}
