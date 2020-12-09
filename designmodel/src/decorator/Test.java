package decorator;

/**
 * @author Chengliming
 * @create 2020-11-30 9:48 上午
 **/
public class Test {
    public static void main(String[] args) {
        D d = new D();
        B b = new B(d);
        C c = new C(b);
        System.out.println(b.read());
    }
}
