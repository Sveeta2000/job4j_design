package ru.job4j.ood.ocp.bestpracticeexamples.sender;

public class EmailSender implements Sender {
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending an e-mail: " + message);
    }
}
