package simplegroupsapp;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import simplegroupsapp.error.ServerException;
import simplegroupsapp.model.Group;
import simplegroupsapp.model.Student;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Disabled("Database required")
public class TestDao extends TestBase {


    @Test
    public void testGroupInsertGet() throws ServerException {
        Group group = new Group("2020-10");
        groupDao.insertGroup(group);
        assertNotEquals(0, group.getId());
        Group groupFromDb = groupDao.getGroupById(group.getId());
        assertEquals("2020-10", groupFromDb.getNumber());
    }


    @Test
    public void testAllGroupsGet() throws ServerException {
        Group group1 = new Group("2020-11");
        Group group2 = new Group("2020-12");
        groupDao.insertGroup(group1);
        groupDao.insertGroup(group2);
        List<Group> groups = new ArrayList<>();
        groups.add(group1);
        groups.add(group2);
        List<Group> groupsFromDb = groupDao.getAllGroups();
        assertEquals(groups, groupsFromDb);
    }


    @Test
    public void testStudentInsert() throws ServerException {
        Group group = new Group("2021-01");
        Student student = new Student("Иванов Иван Иванович");
        groupDao.insertGroup(group);
        groupDao.insertStudent(student, group.getId());
        Group groupFromDb = groupDao.getGroupById(group.getId());
        assertEquals("Иванов Иван Иванович", groupFromDb.getStudents().get(0).getName());
    }


    @Test
    public void testStudentDelete() throws ServerException {
        Group group = new Group("2022-02");
        Student student = new Student("Иванов Иван Иванович");
        groupDao.insertGroup(group);
        groupDao.insertStudent(student, group.getId());
        groupDao.deleteStudent(student.getId());
        Group groupFromDb = groupDao.getGroupById(group.getId());
        assertEquals(0, groupFromDb.getStudents().size());
    }

}
