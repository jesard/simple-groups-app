package simplegroupsapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import simplegroupsapp.dao.GroupDao;
import simplegroupsapp.daoimpl.GroupDaoImpl;
import simplegroupsapp.dto.request.InsertGroupDtoRequest;
import simplegroupsapp.dto.request.InsertStudentDtoRequest;
import simplegroupsapp.dto.response.*;
import simplegroupsapp.error.ServerException;
import simplegroupsapp.model.Group;
import simplegroupsapp.model.Student;

import java.util.ArrayList;
import java.util.List;

public class GroupService {


    private static final Logger LOGGER = LoggerFactory.getLogger(GroupService.class);
    private GroupDao groupDao = new GroupDaoImpl();

    public List<GetGroupDtoResponse> getAllGroups() {
        LOGGER.debug("Service get all Groups");
        List<Group> groups = groupDao.getAllGroups();
        List<GetGroupDtoResponse> groupsResponse = new ArrayList<>();
        for (Group group:groups) {
            GetGroupDtoResponse getGroupDtoResponse = new GetGroupDtoResponse(group.getId(), group.getNumber(), group.getStudents().size());
            groupsResponse.add(getGroupDtoResponse);
        }
        return groupsResponse;
    }

    public GetSpecificGroupDtoResponse getGroup(int id) {
        LOGGER.debug("Service get Group with id {}", id);
        Group group = groupDao.getGroupById(id);
        return new GetSpecificGroupDtoResponse(group.getNumber(), group.getStudents());
    }

    public InsertGroupDtoResponse insertGroup(InsertGroupDtoRequest request) throws ServerException {
        LOGGER.debug("Service insert Group with number {}", request.getNumber());
        Group group = new Group(request.getNumber());
        groupDao.insertGroup(group);
        return new InsertGroupDtoResponse(group.getId(), group.getNumber());
    }

    public InsertStudentDtoResponse insertStudent(InsertStudentDtoRequest request, int groupId) {
        LOGGER.debug("Service insert Student with name {}", request.getName());
        Student student = new Student(request.getName());
        groupDao.insertStudent(student, groupId);
        return new InsertStudentDtoResponse(student.getId(), student.getName(), student.getDate());
    }

    public EmptyJsonResponse deleteStudent(int studentId) {
        LOGGER.debug("Service delete Student with id {}", studentId);
        groupDao.deleteStudent(studentId);
        return new EmptyJsonResponse();
    }
}
