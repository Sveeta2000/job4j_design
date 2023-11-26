package ru.job4j.ood.ocp.bestpracticeexamples.sender;

public class SmsSender implements Sender {
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending an SMS: " + message);
    }
}
