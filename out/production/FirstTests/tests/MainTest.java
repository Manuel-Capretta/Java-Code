import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void mult_testForValidNumbers(){
        assertEquals(6, Main.mult(2, 3));
    }

    @Test
    void add_testForValidNumbers(){
        assertEquals(6, Main.add(2, 3));
    }
}