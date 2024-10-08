public class TST {
    private TSTNode root;

    // Constructor for TST class, starts with m to split dictionary roughly in half
    public TST() {
        root = new TSTNode('m', false);
    }

    // Insert function to simplify input (so its just a string)
    public void insert(String s) {
        root = insert(s, 0, root);
    }

    // Full insert function (recursive)
    public TSTNode insert(String s, int curIndex, TSTNode curRoot) {
        // Base case in which we reach end of string
        if (curIndex == s.length()) {
            return curRoot;
        }
        char curChar = s.charAt(curIndex);
        // Checks empty curRoot
        if (curRoot == null) {
            curRoot = new TSTNode(curChar, false);
        }
        // Recursive cases if left, right, or middle
        if (curChar < curRoot.getNodeChar()) {
            curRoot.setLeft(insert(s, curIndex, curRoot.getLeft()));
        } else if (curChar > curRoot.getNodeChar()) {
            curRoot.setRight(insert(s, curIndex, curRoot.getRight()));
        } else {
            // Checks end of word case
            if (curIndex == s.length() - 1) {
                curRoot.setEndOfWord(true);
            } else {
                // If not, continues along middle path with recursive calls
                curRoot.setMiddle(insert(s, curIndex + 1, curRoot.getMiddle()));
            }
        }

        return curRoot;
    }

    // inTST method is a search method that searches for a given string
    public boolean inTST(String s) {
        TSTNode curNode = root;
        // Loops through length of string
        for (int i = 0; i < s.length();) {
            // Checks if it current node is null, if so you cannot find the word
            if (curNode == null) {
                return false;
            }
            // Checks if you accept letter, cases for left middle and right
            if (s.charAt(i) == curNode.getNodeChar()) {
                // End case check
                if (i == s.length() - 1) {
                    return curNode.isEndOfWord();
                }
                curNode = curNode.getMiddle();
                i++;
            } else if (s.charAt(i) < curNode.getNodeChar()) {
                curNode = curNode.getLeft();
            } else if (s.charAt(i) > curNode.getNodeChar()) {
                curNode = curNode.getRight();
            }
        }
        // If it gets through whole string without finding end returns false
        return false;
    }

    // Getter for root
    public TSTNode getRoot() {
        return root;
    }
}