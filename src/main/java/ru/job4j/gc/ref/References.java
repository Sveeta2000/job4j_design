package ru.job4j.gc.ref;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class References {
    private static void safeSoft() {
        SoftReference<StringBuilder> reference = new SoftReference<>(new StringBuilder("Lots Of Cache"));
        StringBuilder strong = reference.get();
        if (strong != null) {
            System.out.println(strong);
        } else {
            System.out.println("Cache has been deleted");
        }
    }

    private static void safeWeak() {
        WeakReference<String> reference = new WeakReference<>("User's Response");
        String strong = reference.get();
        if (strong != null) {
            System.out.println(strong);
        } else {
            System.out.println("Response history has been cleared");
        }
    }
}
