package ru.job4j.ood.lsp.parking.storage;

import ru.job4j.ood.lsp.parking.model.Auto;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot implements ParkAuto {
    private int truckSpacesCount;
    private int carSpacesCount;
    private int freeTruckSpaces;
    private int freeCarSpaces;
    private List<Auto> trucks;
    private List<Auto> cars;

    public ParkingLot(int truckSpacesCount, int carSpacesCount) {
        this.truckSpacesCount = truckSpacesCount;
        this.carSpacesCount = carSpacesCount;
        this.trucks = new ArrayList<>(truckSpacesCount);
        this.cars = new ArrayList<>(carSpacesCount);
        this.freeTruckSpaces = truckSpacesCount;
        this.freeCarSpaces = carSpacesCount;
    }

    @Override
    public boolean park(Auto auto) {
        return false;
    }

    @Override
    public boolean leave(Auto auto) {
        return false;
    }

    public int getTruckSpacesCount() {
        return truckSpacesCount;
    }

    public void setTruckSpacesCount(int truckSpacesCount) {
        this.truckSpacesCount = truckSpacesCount;
    }

    public int getCarSpacesCount() {
        return carSpacesCount;
    }

    public void setCarSpacesCount(int carSpacesCount) {
        this.carSpacesCount = carSpacesCount;
    }

    public List<Auto> getTrucks() {
        return trucks;
    }

    public List<Auto> getCars() {
        return cars;
    }

    public int getFreeTruckSpaces() {
        return freeTruckSpaces;
    }

    public void setFreeTruckSpaces(int freeTruckSpaces) {
        this.freeTruckSpaces = freeTruckSpaces;
    }

    public int getFreeCarSpaces() {
        return freeCarSpaces;
    }

    public void setFreeCarSpaces(int freeCarSpaces) {
        this.freeCarSpaces = freeCarSpaces;
    }
}
