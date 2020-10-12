package simplegroupsapp.endpoint;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import simplegroupsapp.dto.request.InsertGroupDtoRequest;
import simplegroupsapp.dto.request.InsertStudentDtoRequest;
import simplegroupsapp.dto.response.*;
import simplegroupsapp.error.ServerException;
import simplegroupsapp.service.GroupService;

import java.util.List;

@RestController
@RequestMapping(value = "/groups")
public class Groups {

    private GroupService groupService = new GroupService();

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<GetGroupDtoResponse> getAllGroups() {
        return groupService.getAllGroups();
    }


    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public GetSpecificGroupDtoResponse getGroup(@PathVariable("id") int id) {
        return groupService.getGroup(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public InsertGroupDtoResponse insertGroup(@RequestBody InsertGroupDtoRequest request) throws ServerException {
        return groupService.insertGroup(request);
    }

    @PostMapping(value = "/{id}/students", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public InsertStudentDtoResponse insertStudent(@RequestBody InsertStudentDtoRequest request,
                                                  @PathVariable("id") int id) {
        return groupService.insertStudent(request, id);
    }

    @DeleteMapping(value = "/{groupId}/students/{studentId}")
    public EmptyJsonResponse deleteStudent(@PathVariable("studentId") int studentId) {
        return groupService.deleteStudent(studentId);
    }

}
