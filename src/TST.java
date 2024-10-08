public class TST {
    private TSTNode root;

    public TST() {
        root = new TSTNode('m', false);
    }

    public void insert(String s) {
        root = insert(s, 0, root);
    }

    public TSTNode insert(String s, int curIndex, TSTNode curRoot) {
        if (curIndex >= s.length() - 1) {
            if (curRoot != null) {
                curRoot.setEndOfWord(true);
            } else {
                curRoot = new TSTNode(s.charAt(curIndex), true);
            }
            return curRoot;
        }
        if (curRoot == null) {
            curRoot = new TSTNode(s.charAt(curIndex), false);
            curRoot.setMiddle(insert(s, curIndex + 1, curRoot.getMiddle()));
        } else if (s.charAt(curIndex) < curRoot.getNodeChar()) {
            curRoot.setLeft(insert(s, curIndex, curRoot.getLeft()));
        } else if (s.charAt(curIndex) > curRoot.getNodeChar()) {
            curRoot.setRight(insert(s, curIndex, curRoot.getRight()));
        } else {
            curRoot.setMiddle(insert(s, curIndex + 1, curRoot.getMiddle()));
        }
        return curRoot;
    }

    public boolean inTST(String s) {
        TSTNode curNode = root;

        for (int i = 0; i < s.length();) {
            if (curNode == null) {
                return false;
            }
            if (s.charAt(i) == curNode.getNodeChar()) {
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
        return false;
    }

    public TSTNode getRoot() {
        return root;
    }
}