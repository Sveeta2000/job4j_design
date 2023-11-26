package ru.job4j.ood.ocp.bestpracticeexamples.payment;

public class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay() {
        System.out.println("Pay with a credit card.");
    }
}
