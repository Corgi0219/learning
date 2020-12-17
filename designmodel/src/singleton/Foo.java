package singleton;

/**
 * @author Chengliming
 * @create 2020-12-11 2:21 下午
 **/
public class Foo implements AutoCloseable {
    private final String name;

    public Foo(String name) {
        this.name = name;
    }

    @Override
    public void close() {
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        try (Foo f1 = new Foo("foo1");
             Foo f2 = new Foo("foo2")) {
            throw new RuntimeException("initial");
        }
    }
}
