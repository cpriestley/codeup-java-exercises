import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MyFirstTest {

    @Test
    public void testMyFirstTest() {
        List<String> languages = new ArrayList<>();
        List<String> moreLanguages = new ArrayList<>();
        String codeUp = "CodeUp";
        int[] numbers = {1, 2, 3};
        int[] otherNumbers = new int[3];
        otherNumbers[0] = 1;
        otherNumbers[1] = 2;
        otherNumbers[2] = 3;
        String language = "PHP";

        assertEquals("CodeUp", codeUp);
        assertNotSame(languages, moreLanguages);
        assertArrayEquals(numbers, otherNumbers);
        assertTrue(language.contains("H")); // use assertTrue for this statement
        assertFalse(language.contains("J")); // use assertFalse for this statement
        language = null; // assertNull on the language variable
        assertNull(language);
        language = "Java";
        assertNotNull(language);
    }

}
