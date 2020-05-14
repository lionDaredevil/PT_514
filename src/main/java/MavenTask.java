import org.json.simple.JSONObject;

import java.util.ArrayList;


public class MavenTask {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";


    public static void main(String[] args) throws Exception {
        JSONObject config = (JSONObject) jsonFileReader.readJson("src/main/resources/config.json");
        task1((String) config.get("text"), (String) config.get("word"));
        task2((String) config.get("text"), (String) config.get("word"));

    }

    /**
     * Two lines are given. Print to the console
     * all the words from the first line that are missing in the second.
     *
     * @param first
     * @param second
     */
    public static void task1(String first, String second) {
        ArrayList<String> diff = StringHelper.twoLinesDifference(first, second);
        System.out.println(diff);
    }

    /**
     * Given a string. It is necessary to determine how many times a word occurs in it,
     * as well as to calculate all the punctuation marks in it.
     *
     * @param sourceLine
     * @param repeatWord
     */
    public static void task2(String sourceLine, String repeatWord) {
        int wordsInLine = StringHelper.repeatCount(sourceLine, repeatWord);
        System.out.println("There are " + green(wordsInLine + " " + repeatWord) + " in the source line");
        int marksCount = StringHelper.punctuationMarksCount(sourceLine);
        System.out.println("Punctuation marks count: " + green(marksCount));
    }


    public static String green(int str) {
        return ANSI_GREEN + str + ANSI_RESET;
    }

    public static String green(String str) {
        return ANSI_GREEN + str + ANSI_RESET;
    }


}
