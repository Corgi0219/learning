package reflect;

import singleton.Foo;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * @author Chengliming
 * @create 2020-12-11 4:42 下午
 **/
public class Test {
    public static void target(int i) {
        new Exception("#" + i).printStackTrace();
    }

    public static void main(String[] args) throws Exception {
        Class<?> clz = Class.forName("reflect.Test");
        Method method = clz.getMethod("target", int.class);
        for (int i = 0; i < 20; i++) {
            method.invoke(null, i);
        }
    }

    public static MethodHandles.Lookup lookup() {
        return MethodHandles.lookup();
    }
}

class Test1 {
    public static void main(String[] args) throws Throwable {
//        MethodHandle handle = MethodHandles.lookup().findStatic(Test.class, "target", MethodType.methodType(void.class, int.class));
//        handle.invoke(1);

        MethodHandles.Lookup lookup = Test.lookup();
        Method method = Test.class.getDeclaredMethod("target", int.class);
        MethodHandle handle = lookup.unreflect(method);
        handle.invokeExact(1);
    }
}
