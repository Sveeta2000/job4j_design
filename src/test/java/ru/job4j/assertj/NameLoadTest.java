package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameLoadTest {
    @Test
    void checkGetMapEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("no data");
    }

    @Test
    void checkParseEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::parse)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Names array is empty");
    }

    @Test
    void checkHasNoCorrectSymbolExc() {
        NameLoad nameLoad = new NameLoad();
        String str = "key:value";
        assertThatThrownBy(() -> nameLoad.parse(str))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+")
                .hasMessageContaining(str)
                .hasMessageContaining("=");
    }

    @Test
    void checkHasNoKeyExc() {
        NameLoad nameLoad = new NameLoad();
        String str = "=value";
        assertThatThrownBy(() -> nameLoad.parse(str))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+")
                .hasMessageContaining(str)
                .hasMessageContaining("key");
    }

    @Test
    void checkHasNoValueExc() {
        NameLoad nameLoad = new NameLoad();
        String str = "key=";
        assertThatThrownBy(() -> nameLoad.parse(str))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+")
                .hasMessageContaining(str)
                .hasMessageContaining("value");
    }
}