package singleton;

class Sales {
    public double discountPrice(double price, Customer customer) {
        return price * 0.8d;
    }

    public final void free() {
        System.out.println("free");
    }
}