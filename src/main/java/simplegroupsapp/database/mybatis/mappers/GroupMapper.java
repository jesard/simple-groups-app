package simplegroupsapp.database.mybatis.mappers;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import simplegroupsapp.model.Group;
import simplegroupsapp.model.Student;

import java.util.List;

public interface GroupMapper {

    @Insert("INSERT INTO groups (number) VALUES (#{number})")
    @Options(useGeneratedKeys = true)
    public void insert(Group group);

    @Insert("INSERT INTO student (name, date, group_id) VALUES (#{student.name}, #{student.date}, #{groupId})")
    @Options(useGeneratedKeys = true, keyProperty = "student.id" )
    public void insertStudent(@Param("groupId") int groupId, @Param("student") Student student);

    @Delete("DELETE FROM groups")
    void deleteAllGroups();

    @Delete("DELETE FROM student WHERE id = #{studentId}")
    void delete(int studentId);

    @Select("SELECT id, number FROM groups ORDER BY id")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "students", column = "id", javaType = List.class,
            many = @Many(select = "simplegroupsapp.database.mybatis.mappers.GroupMapper.getStudentsByGroupId", fetchType = FetchType.LAZY))
    })
    List<Group> getAllGroups();

    @Select("SELECT id, number FROM groups WHERE id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "students", column = "id", javaType = List.class,
                    many = @Many(select = "simplegroupsapp.database.mybatis.mappers.GroupMapper.getStudentsByGroupId", fetchType = FetchType.LAZY))
    })
    Group getGroupById(int id);

    @Select("SELECT id, name, date FROM student WHERE group_id = #{id} ORDER BY name")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "date", column = "date")
    })
    List<Student> getStudentsByGroupId(int id);
}
