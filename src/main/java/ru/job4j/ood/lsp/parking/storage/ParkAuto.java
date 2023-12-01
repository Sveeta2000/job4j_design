package ru.job4j.ood.lsp.parking.storage;

import ru.job4j.ood.lsp.parking.model.Auto;

public interface ParkAuto {
    boolean park(Auto auto);

    boolean leave(Auto auto);
}
