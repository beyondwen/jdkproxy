package proxy;

import dao.IUserDao;
import dao.impl.UserDaoImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by lenovo on 2016/09/30.
 */
public class JdkProxy implements InvocationHandler {

    private IUserDao dao;

    public JdkProxy(IUserDao dao) {
        this.dao = dao;
    }

    public IUserDao createProxy() {
        IUserDao dao1 = (IUserDao) Proxy.newProxyInstance(dao.getClass().getClassLoader(), dao.getClass().getInterfaces(), this);
        return dao1;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if ("add".equals(method.getName())) {
            System.out.println("日志记录");
           return method.invoke(dao, args);
        }
        return method.invoke(dao, args);
    }
}
