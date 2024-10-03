public class Node {
    private boolean isWordEnd;
    private Node[] nextSet;

    public Node(boolean isWordEnd) {
        this.nextSet = new Node[255];
        this.isWordEnd = isWordEnd;
    }

    public void setNextSet(Node[] nextSet) {
        this.nextSet = nextSet;
    }

    public void setWordEnd(boolean wordEnd) {
        isWordEnd = wordEnd;
    }

    public Node[] getNextSet() {
        return nextSet;
    }
}
