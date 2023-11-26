package ru.job4j.ood.ocp.violationexamples.sender;

public class Notifier {
    /**
     * Класс завязан на не абстрактном поле, которое препятствует возможностям расширения функционала.
     * При необходимости добавить отправку писем, придется менять класс и придумывать костыли.
     * Исправленную реализацию см. в папке "best practice examples . sender"
     */
    private SmsSender sender;

    public Notifier(SmsSender smsSender) {
        this.sender = smsSender;
    }

    public void send(String message) {
        sender.sendSms(message);
    }
}
