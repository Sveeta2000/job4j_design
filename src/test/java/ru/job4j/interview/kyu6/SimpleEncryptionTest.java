package ru.job4j.interview.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class SimpleEncryptionTest {
    @Test
    public void testEncrypt() {
        assertEquals("This is a test!", SimpleEncryption.encrypt("This is a test!", 0));
        assertEquals("hsi  etTi sats!", SimpleEncryption.encrypt("This is a test!", 1));
        assertEquals("s eT ashi tist!", SimpleEncryption.encrypt("This is a test!", 2));
        assertEquals(" Tah itse sits!", SimpleEncryption.encrypt("This is a test!", 3));
        assertEquals("This is a test!", SimpleEncryption.encrypt("This is a test!", 4));
        assertEquals("This is a test!", SimpleEncryption.encrypt("This is a test!", -1));
        assertEquals("hskt svr neetn!Ti aai eyitrsig", SimpleEncryption.encrypt("This kata is very interesting!", 1));
    }

    @Test
    public void testDecrypt() {
        assertEquals("This is a test!", SimpleEncryption.decrypt("This is a test!", 0));
        assertEquals("This is a test!", SimpleEncryption.decrypt("hsi  etTi sats!", 1));
        assertEquals("This is a test!", SimpleEncryption.decrypt("s eT ashi tist!", 2));
        assertEquals("This is a test!", SimpleEncryption.decrypt(" Tah itse sits!", 3));
        assertEquals("This is a test!", SimpleEncryption.decrypt("This is a test!", 4));
        assertEquals("This is a test!", SimpleEncryption.decrypt("This is a test!", -1));
        assertEquals("This kata is very interesting!", SimpleEncryption.decrypt("hskt svr neetn!Ti aai eyitrsig", 1));
    }

    @Test
    public void testNullOrEmpty() {
        assertEquals("", SimpleEncryption.encrypt("", 0));
        assertEquals("", SimpleEncryption.decrypt("", 0));
        assertNull(SimpleEncryption.encrypt(null, 0));
        assertNull(SimpleEncryption.decrypt(null, 0));
    }
}