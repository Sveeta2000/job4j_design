package ru.job4j.ood.ocp.bestpracticeexamples.payment;

public class PayPalPayment implements PaymentStrategy {
    @Override
    public void pay() {
        System.out.println("Pay with PayPal");
    }
}
