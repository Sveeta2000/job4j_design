package ru.job4j.ood.lsp.violation.birds;

public class Ostrich extends Bird {
    /**
     * метод fly() в классе Ostrich изменяет поведение метода в родительском классе Bird,
     * что приводит к нарушению принципа подстановки.
     * Производные классы не должны генерировать исключения, не описанные базовым классом.
     * Способность летать должна быть выделена как отдельный интерфейс,
     * тк могут быть и другие способности, которые есть не у всех птиц - плавание, например.
     */
    @Override
    public void fly() {
        throw new UnsupportedOperationException("I can't fly");
    }
}
