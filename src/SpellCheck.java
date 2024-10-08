import java.util.ArrayList;

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

    // createTrie methods generated a trie to store dictionary and returns it
    public Trie createTrie(String[] dictionary) {
        Trie dict = new Trie();

        // Loops through all strings in the dictionary and inserts it into the trie
        for (String s : dictionary) {
            dict.insert(s);
        }

        return dict;
    }

    // checkTrie method compares the dictionary with the text and reports any misspelled words
    public String[] checkTrie(Trie trie, String[] text) {
        ArrayList<String> notInTrie = new ArrayList<String>();
        // Creates a trie of misspelled words so that no duplicates are appended
        Trie misspelledTrie = new Trie();

        // Loops through all strings in the text and checks if its not a duplicate and not a word
        for (String s : text) {
            if (!trie.inTrie(s) && !misspelledTrie.inTrie(s)) {
                // If so, adds it to misspelledWords so it isn't repeated later
                misspelledTrie.insert(s);
                notInTrie.add(s);
            }
        }

        // Creates a string array to return as the final list of misspelled words
        String[] notFound = new String[notInTrie.size()];
        return notInTrie.toArray(notFound);
    }

    // Similar logic to above except completes task with a TST instead
    public TST createTST(String[] dictionary) {
        TST dict = new TST();

        for (String s : dictionary) {
            dict.insert(s);
        }

        return dict;
    }

    // Same logic as above except with a TST
    public String[] checkTST(TST tst, String[] text) {
        ArrayList<String> notInTST = new ArrayList<String>();
        // Creates a TST of misspelled words so that no duplicates are appended to final list
        TST misspelledTST = new TST();

        for (String s : text) {
            if (!tst.inTST(s) && !misspelledTST.inTST(s)) {
                misspelledTST.insert(s);
                notInTST.add(s);
            }
        }

        String[] notFound = new String[notInTST.size()];
        return notInTST.toArray(notFound);
    }

    // Main function that runs all helper functions above
    public String[] checkWords(String[] text, String[] dictionary) {
        // Code to run Trie:
            // Trie dictionaryTrie = createTrie(dictionary);
            // return checkTrie(dictionaryTrie, text);
        // Code to run TST (I chose to implement TST as in my cases it runs quite a bit more efficiently)
        TST dictionaryTST = createTST(dictionary);
        return checkTST(dictionaryTST, text);
    }
}