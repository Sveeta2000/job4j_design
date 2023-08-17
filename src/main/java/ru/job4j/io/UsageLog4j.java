package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Svetlana";
        byte age = 23;
        short height = 163;
        int salary = 1000000;
        long phone = 89451234567L;
        float weight = 50.1f;
        double index = 19.2d;
        char lastNameLetter = 'K';
        boolean female = true;
        LOG.debug("User info name : {}, last name letter : {}, age : {}, height : {}, weight : {}, weight index : {}, female : {}, phone : {}, salary : ${}",
                name, lastNameLetter, age, height, weight, index, female, phone, salary);
    }
}
