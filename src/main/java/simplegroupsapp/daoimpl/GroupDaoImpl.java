package simplegroupsapp.daoimpl;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import org.apache.ibatis.binding.BindingException;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import simplegroupsapp.dao.GroupDao;
import simplegroupsapp.error.ServerErrorCode;
import simplegroupsapp.error.ServerException;
import simplegroupsapp.model.Group;
import simplegroupsapp.model.Student;

import java.util.List;

public class GroupDaoImpl extends DaoImplBase implements GroupDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(GroupDaoImpl.class);

    @Override
    public Group insertGroup(Group group) throws ServerException {
        LOGGER.debug("DAO insert Group {}", group);
        try (SqlSession sqlSession = getSession()) {
            try {
                getGroupMapper(sqlSession).insert(group);
            } catch (PersistenceException ex) {
                LOGGER.info("Can't insert Group {}: ex", group, ex);
                sqlSession.rollback();
                if (ex.getCause() instanceof MySQLIntegrityConstraintViolationException) {
                    throw new ServerException(ServerErrorCode.GROUP_DUPLICATE, group.getNumber());
                } else
                    throw ex;
            }
            sqlSession.commit();
        }
        return group;
    }

    @Override
    public Student insertStudent(Student student, int groupId) {
        LOGGER.debug("DAO insert Student {} into Group id {}", student, groupId);
        try (SqlSession sqlSession = getSession()) {
            try {
                getGroupMapper(sqlSession).insertStudent(groupId, student);
            } catch (RuntimeException ex) {
                sqlSession.rollback();
                LOGGER.info("Can't insert Student {} into Group id {}: ex", student, groupId, ex);
                throw ex;
            }
            sqlSession.commit();
        }
        return student;

    }

    @Override
    public void deleteStudent(int studentId) {
        LOGGER.debug("DAO delete Student with id {} ", studentId);
        try (SqlSession sqlSession = getSession()) {
            try {
                getGroupMapper(sqlSession).delete(studentId);
            } catch (PersistenceException ex) {
                LOGGER.info("Can't delete Student with id {}: {}", studentId, ex);
                sqlSession.rollback();
                throw ex;
            }
            sqlSession.commit();
        }
    }

    @Override
    public List<Group> getAllGroups() {
        LOGGER.debug("DAO get all Groups");
        try (SqlSession sqlSession = getSession()) {
            return getGroupMapper(sqlSession).getAllGroups();
        } catch (RuntimeException ex) {
            LOGGER.info("Can't get all Groups", ex);
            throw ex;
        }
    }

    @Override
    public Group getGroupById(int id) {
        LOGGER.debug("DAO get Group by id {}", id);
        try (SqlSession sqlSession = getSession()) {
            return getGroupMapper(sqlSession).getGroupById(id);
        } catch (RuntimeException ex) {
            LOGGER.info("Can't et Group by id {} - {}", id, ex);
            throw ex;
        }
    }

}
