package ru.job4j.io;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ConfigTest {
    @Test
    void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Svetlana Kashina");
    }

    @Test
    void whenPairWithCommentAndEmptyLine() {
        String path = "./data/with_comments.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("key")).isEqualTo("value");
        assertThat(config.value("key2")).isEqualTo("value2");
    }

    @Test
    void whenNoValueThrowException() {
        String path = "./data/no_value.properties";
        Config config = new Config(path);
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                config::load
        );
        assertThat(ex.getMessage()).isEqualTo("key=");
    }

    @Test
    void whenNoKeyThrowException() {
        String path = "./data/no_key.properties";
        Config config = new Config(path);
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                config::load
        );
        assertThat(ex.getMessage()).isEqualTo("=value");
    }

    @Test
    void whenNoKeyAndValueThrowException() {
        String path = "./data/no_key_and_value.properties";
        Config config = new Config(path);
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                config::load
        );
        assertThat(ex.getMessage()).isEqualTo("=");
    }
}