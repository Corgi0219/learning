package proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Chengliming
 * @create 2020-11-29 11:09 下午
 **/
public class ProxyTest {
    public static void main(String[] args) {
        UserServiceProxy serviceProxy = new UserServiceProxy();
        IUserService iUserService = (IUserService) serviceProxy.createProxy(new UserService());
        iUserService.name();
        iUserService.address();

        UserService service = new UserService();
        Method[] methods = service.getClass().getDeclaredMethods();
        for (Method method : methods) {
            try {
                method.invoke(service);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return;
    }
}
