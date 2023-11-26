package ru.job4j.ood.ocp.bestpracticeexamples.sender;

public class Notifier {
    /**
     * Данный класс не зависит от реализаций sender-ов и сможет рабботать с любой новой реализацией
     * без необходимости изменять код внутри себя.
     */
    private Sender sender;

    public Notifier(Sender sender) {
        this.sender = sender;
    }

    public void send(String message) {
        sender.sendMessage(message);
    }
}
