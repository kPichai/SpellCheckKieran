/**
 * Spell Check
 * A puzzle written by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: Kieran Pichai
 * */

public class SpellCheck {


    /**
     * checkWords finds all words in text that are not present in dictionary
     *
     * @param text The list of all words in the text.
     * @param dictionary The list of all accepted words.
     * @return String[] of all mispelled words in the order they appear in text. No duplicates.
     */
    public String[] generateHashmap(String[] dictionary) {
            String[] test = new String[1000000000];
            for (int i = 0; i < 100; i++) {
                test[(int)hashString(dictionary[i])] = dictionary[i];
            }

            return test;
    }

    public long hashString(String stringToHash) {
        long hash = 7;
        for (int i = 0; i < stringToHash.length(); i++) {
            hash = hash * 31 + stringToHash.charAt(i);
        }
        System.out.println(hash);
        return hash;
    }

    public String[] checkWords(String[] text, String[] dictionary) {
        String[] test = generateHashmap(dictionary);
        return test;
    }
}
