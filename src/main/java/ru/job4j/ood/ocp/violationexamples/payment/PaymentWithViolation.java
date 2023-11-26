package ru.job4j.ood.ocp.violationexamples.payment;

public class PaymentWithViolation {
    /**
     * Здесь нарушен принцип Open Close, поскольку дизайн класса оставляет его открытым для изменений:
     * Если нужно будет добавть новый тип платежа, метод processPayment необходимо будет изменить,
     * чтобы он обрабатывал новый тип платежа.
     * Класс не поддерживает расширение, для этого ничего не сделано.
     * Исправленный вариант находится в папке "best practice example.payment".
     * @param paymentType string representation of payment type
     */
    public void processPayment(String paymentType) {
        if ("credit card".equals(paymentType)) {
            System.out.println("Pay with a credit card.");
        } else if ("paypal".equals(paymentType)) {
            System.out.println("Pay with PayPal");
        }
    }
}
