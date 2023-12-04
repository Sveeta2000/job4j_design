package ru.job4j.ood.lsp.parking.storage;

import org.apache.commons.lang3.ArrayUtils;
import ru.job4j.ood.lsp.parking.model.Auto;

public class ParkingLot implements ParkAuto {
    /**
     * The field indicates the number of vacant spaces at the trucks[] array at the moment
     */
    private int freeTruckSpaces;

    /**
     * The field indicates the number of vacant spaces at the cars[] array at the moment
     */
    private int freeCarSpaces;

    /**
     * The field can store only Truck instances. Each Truck takes up exactly one place.
     * A Truck must be allocated to this field first if possible.
     * The size of the array is final and gets set at the ParkingLot instance creation.
     */
    private final Auto[] trucks;

    /**
     * The field can store both Car and Truck instances. Each Car takes up exactly one place.
     * Each Truck takes up a number of places equal to its size.
     * A Truck can be allocated to this field only if there's no space at its prioritized field - trucks,
     * and there's enough space to fit the Truck here.
     * The size of the array is final and gets set at the ParkingLot instance creation.
     */
    private final Auto[] cars;

    public ParkingLot(int truckSpacesCount, int carSpacesCount) {
        this.trucks = new Auto[truckSpacesCount];
        this.cars = new Auto[carSpacesCount];
        this.freeTruckSpaces = truckSpacesCount;
        this.freeCarSpaces = carSpacesCount;
    }

    /**
     * This method tries to allocate the auto to the most appropriate parking space.
     * @param auto - an auto to be parked.
     * @return true if the auto is successfully allocated to a parking space,
     * or false if there's no place that can fit this auto.
     */
    @Override
    public boolean park(Auto auto) {
        boolean isParked = false;
        int size = auto.getSize();
        if (size > 1 && freeTruckSpaces > 0) {
            isParked = parkToTruckParking(auto);
        } else if (size >= 1 && freeCarSpaces >= auto.getSize()) {
            isParked = parkToCarParking(auto);
        }
        return isParked;
    }

    private boolean parkToCarParking(Auto auto) {
        int index = findFreePlaceAtCarParking(auto);
        int size = auto.getSize();
        boolean isParked = false;
        if (index >= 0) {
            for (int i = 0; i < size; i++) {
                cars[index] = auto;
                index--;
                freeCarSpaces--;
            }
            isParked = true;
        }
        return isParked;
    }

    /**
     * This method finds the last index of the first continuous group of free spaces equal to the auto size.
     * @param auto - an auto to be placed.
     * @return last index of the first continuous group of free spaces equal to the auto size.
     */
    private int findFreePlaceAtCarParking(Auto auto) {
        int index = 0;
        int count = 0;
        for (int i = 0; i < cars.length; i++) {
            if (cars[i] == null) {
                count++;
                index = i;
            } else {
                count = 0;
                index = i + 1;
            }
            if (count == auto.getSize()) {
                break;
            }
        }
        return count == auto.getSize() ? index : -1;
    }

    private boolean parkToTruckParking(Auto auto) {
        int index = findFreePlaceAtTruckParking();
        boolean isParked = false;
        if (index >= 0) {
            trucks[index] = auto;
            freeTruckSpaces--;
            isParked = true;
        }
        return isParked;
    }

    private int findFreePlaceAtTruckParking() {
        int index = -1;
        for (int i = 0; i < trucks.length; i++) {
            if (trucks[i] == null) {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     *
     * @param auto - an auto to leave the parking lot.
     * @return true if the auto has successfully left the parking lot,
     * or false if the auto wasn't present at the parking lot.
     */
    @Override
    public boolean leave(Auto auto) {
        boolean hasLeft = false;
        int size = auto.getSize();
        if (size > 1 && ArrayUtils.contains(trucks, auto)) {
            hasLeft = leaveFromTruckPark(auto);
        } else if (size >= 1 && ArrayUtils.contains(cars, auto)) {
            hasLeft = leaveFromCarPark(auto);
        }
        return hasLeft;
    }

    private boolean leaveFromTruckPark(Auto auto) {
        int index = ArrayUtils.indexOf(trucks, auto);
        trucks[index] = null;
        freeTruckSpaces++;
        return true;
    }

    private boolean leaveFromCarPark(Auto auto) {
        int index = ArrayUtils.indexOf(cars, auto);
        for (int i = index; i < auto.getSize(); i++) {
            cars[i] = null;
            freeCarSpaces++;
        }
        return true;
    }

    public Auto[] getTrucks() {
        return trucks;
    }

    public Auto[] getCars() {
        return cars;
    }

    public int getFreeTruckSpaces() {
        return freeTruckSpaces;
    }

    public int getFreeCarSpaces() {
        return freeCarSpaces;
    }
}
