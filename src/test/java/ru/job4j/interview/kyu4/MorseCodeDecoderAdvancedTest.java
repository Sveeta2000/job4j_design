package ru.job4j.interview.kyu4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MorseCodeDecoderAdvancedTest {
    @Test
    public void testExampleFromDescription() throws Exception {
        assertThat(MorseCodeDecoderAdvanced
                .decodeMorse(MorseCodeDecoderAdvanced
                        .decodeBits("1100110011001100000011000000111111001100111111001111110000000000000011001111110011111100111111000000110011001111110000001111110011001100000011")))
                .isEqualTo("HEY JUDE");
    }

    @Test
    public void testLongMessagesHandling() throws Exception {
        assertThat(MorseCodeDecoderAdvanced
                .decodeMorse(MorseCodeDecoderAdvanced
                        .decodeBits("00011100010101010001000000011101110101110001010111000101000111010111010001110101110000000111010101000101110100011101110111000101110111000111010000000101011101000111011101110001110101011100000001011101110111000101011100011101110001011101110100010101000000011101110111000101010111000100010111010000000111000101010100010000000101110101000101110001110111010100011101011101110000000111010100011101110111000111011101000101110101110101110")))
                .isEqualTo("THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG.");
    }

    @Test
    public void testExtraZerosHandling() throws Exception {
        assertThat(MorseCodeDecoderAdvanced
                .decodeMorse(MorseCodeDecoderAdvanced
                        .decodeBits("1110")))
                .isEqualTo("E");
        assertThat(MorseCodeDecoderAdvanced
                .decodeMorse(MorseCodeDecoderAdvanced
                        .decodeBits("111000000")))
                .isEqualTo("E");
    }

    @Test
    public void testBasicBitsDecoding() throws Exception {
        assertThat(MorseCodeDecoderAdvanced
                .decodeMorse(MorseCodeDecoderAdvanced
                        .decodeBits("1110111")))
                .isEqualTo("M");
    }
}