package simplegroupsapp;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import simplegroupsapp.dao.GroupDao;
import simplegroupsapp.daoimpl.DebugDaoImpl;
import simplegroupsapp.daoimpl.GroupDaoImpl;
import simplegroupsapp.database.mybatis.utils.MyBatisUtils;

public class TestBase {

    protected GroupDao groupDao = new GroupDaoImpl();
    protected DebugDaoImpl debugDao = new DebugDaoImpl();
    protected static boolean setUpIsDone = false;

    @BeforeAll()
    public static void setUp() {
        if (!setUpIsDone) {
            boolean initSqlSessionFactory = MyBatisUtils.initSqlSessionFactory();
            if (!initSqlSessionFactory) {
                throw new RuntimeException("Can't create connection, stop");
            }
            setUpIsDone = true;
        }
    }

    @BeforeEach()
    public void clearDatabase() {
        debugDao.deleteAllGroups();
    }



}
