import constants.PenConstants;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.PrintStream;
import java.lang.reflect.Field;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TestPen {
    private Pen pen;

    @DataProvider
    public Object[][] dataProviderGetColor() {
        return new Object[][]{
                {"BLUE"},
                {"CYAN"},
                {"YELLOW"}
        };
    }

    @Test(dataProvider = "dataProviderGetColor")
    public void testGetColor(String expectedColor) {
        pen = new Pen(PenConstants.BASE_INK_CONTAINER_VALUE, PenConstants.BASE_SIZE_LETTER, expectedColor);
        Assert.assertEquals(pen.getColor(), expectedColor, "Pen writes with correct color");
    }


    @DataProvider
    public Object[][] dataProviderIsWork() {
        return new Object[][]{
                {PenConstants.BASE_INK_CONTAINER_VALUE, true},
                {Integer.MAX_VALUE, true},
                {-5, false},
                {0, false}
        };
    }

    @Test(dataProvider = "dataProviderIsWork")
    public void testIsWork(int inkContainerValue, Boolean expectedIsWorkValue) {
        pen = new Pen(inkContainerValue);
        Assert.assertEquals(pen.isWork(), expectedIsWorkValue);
    }

    @DataProvider
    public Object[][] dataProviderWriteBasic() {
        return new Object[][]{
                {
                        PenConstants.BASE_INK_CONTAINER_VALUE,
                        PenConstants.BASE_SIZE_LETTER,
                        PenConstants.BASE_WORD + '1',
                        PenConstants.BASE_WORD
                },
                {
                        PenConstants.BASE_INK_CONTAINER_VALUE,
                        PenConstants.BASE_SIZE_LETTER,
                        PenConstants.BASE_WORD,
                        PenConstants.BASE_WORD
                },

                {
                        PenConstants.BASE_INK_CONTAINER_VALUE,
                        PenConstants.BASE_SIZE_LETTER,
                        PenConstants.BASE_WORD.substring(0, 9),
                        PenConstants.BASE_WORD.substring(0, 9)
                },

                {
                        PenConstants.BASE_INK_CONTAINER_VALUE,
                        PenConstants.BASE_SIZE_LETTER,
                        "",
                        ""
                },
                {
                        PenConstants.BASE_INK_CONTAINER_VALUE,
                        PenConstants.BASE_SIZE_LETTER,
                        PenConstants.BASE_WORD_WITH_SPACE,
                        PenConstants.BASE_WORD_WITH_SPACE
                },
                {
                        PenConstants.BASE_INK_CONTAINER_VALUE,
                        0,
                        PenConstants.BASE_WORD,
                        ""
                },
                {
                        -10,
                        -1.0,
                        PenConstants.BASE_WORD,
                        ""
                }

        };
    }

    @Test(dataProvider = "dataProviderWriteBasic")
    public void testReturnWord(int inkContainerValue,
                               double sizeLetter,
                               String inputStringForWriteMethod,
                               String expectedStringFromWriteMethod) {
        Pen pen = new Pen(inkContainerValue, sizeLetter);
        Assert.assertEquals(pen.write(inputStringForWriteMethod), expectedStringFromWriteMethod, "Word will be written validation");
    }

    @DataProvider
    public Object[][] dataProviderPenInkContainerValue() {
        return new Object[][]{
                {0, ""},
                {1, PenConstants.BASE_WORD.substring(0, 1)},
                {-1, ""}
        };
    }

    @Test(dataProvider = "dataProviderPenInkContainerValue")
    public void testInkContainerBoundaryValues(int inkContainerValue, String expectedWord) {
        Pen pen = new Pen(inkContainerValue);
        Assert.assertEquals(pen.write(PenConstants.BASE_WORD), expectedWord, "Word will be written validation");
    }


    @DataProvider
    public Object[][] dataProviderSizeLetter() {
        return new Object[][]{
                {-1, ""},
                {0, ""},
                {1, PenConstants.BASE_WORD},
                {0.5, PenConstants.BASE_WORD},
                {2.0, PenConstants.BASE_WORD.substring(0, 5)}
        };
    }

    @Test(dataProvider = "dataProviderSizeLetter")
    public void testSizeLetterBoundaryValues(double sizeLetter, String expectedWord) {
        Pen pen = new Pen(PenConstants.BASE_INK_CONTAINER_VALUE, sizeLetter);
        Assert.assertEquals(pen.write(PenConstants.BASE_WORD), expectedWord);
    }

    @DataProvider
    public Object[][] dataProviderInkContainerValueAfterWrite() {
        return new Object[][]{
                {0, PenConstants.BASE_INK_CONTAINER_VALUE},
                {-1, PenConstants.BASE_INK_CONTAINER_VALUE},
                {1, 0}
        };
    }

    @Test(dataProvider = "dataProviderInkContainerValueAfterWrite")
    public void testInkContainerValueAfterWrite(double sizeLetter, int expectedInkContainerValue) {
        Pen pen = new Pen(PenConstants.BASE_INK_CONTAINER_VALUE, sizeLetter);
        try {
            Field inkContainerValue = pen.getClass().getDeclaredField("inkContainerValue");
            inkContainerValue.setAccessible(true);
            pen.write(PenConstants.BASE_WORD);
            Assert.assertEquals(inkContainerValue.get(pen), expectedInkContainerValue, "inkContainerValue after write method");
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testDoSomethingElse() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);
        Pen pen = new Pen(PenConstants.BASE_INK_CONTAINER_VALUE, PenConstants.BASE_SIZE_LETTER, PenConstants.BASE_COLOR);
        pen.doSomethingElse();
        verify(out).println(eq(PenConstants.BASE_COLOR));
    }

    @DataProvider
    public Object[][] dataProviderInkCountValue() {
        return new Object[][]{
                {1},
                {0},
                {-1},
                {Integer.MAX_VALUE}
        };
    }

    @Test(dataProvider = "dataProviderInkCountValue")
    public void testInkCountValueSetCorrectly(int expectedValue) {
        Pen pen = new Pen(expectedValue);
        try {
            Field inkContainerValue = pen.getClass().getDeclaredField("inkContainerValue");
            inkContainerValue.setAccessible(true);
            Assert.assertEquals(inkContainerValue.get(pen), expectedValue);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @DataProvider
    public Object[][] dataProviderInkContainerValueAndSizeLetter() {
        return new Object[][]{
                {PenConstants.BASE_INK_CONTAINER_VALUE, PenConstants.BASE_SIZE_LETTER},
                {-1, -1},
                {-1, 0},
                {0, -1},
                {0, 0},
                {1, 1},
                {Integer.MAX_VALUE, Double.MAX_VALUE}
        };
    }

    @Test(dataProvider = "dataProviderInkContainerValueAndSizeLetter")
    public void testInkCountAndSizeLetterSetCorrectly(int expectedInkContainer, double expectedSizeLetter) {
        Pen pen = new Pen(expectedInkContainer, expectedSizeLetter);
        try {
            Field inkContainerValue = pen.getClass().getDeclaredField("inkContainerValue");
            Field sizeLetter = pen.getClass().getDeclaredField("sizeLetter");
            inkContainerValue.setAccessible(true);
            sizeLetter.setAccessible(true);
            Assert.assertEquals(inkContainerValue.get(pen), expectedInkContainer, "inkContainerValue set correctly");
            Assert.assertEquals(sizeLetter.get(pen), expectedSizeLetter, "Letter size set correctly");
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @DataProvider
    public Object[][] dataProviderInkContainerValueAndSizeLetterAndColor() {
        return new Object[][]{
                {PenConstants.BASE_INK_CONTAINER_VALUE, PenConstants.BASE_SIZE_LETTER, "BLACK"},
                {-1, -1, "BLUE"},
                {-1, 0, "GREEN"},
                {0, -1, "RED"},
                {0, 0, "PINK"},
                {1, 1, "GOLD"},
                {Integer.MAX_VALUE, Double.MAX_VALUE, "YELLOW"}
        };
    }

    @Test(dataProvider = "dataProviderInkContainerValueAndSizeLetterAndColor")
    public void testInkCountAndSizeLetterAndColorSetCorrectly(int expectedInkContainer, double expectedSizeLetter, String expectedColor) {
        Pen pen = new Pen(expectedInkContainer, expectedSizeLetter, expectedColor);
        try {
            Field inkContainerValue = pen.getClass().getDeclaredField("inkContainerValue");
            Field sizeLetter = pen.getClass().getDeclaredField("sizeLetter");
            Field color = pen.getClass().getDeclaredField("color");
            inkContainerValue.setAccessible(true);
            sizeLetter.setAccessible(true);
            color.setAccessible(true);
            Assert.assertEquals(inkContainerValue.get(pen), expectedInkContainer, "inkContainerValue set correctly");
            Assert.assertEquals(sizeLetter.get(pen), expectedSizeLetter, "Letter size set correctly");
            Assert.assertEquals(color.get(pen), expectedColor, "Color set correctly");
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }


}
