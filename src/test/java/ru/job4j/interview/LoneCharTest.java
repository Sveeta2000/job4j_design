package ru.job4j.interview;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LoneCharTest {
    @Test
    @DisplayName("Example tests")
    void testBasic() {
        assertArrayEquals(new char[]{'a'}, LoneChar.loneliest("a"));
        assertArrayEquals(new char[]{'g'}, LoneChar.loneliest("abc d   ef  g   h i j      "));
        assertArrayEquals(new char[]{'b'}, LoneChar.loneliest("a   b   c "));
        assertArrayEquals(new char[]{'z'}, LoneChar.loneliest("  abc  d  z    f gk s "));
        assertArrayEquals(new char[]{'b', 'c'}, LoneChar.loneliest("a  b  c  de  "));
        assertArrayEquals(new char[]{'a', 'b', 'c'}, LoneChar.loneliest("abc"));
        assertArrayEquals(new char[]{'c', 'g'}, LoneChar.loneliest("refb    l   miq hj      ko n    g    p  a    c    d        "));
        assertArrayEquals(new char[]{'f', 'g', 'j'}, LoneChar.loneliest("a j       g c  b  e     hd       f i"));
        assertThat(LoneChar.loneliest("refb    l   miq hj      ko n    g    p  a    c    d        ")).containsExactlyInAnyOrder('g', 'c');
    }
}