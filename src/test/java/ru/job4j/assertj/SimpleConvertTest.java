package ru.job4j.assertj;

import org.junit.jupiter.api.Test;
import org.assertj.core.data.Index;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class SimpleConvertTest {
    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> rsl = simpleConvert.toList("a", "b", "c", "0", "1");
        assertThat(rsl).isNotNull()
                .isNotEmpty()
                .hasSize(5)
                .startsWith("a", "b")
                .endsWith("0", "1")
                .doesNotContain("d")
                .contains("c", Index.atIndex(2))
                .containsExactly("a", "b", "c", "0", "1");
    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> rsl = simpleConvert.toSet("a", "b", "c", "a");
        assertThat(rsl).isNotNull()
                .isNotEmpty()
                .hasSize(3)
                .allSatisfy(e -> assertThat(e).containsAnyOf("a", "b", "c"))
                .anySatisfy(e -> assertThat(e).isEqualTo("c"))
                .noneMatch(e -> e.length() > 1)
                .allMatch(e -> e.length() == 1);
    }

    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> rsl = simpleConvert.toMap("a", "b", "c", "0", "1");
        assertThat(rsl).hasSize(5)
                .containsKeys("1", "a")
                .containsValues(0, 4)
                .doesNotContainKey("5")
                .doesNotContainValue(5)
                .containsEntry("a", 0);
    }

    @Test
    void checkOneElement() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> rsl = simpleConvert.toList("a", "b", "c", "0", "1");
        assertThat(rsl).first().isEqualTo("a");
        assertThat(rsl).element(3).isNotNull().isEqualTo("0");
        assertThat(rsl).last().isNotNull().isEqualTo("1");
    }

    @Test
    void checkGroupOfElements() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> rsl = simpleConvert.toList("a", "b", "c", "aa", "bb");
        assertThat(rsl).filteredOn(e -> e.length() > 1)
                .hasSize(2)
                .first().isEqualTo("aa");
        assertThat(rsl).filteredOnAssertions(e -> assertThat(e.length()).isLessThan(2))
                .hasSize(3)
                .first().isEqualTo("a");
    }
}