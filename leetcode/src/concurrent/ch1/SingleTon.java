package concurrent.ch1;

import java.util.Map;

class SingleTon {
    private static SingleTon singleTon;

    private SingleTon() {

    }

    public static SingleTon getInstance() {
        if (singleTon == null) {
            singleTon = new SingleTon();
        }
        return singleTon;
    }
}

class Test1 {
    public static void main(String[] args) {
        SingleTon ton1 = SingleTon.getInstance();
        SingleTon ton2 = SingleTon.getInstance();
        return;
    }

    public static <T> T mapToObject(Map<String, Object> map, Class<T> beanClass) {
        return null;
    }
}