package ru.job4j.interview.kyu6;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MorseCodeDecoderTest {
    @Test
    public void testBasicMorseDecoding() {
        assertThat(MorseCodeDecoder.decode(".-")).isEqualTo("A");
        assertThat(MorseCodeDecoder.decode(".")).isEqualTo("E");
        assertThat(MorseCodeDecoder.decode("..")).isEqualTo("I");
        assertThat(MorseCodeDecoder.decode(". .")).isEqualTo("EE");
        assertThat(MorseCodeDecoder.decode(".   .")).isEqualTo("E E");
        assertThat(MorseCodeDecoder.decode("...---...")).isEqualTo("SOS");
        assertThat(MorseCodeDecoder.decode("... --- ...")).isEqualTo("SOS");
        assertThat(MorseCodeDecoder.decode("...   ---   ...")).isEqualTo("S O S");
    }

    @Test
    public void testMoreComplexTests() {
        assertThat(MorseCodeDecoder.decode(" . ")).isEqualTo("E");
        assertThat(MorseCodeDecoder.decode("   .   . ")).isEqualTo("E E");
        assertThat(MorseCodeDecoder
                .decode("      ...---... -.-.--   - .... .   --.- ..- .. -.-. -.-   -... .-. --- .-- -.   ..-. --- -..-   .--- ..- -- .--. ...   --- ...- . .-.   - .... .   .-.. .- --.. -.--   -.. --- --. .-.-.-  "))
                .isEqualTo("SOS! THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG.");
    }
}