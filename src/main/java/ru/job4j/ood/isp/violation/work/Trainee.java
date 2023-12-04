package ru.job4j.ood.isp.violation.work;

public class Trainee implements Employee {
    @Override
    public void work() {
        System.out.println("Do some work");
    }

    @Override
    public void takeVacation() {
        throw new UnsupportedOperationException("Trainees can't take vacations due to short-term employment");
    }
}
