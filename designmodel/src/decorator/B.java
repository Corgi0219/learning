package decorator;

/**
 * @author Chengliming
 * @create 2020-11-30 9:44 上午
 **/
public class B extends A {
    protected A a;

    protected B(A a) {
        this.a = a;
    }

    public int readB() {
        return 2;
    }
}
