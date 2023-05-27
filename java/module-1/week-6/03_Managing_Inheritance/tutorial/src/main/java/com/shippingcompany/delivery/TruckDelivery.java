package com.shippingcompany.delivery;

public class TruckDelivery extends Delivery{

    public static final double TRUCK_TOP_SPEED = 60.0;

    public int getDuration() {
        double decimalHours = (double) super.getDistance() / TRUCK_TOP_SPEED;
        return convertHoursToMinutes(decimalHours);
    }
}
