package ru.job4j.ood.lsp.violation.car;

public class ElectricCar extends Vehicle {
    /**
     * Метод заправки газом выбрасывает исключение,
     * в то время как метод в родительском классе Vehicle не делает этого,
     * что приводит к несогласованности поведения.
     * Производные классы не должны генерировать исключения, не описанные базовым классом.
     */
    @Override
    public void getGas() {
        throw new UnsupportedOperationException("I'm an electric car, I can't eat gas. I need electricity!");
    }
}
