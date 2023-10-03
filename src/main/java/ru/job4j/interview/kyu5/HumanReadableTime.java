package ru.job4j.interview.kyu5;

public class HumanReadableTime {
    public static String makeReadable(int seconds) {
        int hours = seconds / 3600;
        seconds = seconds - (hours * 3600);
        int minutes = seconds / 60;
        seconds = seconds - (minutes * 60);
        return (hours < 10 ? "0" + hours : hours) + ":"
                + (minutes < 10 ? "0" + minutes : minutes) + ":"
                + (seconds < 10 ? "0" + seconds : seconds);
    }
}
