package simplegroupsapp.daoimpl;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DebugDaoImpl extends DaoImplBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(DebugDaoImpl.class);

    public void deleteAllGroups() {
        LOGGER.debug("DAO delete all Groups");
        try (SqlSession sqlSession = getSession()) {
            try {
                getGroupMapper(sqlSession).deleteAllGroups();
            } catch (RuntimeException ex) {
                LOGGER.info("Can't delete all Groups", ex);
                sqlSession.rollback();
                throw ex;
            }
            sqlSession.commit();
        }
    }

}
