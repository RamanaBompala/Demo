import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanIntTest {

    @Test
    public void testIntToRoman() {
        assertEquals("I", Main.intToRoman(1));
        assertEquals("IV", Main.intToRoman(4));
        assertEquals("IX", Main.intToRoman(9));
        // Add more test cases for intToRoman
    }

    @Test
    public void testRomanToInt() {
        assertEquals(1, Main.romanToInt("I"));
        assertEquals(4, Main.romanToInt("IV"));
        assertEquals(9, Main.romanToInt("IX"));
        // Add more test cases for romanToInt
    }
}
