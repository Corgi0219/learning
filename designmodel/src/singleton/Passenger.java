package singleton;

/**
 * @author Chengliming
 * @create 2020-12-10 1:52 下午
 **/
public abstract class Passenger {
    abstract void out();

    public static void main(String[] args) {
        Passenger cnPassenger = new CnPassenger();
        Passenger otherPassenger = new otherPassenger();
        long current = System.currentTimeMillis();

        for (int i = 0; i < 2_000_000_000; i++) {
            if (i % 100_000_000 == 0) {
                long millis = System.currentTimeMillis();
                System.out.println(millis - current);
                current = millis;
            }
            Passenger passenger = (i < 1_000_000_000) ? cnPassenger : otherPassenger;
            passenger.out();
        }
    }
}


