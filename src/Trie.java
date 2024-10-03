public class Trie {
    private Node root;

    public Trie() {
        this.root = new Node(false);
    }

    public void insert(String insertString) {
        Node curPos = root;
        for (int i = 0; i < insertString.length(); i++) {
            if (curPos.getNextSet()[insertString.charAt(i)] == null) {
                curPos.getNextSet()[insertString.charAt(i)] = new Node(false);
            }

            curPos = curPos.getNextSet()[insertString.charAt(i)];
        }
        curPos.setWordEnd(true);
    }

    public boolean inTrie(String searchFor) {
        Node curPos = root;
        for (int i = 0; i < searchFor.length(); i++) {
            curPos = curPos.getNextSet()[searchFor.charAt(i)];

            if (curPos == null) {
                return false;
            }
        }
        return curPos.getWordEnd();
    }

    public Node getRoot() {
        return root;
    }
}