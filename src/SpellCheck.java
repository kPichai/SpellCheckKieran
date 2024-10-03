import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;

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
//    public Boolean[] generateHashmap(String[] dictionary) {
//        Boolean[] test = new Boolean[1000000000];
//        for (String s : dictionary) {
//            test[(int) hashString(s)] = true;
//        }
//        return test;
//    }
//
//    public long hashString(String stringToHash) {
//        long hash = 5;
//        for (int i = 0; i < stringToHash.length(); i++) {
//            hash = hash * 7 + (stringToHash.charAt(i) - 64);
//        }
//        return hash;
//    }
    public Trie createTrie(String[] dictionary) {
        Trie dict = new Trie(new Node(false));

        for (String s : dictionary) {
            dict.insert(s, dict.getRoot());
        }

        return dict;
    }

    public String[] checkTrie(Trie trie, String[] text) {
        ArrayList<String> notInTrie = new ArrayList<String>();

        for (String s : text) {
            if (!trie.inTrie(s, trie.getRoot())) {
                notInTrie.add(s);
            }
        }

        String[] notFound = new String[notInTrie.size()];
        return notInTrie.toArray(notFound);
    }

    public String[] checkWords(String[] text, String[] dictionary) {
//        Boolean[] test = generateHashmap(dictionary);
//        ArrayList<String> incorrect = new ArrayList<String>();
//        for (String word : text) {
//            if (!test[(int) hashString(word)]) {
//                incorrect.add(word);
//            }
//        }
//        String[] wrong = new String[incorrect.size()];
//        return incorrect.toArray(wrong);
        Trie dictionaryTrie = createTrie(dictionary);
        return checkTrie(dictionaryTrie, text);
    }
}