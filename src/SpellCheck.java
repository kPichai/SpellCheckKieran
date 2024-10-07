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

    public Trie createTrie(String[] dictionary) {
        Trie dict = new Trie();

        for (String s : dictionary) {
            dict.insert(s);
        }

        return dict;
    }

    public String[] checkTrie(Trie trie, String[] text) {
        ArrayList<String> notInTrie = new ArrayList<String>();
        Trie misspelledTrie = new Trie();

        for (String s : text) {
            if (!trie.inTrie(s) && !misspelledTrie.inTrie(s)) {
                misspelledTrie.insert(s);
                notInTrie.add(s);
            }
        }

        String[] notFound = new String[notInTrie.size()];
        return notInTrie.toArray(notFound);
    }

    public TST createTST(String[] dictionary) {
        TST dict = new TST();

        for (String s : dictionary) {
            dict.insert(s);
        }

        return dict;
    }

    public String[] checkTST(TST tst, String[] text) {
        ArrayList<String> notInTST = new ArrayList<String>();
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

    public String[] checkWords(String[] text, String[] dictionary) {
//        Trie dictionaryTrie = createTrie(dictionary);
//        return checkTrie(dictionaryTrie, text);
        TST dictionaryTrie = createTST(dictionary);
        return checkTST(dictionaryTrie, text);
    }
}