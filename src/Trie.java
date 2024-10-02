public class Trie {
    private Node[] roots;

    public Trie(Node[] roots) {
        this.roots = roots;
    }

    public void insert(String insertString, Node[] next, int posInString) {
        if (posInString == insertString.length()) {
            return;
        }

        if (next[insertString.charAt(posInString)] != null) {
            insert(insertString, next[insertString.charAt(posInString)].getNextSet(), ++posInString);
        } else {
            if (posInString == insertString.length() - 1) {
                next[insertString.charAt(posInString)] = new Node(true);
            } else {
                next[insertString.charAt(posInString)] = new Node(false);
            }
            insert(insertString, next[insertString.charAt(posInString)].getNextSet(), ++posInString);
        }
    }

    public boolean inTrie(String searchFor, Node[] next, int posInString) {
        if (posInString == searchFor.length() - 1 && posInString < searchFor.length() - 1 && next[searchFor.charAt(posInString)] != null) {
            return true;
        }
        if (posInString == searchFor.length()) {
            return false;
        }

        if (posInString < searchFor.length() - 1 && next[searchFor.charAt(posInString)] != null) {
            return inTrie(searchFor, next[searchFor.charAt(posInString)].getNextSet(), ++posInString);
        }
    }
}