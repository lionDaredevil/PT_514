import java.util.ArrayList;

/**
 * This class helps to work with String data
 */
public class StringHelper {

    /**
     * Counts how many chars from array are in String
     *
     * @param innerline
     * @param searchChars
     * @return
     */
    public static int repeatCount(String innerline, char[] searchChars) {
        char[] innerChars = innerline.toCharArray();
        int i = 0;
        for (char x : innerChars) {
            for (char n : searchChars) {
                if (x == n) {
                    i++;
                }
            }
        }
        return i;
    }

    public static int punctuationMarksCount(String innerline) {
        char[] marks = {',', ';', '?', '!', ':', '.', '-'};
        return StringHelper.repeatCount(innerline, marks);
    }

    /**
     * Returns how many times word is met in innerline
     *
     * @param innerline
     * @param word
     * @return
     */
    public static int repeatCount(String innerline, String word) {
        String[] words = innerline.split("\\W+");
        int i = 0;
        for (String s : words) {
            if (s.equals(word)) {
                i++;
            }
        }
        return i;
    }

    /**
     * Allows to find the list of words from the first String line that are
     * unique comparing with the second line
     *
     * @param one
     * @param two
     * @return
     */
    public static ArrayList<String> twoLinesDifference(String one, String two) {

        String[] oneparsed = one.split("\\W+");
        ArrayList<String> difference = new ArrayList<>();
        for (String s1 : oneparsed) {
            if (two.indexOf(s1) == -1) {
                difference.add(s1);
            }
        }
        return difference;

    }

}
