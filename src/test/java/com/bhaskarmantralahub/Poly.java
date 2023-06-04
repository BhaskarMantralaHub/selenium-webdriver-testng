package com.bhaskarmantralahub;

public class Poly {

    public static void main(String[] args) {
        Car car;

        if (args[0].equals("BMW")) {
            car = new BMW();
        } else {
            car = new Hyundai();
        }

        car.drivingSpeed();
    }

}

class BMW implements Car {

    @Override
    public void drivingSpeed() {
        System.out.println("60 m/h in 2 sec");
    }
}

class Hyundai implements Car {

    @Override
    public void drivingSpeed() {
        System.out.println("60 m/h in 10 sec");
    }
}

interface Car {
    void drivingSpeed();
}
