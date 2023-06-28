package ru.job4j.iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

class ListUtilsTest {
    private List<Integer> input;

    @BeforeEach
    void setUp() {
        input = new ArrayList<>(Arrays.asList(1, 3));
    }

    @Test
    void whenAddBefore() {
        ListUtils.addBefore(input, 1, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenAddBeforeWithInvalidIndex() {
        assertThatThrownBy(() -> ListUtils.addBefore(input, 3, 2))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void whenAddAfter() {
        ListUtils.addAfter(input, 0, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenAddAfterWithInvalidIndex() {
        assertThatThrownBy(() -> ListUtils.addAfter(input, 2, 4))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void whenAdd2AndRemoveIfOddThenOnly2Remains() {
        ListUtils.addBefore(input, 1, 2);
        ListUtils.removeIf(input, x -> x % 2 == 1);
        assertThat(input).hasSize(1)
                .doesNotContain(1, 3)
                .containsExactly(2);
    }

    @Test
    void whenReplaceIfOddWith0ThenTwo0() {
        ListUtils.replaceIf(input, x -> x % 2 == 1, 0);
        assertThat(input).hasSize(2)
                .doesNotContain(1, 3)
                .containsExactly(0, 0);
    }

    @Test
    void whenRemoveAllThenEmpty() {
        ListUtils.removeAll(input, List.of(3, 1, 2));
        assertThat(input).hasSize(0)
                .isEmpty();
    }

    @Test
    void whenRemoveAll1Then3IsLeft() {
        ListUtils.addAfter(input, 0, 1);
        ListUtils.addAfter(input, 1, 1);
        ListUtils.removeAll(input, List.of(1));
        assertThat(input).isNotEmpty()
                .hasSize(1)
                .doesNotContain(1)
                .containsExactly(3);
    }

    @Test
    void whenRemoveAllDifferentEls() {
        ListUtils.addAfter(input, 0, 2);
        ListUtils.addAfter(input, 1, 4);
        ListUtils.addAfter(input, 2, 5);
        ListUtils.addAfter(input, 1, 1);
        ListUtils.removeAll(input, List.of(1, 3, 5));
        assertThat(input).isNotEmpty()
                .hasSize(2)
                .doesNotContain(1, 3, 5)
                .contains(2, 4);
    }

    @Test
    void whenRemoveAllWithEmpty() {
        ListUtils.removeAll(input, List.of());
        assertThat(input).isNotEmpty()
                .hasSize(2)
                .contains(1, 3);
    }
}