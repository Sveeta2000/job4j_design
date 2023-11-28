package ru.job4j.ood.lsp.violation.sounds;

public class Farm {
    /**
     * пример одного из признаков нарушения принципа подстановки Лисков -
     * необходимость использовать проверку типов или enum-ов внутри метода,
     * особенно когда количество типов не ограничено.
     * В данном примере на ферме живут 4 вида животных, но если на ферму будут приезжать другие животные,
     * то метод разговора и енам придется переписывать каждый раз, и метод станет очень большим и страшным.
     */
    public String talk(Animals animal) {
        if (animal == Animals.CAT) {
            return "meow";
        } else if (animal == Animals.DOG) {
            return "woof";
        } else if (animal == Animals.COW) {
            return "moo";
        } else {
            return "oink";
        }
    }
}
