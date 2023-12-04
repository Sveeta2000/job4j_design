package ru.job4j.ood.isp.violation.animal;

/**
 * Принцип разделения интерфейсов нарушен, так как не все классы,
 * реализующие интерфейс Animal, могут выполнять операцию fly.
 * Например, для собаки это неактуально.
 */
public interface Animal {
    void eat();

    void sleep();

    void fly();
}
