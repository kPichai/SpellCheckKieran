public class TST {
    private TSTNode root;

    public TST() {
        root = new TSTNode('m', false);
    }

    public void insert(String s) {
        boolean newWord = false;
        TSTNode curNode = root;

        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            if (curNode == null) {
                curNode = new TSTNode(curChar, false);
                newWord = true;
            }

            if (!newWord && curChar < curNode.getNodeChar()) {
                curNode = curNode.getLeft();
            } else if (!newWord && curChar == curNode.getNodeChar()) {
                curNode = curNode.getMiddle();
            } else if (!newWord && curChar > curNode.getNodeChar()) {
                curNode = curNode.getRight();
            } else if (newWord) {
                curNode = curNode.getMiddle();
            }
        }
        if (curNode == null) {
            curNode = new TSTNode(s.charAt(s.length() - 1), true);
        }
    }

    public boolean inTST(String s) {
        TSTNode curNode = root;

        for (int i = 0; i < s.length();) {
            if (curNode == null) {
                return false;
            }
            if (s.charAt(i) == curNode.getNodeChar()) {
                curNode = root.getMiddle();
                i++;
            } else if (s.charAt(i) < curNode.getNodeChar()) {
                curNode = root.getLeft();
            } else if (s.charAt(i) > curNode.getNodeChar()) {
                curNode = root.getRight();
            }
        }
        if (curNode == null) {
            return false;
        }
        return curNode.isEndOfWord();
    }

    public TSTNode getRoot() {
        return root;
    }
}
