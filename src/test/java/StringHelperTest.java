import junit.framework.TestCase;

import java.util.ArrayList;

public class StringHelperTest extends TestCase {

    public void testRepeatCount() {
        assertEquals(2, StringHelper.repeatCount("Hello world word world!", "world"));
    }

    public void testPunctuationMarksCount() {
        assertEquals(4, StringHelper.punctuationMarksCount("Hello, world!!!"));
    }

    public void testTwoLinesDifference() {
        ArrayList<String> actualResults = StringHelper.twoLinesDifference("Hello, world!", "Hello test!");
        ArrayList<String> expectedResults = new ArrayList<>();
        expectedResults.add("world");
        assertEquals(expectedResults, actualResults);
    }
}