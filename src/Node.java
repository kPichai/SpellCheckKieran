public class Node {
    private boolean isWordEnd;
    private Node[] nextSet;

    public Node(boolean isWordEnd) {
        this.nextSet = new Node[255];
        this.isWordEnd = isWordEnd;
    }

    public boolean getWordEnd() {
        return isWordEnd;
    }

    public void setWordEnd(boolean wordEnd) {
        isWordEnd = wordEnd;
    }

    public Node[] getNextSet() {
        return nextSet;
    }
}
