package ru.job4j.ood.lsp.parking.storage;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.parking.model.Auto;
import ru.job4j.ood.lsp.parking.model.Car;
import ru.job4j.ood.lsp.parking.model.Truck;

import static org.assertj.core.api.Assertions.*;

@Disabled
class ParkingLotTest {

    @Test
    void whenParkACarThenTrue() {
        Auto car = new Car("ms123k");
        ParkingLot parkingLot = new ParkingLot(0, 1);
        assertThat(parkingLot.park(car)).isTrue();
        assertThat(parkingLot.getCars()).contains(car);
        assertThat(parkingLot.getFreeCarSpaces()).isEqualTo(0);
    }

    @Test
    void whenParkACarThenFalse() {
        Auto car = new Car("ms123k");
        ParkingLot parkingLot = new ParkingLot(2, 0);
        assertThat(parkingLot.park(car)).isFalse();
        assertThat(parkingLot.getTrucks()).doesNotContain(car);
        assertThat(parkingLot.getFreeTruckSpaces()).isEqualTo(2);
    }

    @Test
    void whenParkSecondCarThenTrue() {
        Auto car = new Car("ms123k");
        Auto car2 = new Car("ms456k");
        ParkingLot parkingLot = new ParkingLot(2, 2);
        assertThat(parkingLot.park(car)).isTrue();
        assertThat(parkingLot.getCars()).contains(car);
        assertThat(parkingLot.getFreeCarSpaces()).isEqualTo(1);
        assertThat(parkingLot.park(car2)).isTrue();
        assertThat(parkingLot.getCars()).contains(car2);
        assertThat(parkingLot.getFreeCarSpaces()).isEqualTo(0);
    }

    @Test
    void whenParkATruckOnTruckSpaceThenTrue() {
        Auto truck = new Truck(2, "ms123k");
        ParkingLot parkingLot = new ParkingLot(1, 2);
        assertThat(parkingLot.park(truck)).isTrue();
        assertThat(parkingLot.getTrucks()).contains(truck);
        assertThat(parkingLot.getFreeTruckSpaces()).isEqualTo(0);
        assertThat(parkingLot.getFreeCarSpaces()).isEqualTo(2);
    }

    @Test
    void whenParkATruckOnCarSpacesThenTrue() {
        Auto truck = new Truck(2, "ms123k");
        ParkingLot parkingLot = new ParkingLot(0, 2);
        assertThat(parkingLot.park(truck)).isTrue();
        assertThat(parkingLot.getCars()).contains(truck);
        assertThat(parkingLot.getFreeCarSpaces()).isEqualTo(0);
    }

    @Test
    void whenParkTwoTrucksOnCarAndTruckSpacesThenTrue() {
        Auto truck = new Truck(2, "ms123k");
        Auto truck2 = new Truck(2, "ms456k");
        ParkingLot parkingLot = new ParkingLot(1, 2);
        assertThat(parkingLot.park(truck)).isTrue();
        assertThat(parkingLot.getTrucks()).contains(truck);
        assertThat(parkingLot.getFreeTruckSpaces()).isEqualTo(0);
        assertThat(parkingLot.park(truck2)).isTrue();
        assertThat(parkingLot.getCars()).contains(truck2);
        assertThat(parkingLot.getFreeCarSpaces()).isEqualTo(0);
    }

    @Test
    void whenParkATruckOnCarSpacesThenFalse() {
        Auto truck = new Truck(2, "ms123k");
        Auto car = new Car("ms456k");
        ParkingLot parkingLot = new ParkingLot(0, 2);
        assertThat(parkingLot.park(car)).isTrue();
        assertThat(parkingLot.park(truck)).isFalse();
        assertThat(parkingLot.getCars()).doesNotContain(truck);
        assertThat(parkingLot.getFreeCarSpaces()).isEqualTo(1);
    }

    @Test
    void whenACarLeavesThenTrueAndMoreFreeSpaces() {
        Auto car = new Car("ms123k");
        Auto car2 = new Car("ms456k");
        ParkingLot parkingLot = new ParkingLot(0, 1);
        assertThat(parkingLot.park(car)).isTrue();
        assertThat(parkingLot.getCars()).contains(car);
        assertThat(parkingLot.getFreeCarSpaces()).isEqualTo(0);
        assertThat(parkingLot.leave(car)).isTrue();
        assertThat(parkingLot.getCars()).doesNotContain(car);
        assertThat(parkingLot.getFreeCarSpaces()).isEqualTo(1);
        assertThat(parkingLot.park(car2)).isTrue();
    }

    @Test
    void whenNoCarLeavesThenFalse() {
        Auto car = new Car("ms123k");
        ParkingLot parkingLot = new ParkingLot(0, 1);
        assertThat(parkingLot.leave(car)).isFalse();
        assertThat(parkingLot.getFreeCarSpaces()).isEqualTo(1);
    }

    @Test
    void whenATruckLeavesThenTrueAndMoreFreeSpaces() {
        Auto truck = new Truck(3, "ms123k");
        Auto truck2 = new Truck(4, "ms456k");
        ParkingLot parkingLot = new ParkingLot(1, 3);
        assertThat(parkingLot.park(truck)).isTrue();
        assertThat(parkingLot.getTrucks()).contains(truck);
        assertThat(parkingLot.getFreeTruckSpaces()).isEqualTo(0);
        assertThat(parkingLot.leave(truck)).isTrue();
        assertThat(parkingLot.getTrucks()).doesNotContain(truck);
        assertThat(parkingLot.getFreeTruckSpaces()).isEqualTo(1);
        assertThat(parkingLot.park(truck2)).isTrue();
    }

    @Test
    void whenNoTruckLeavesThenFalse() {
        Auto truck = new Truck(3, "ms123k");
        ParkingLot parkingLot = new ParkingLot(1, 1);
        assertThat(parkingLot.leave(truck)).isFalse();
        assertThat(parkingLot.getFreeTruckSpaces()).isEqualTo(1);
    }
}