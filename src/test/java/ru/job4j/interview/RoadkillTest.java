package ru.job4j.interview;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RoadkillTest {
    @Test
    public void testEx() {
        assertEquals("hyena", Roadkill.roadKill("==========h===yyyyyy===eeee=n==a========"));
        assertEquals("penguin", Roadkill.roadKill("======pe====nnnnnn=======================n=n=ng====u==iiii=iii==nn========================n="));
        assertEquals("bear", Roadkill.roadKill("=====r=rrr=rra=====eee======bb====b======="));
    }

    @Test
    public void testEasyKnown() {
        assertEquals("snake", Roadkill.roadKill("===snake======"));
        assertEquals("snake", Roadkill.roadKill("===sssssssssssssssssssnakeeeeeeeeeeeeeeeeeeeeeee======="));
        assertEquals("snake", Roadkill.roadKill("==ekans=="));
    }

    @Test
    public void testEasyUnknown() {
        assertEquals("??", Roadkill.roadKill("===h=====i=tch======h=====i=kkkkkkk=eeeeee====rr=r=r=r=rrr===================="));
        assertEquals("??", Roadkill.roadKill("==w===t===f============="));
    }

    @Test
    public void testTrickyKnown() {
        assertEquals("baboon", Roadkill.roadKill("===b=b==========a=a=a=a=a=a=a=boo======n====="));
        assertEquals("squirrel", Roadkill.roadKill("====l===e===r=======riuqs====="));
        assertEquals("aardvark", Roadkill.roadKill("=====k====r=a=vvvv==d=d=d=d=r==a=a======="));
        assertEquals("rabbit", Roadkill.roadKill("====rraabbiitt=="));
    }

    @Test
    public void testTrickyUnknown() {
        assertEquals("??", Roadkill.roadKill("=============="));
        assertEquals("??", Roadkill.roadKill("===       ===snake========="));
        assertEquals("??", Roadkill.roadKill("      "));
        assertEquals("??", Roadkill.roadKill(""));
        assertEquals("??", Roadkill.roadKill("==a======a=a=a=lig===a=t====o=r=r=r=r=="));
        assertEquals("??", Roadkill.roadKill("===f====o===x===y====="));
        assertEquals("??", Roadkill.roadKill("====Snake==="));
        assertEquals("??", Roadkill.roadKill("=======fly===dragon===="));
        assertEquals("??", Roadkill.roadKill("=========.*=\\d\\d\\..//[)44567$$$+..)===="));
    }
}