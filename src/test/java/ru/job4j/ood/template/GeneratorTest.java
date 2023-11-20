package ru.job4j.ood.template;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;

@Disabled
class GeneratorTest {
    @Test
    void whenCorrectKeysThenCorrectAnswer() {
        Generator generator = new SimpleGenerator();
        String template = "I am ${name}, Who are ${subject}?";
        Map<String, String> map = Map.of("name", "Anna", "subject", "you");
        assertThat(generator.produce(template, map)).isEqualTo("I am Anna, Who are you?");
    }

    @Test
    void whenIncorrectKeysThenExceptionIsThrown() {
        Generator generator = new SimpleGenerator();
        String template = "I am ${name}, Who are ${subject}? Where are my ${item}?";
        Map<String, String> map = Map.of("name", "Anna", "subject", "you");
        assertThatThrownBy(() -> generator.produce(template, map))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid key");
    }

    @Test
    void whenExtraKeysThenExceptionIsThrown() {
        Generator generator = new SimpleGenerator();
        String template = "I am ${name}";
        Map<String, String> map = Map.of("name", "Anna", "subject", "you");
        assertThatThrownBy(() -> generator.produce(template, map))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("The map contains extra keys");
    }
}