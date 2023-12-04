package ru.job4j.ood.isp.violation.vehicle;

/**
 * Принцип разделения интерфейсов нарушен,
 * так как не все транспортные средства имеют двигатель или нуждаются в заправке.
 * Например, для велосипеда это неактуально.
 */
public interface Vehicle {
    void speedUp();

    void slowDown();

    void refuel();
}
