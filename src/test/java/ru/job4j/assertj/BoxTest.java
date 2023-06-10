package ru.job4j.assertj;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isNotNull()
                .isNotEmpty()
                .isNotBlank()
                .startsWith("Sp")
                .startsWithIgnoringCase("sph")
                .endsWith("ere")
                .isEqualTo("Sphere");
    }

    @Test
    void isThisCube() {
        Box box = new Box(8, 5);
        String name = box.whatsThis();
        assertThat(name).isNotNull()
                .isNotEmpty()
                .isNotBlank()
                .containsIgnoringCase("B")
                .doesNotContain("i")
                .isEqualTo("Cube");
    }

    @Test
    void whenVertex2ThenVertexMinus1() {
        Box box = new Box(2, 4);
        int vert = box.getNumberOfVertices();
        assertThat(vert).isNegative()
                .isLessThan(0)
                .isEqualTo(-1);
    }

    @Test
    void whenVertex4Then4() {
        Box box = new Box(4, 4);
        int vert = box.getNumberOfVertices();
        assertThat(vert).isPositive()
                .isLessThan(5)
                .isGreaterThan(0)
                .isEven()
                .isEqualTo(4);
    }

    @Test
    void checkIfExists() {
        Box box = new Box(4, 2);
        boolean result = box.isExist();
        assertThat(result).isTrue();
    }

    @Test
    void checkIfNotExists() {
        Box box = new Box(4, -2);
        boolean result = box.isExist();
        assertThat(result).isFalse();
    }

    @Test
    void checkAreaOfSphere() {
        Box box = new Box(0, 2);
        double area = box.getArea();
        assertThat(area).isGreaterThan(50.26d)
                .isLessThan(50.27d)
                .isEqualTo(50.26d, withPrecision(0.006d));
    }

    @Test
    void checkAreaOfTetrahedron() {
        Box box = new Box(4, 2);
        double area = box.getArea();
        assertThat(area).isCloseTo(6.928d, withPrecision(0.01d))
                .isCloseTo(6.928d, Percentage.withPercentage(1.0d))
                .isEqualTo(6.928d, withPrecision(0.0003d));
    }
}