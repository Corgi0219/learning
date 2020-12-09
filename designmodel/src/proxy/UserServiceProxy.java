package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Chengliming
 * @create 2020-11-29 10:39 下午
 **/
public class UserServiceProxy {
    private UserService userService;

    public UserServiceProxy(UserService userService) {
        this.userService = userService;
    }

    public UserServiceProxy() {

    }

    public Object createProxy(Object object) {
        Class<?>[] interfaces = object.getClass().getInterfaces();
        DynamicProxyHandler handler = new DynamicProxyHandler(object);
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), interfaces, handler);
    }

    private class DynamicProxyHandler implements InvocationHandler {

        private Object proxyObject;

        private DynamicProxyHandler(Object proxyObject) {
            this.proxyObject = proxyObject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("调用前");
            Object invoke = method.invoke(proxyObject, args);
            System.out.println("调用后");
            return invoke;
        }
    }
}
