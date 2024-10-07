public class TSTNode {
    private TSTNode left;
    private TSTNode middle;
    private TSTNode right;
    private char nodeChar;
    private boolean endOfWord;

    public TSTNode(char nodeChar, boolean endOfWord) {
        this.left = null;
        this.middle = null;
        this.right = null;
        this.nodeChar = nodeChar;
        this.endOfWord = endOfWord;
    }

    public TSTNode getLeft() {
        return left;
    }

    public void setLeft(TSTNode left) {
        this.left = left;
    }

    public TSTNode getMiddle() {
        return middle;
    }

    public void setMiddle(TSTNode middle) {
        this.middle = middle;
    }

    public TSTNode getRight() {
        return right;
    }

    public void setRight(TSTNode right) {
        this.right = right;
    }

    public char getNodeChar() {
        return nodeChar;
    }

    public boolean isEndOfWord() {
        return endOfWord;
    }

    public void setEndOfWord(boolean endOfWord) {
        this.endOfWord = endOfWord;
    }
}
