package singleton;

/**
 * @author Chengliming
 * @create 2020-12-09 2:54 下午
 **/
public class Singleton {
    private Singleton() {
    }

    private static class LazyHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return LazyHolder.INSTANCE;
    }
}

class Test {
    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        return;
    }
}
