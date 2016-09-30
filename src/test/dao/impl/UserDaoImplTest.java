package dao.impl;

import dao.IUserDao;
import org.junit.Test;
import proxy.JdkProxy;

import static org.junit.Assert.*;

/**
 * Created by lenovo on 2016/09/30.
 */
public class UserDaoImplTest {
    @Test
    public void add() throws Exception {
        IUserDao dao = new UserDaoImpl();
        JdkProxy proxy = new JdkProxy(dao);
        dao = proxy.createProxy();
        dao.add();
        dao.update();
    }

    @Test
    public void update() throws Exception {

    }

}