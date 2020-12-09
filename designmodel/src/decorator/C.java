package decorator;

/**
 * @author Chengliming
 * @create 2020-11-30 9:44 上午
 **/
public class C extends A {
    protected A a;

    protected C(A a) {
        this.a = a;
    }

    public int readC() {
        return 3;
    }
}
