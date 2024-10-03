public class Trie {
    private Node root;

    public Trie(Node root) {
        this.root = root;
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

    public void insert(String insertString, Node next) {
        Node curPos = next;
        for (int i = 0; i < insertString.length() - 1; i++) {
            if (curPos.getNextSet()[insertString.charAt(i)] != null) {
                curPos = curPos.getNextSet()[insertString.charAt(i)];
            } else {
                curPos.getNextSet()[insertString.charAt(i)] = new Node(false);
                curPos = curPos.getNextSet()[insertString.charAt(i)];
            }
        }
        curPos.getNextSet()[insertString.charAt(insertString.length() - 1)] = new Node(true);
    }

    public boolean inTrie(String searchFor, Node[] next, int posInString) {
        if (posInString == searchFor.length() - 1 && posInString < searchFor.length() - 1 && next[searchFor.charAt(posInString)] != null) {
            return true;
        } else if (posInString == searchFor.length() - 1) {
            return false;
        }

        if (next[searchFor.charAt(posInString)] != null) {
            return inTrie(searchFor, next[searchFor.charAt(posInString)].getNextSet(), ++posInString);
        }

        return false;
    }

    public boolean inTrie(String searchFor, Node next) {
        Node curPos = next;
        for (int i = 0; i < searchFor.length(); i++) {
            if (curPos == null || curPos.getNextSet()[searchFor.charAt(i)] == null) {
                return false;
            }
            curPos = curPos.getNextSet()[searchFor.charAt(i)];
        }
        return true;
    }

    public Node getRoot() {
        return root;
    }
}