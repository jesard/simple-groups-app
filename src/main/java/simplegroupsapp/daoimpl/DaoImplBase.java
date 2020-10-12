package simplegroupsapp.daoimpl;

import simplegroupsapp.database.mybatis.mappers.GroupMapper;
import simplegroupsapp.database.mybatis.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

public class DaoImplBase {

    private static boolean setUpIsDone = false;

    public static void setUp() {
        if (!setUpIsDone) {
            boolean initSqlSessionFactory = MyBatisUtils.initSqlSessionFactory();
            if (!initSqlSessionFactory) {
                throw new RuntimeException("Can't create connection, stop");
            }
            setUpIsDone = true;
        }
    }

    protected SqlSession getSession() {
        setUp();
        return MyBatisUtils.getSqlSessionFactory().openSession();
    }

    protected GroupMapper getGroupMapper(SqlSession sqlSession) {
        return sqlSession.getMapper(GroupMapper.class);
    }

}


