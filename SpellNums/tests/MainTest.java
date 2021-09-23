import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void spellTestForRightWord(){
        assertEquals("sieben hundert sechs und vierzig", Main.numberToWord(746));
        assertEquals("vier hundert acht und dreissig millionen sieben hundert sechs und zwanzig tausend fünf hundert acht und neunzig", Main.numberToWord(438726598));
        assertEquals("vier und siebzig", Main.numberToWord(74));
    }
}