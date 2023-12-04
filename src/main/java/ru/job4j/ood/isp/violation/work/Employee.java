package ru.job4j.ood.isp.violation.work;

/**
 * Принцип разделения интерфейсов нарушен, так как не все классы,
 * реализующие интерфейс Employee, могут иметь необходимость в отпуске.
 * Например, для стажера это неактуально.
 */
public interface Employee {
    void work();

    void takeVacation();
}
