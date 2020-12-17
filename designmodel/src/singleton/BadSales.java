package singleton;

import java.util.Random;

class BadSales extends Sales {
  @Override
  public double discountPrice(double price, Customer customer) {
    if (customer.isVIP()){
        return price * priceDiss();
    }else {
        return super.discountPrice(price, customer);
    }
  }

  public static double priceDiss() {
    return new Random().nextDouble() + 0.8d;
  }
}