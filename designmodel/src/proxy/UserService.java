package proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Chengliming
 * @create 2020-11-29 10:39 下午
 **/
public class UserService implements IUserService{
    @Override
    public void name() {
        System.out.println("张三");
    }

    @Override
    public void address() {
        System.out.println("北京市望京");
    }
}
