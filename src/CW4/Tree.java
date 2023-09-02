package CW4;

/*
 ** Tree
 */
public class Tree {
    private Node root;
    private boolean addNode (Node node, int value){
        if (node.value == value){
            return false;
        } else {
            if (node.value > value) {
                if (node.left != null){
                    boolean result = addNode (node.left, value);
                    node.left = rebalance (node.left);
                    return result;
                } else {
                    node.left = new Node();
                    node.left.color = Color.RED;
                    node.left.value = value;
                    return true;
                }
            }  else {
                if (node.right != null){
                    boolean result = addNode (node.right, value);
                    node.right = rebalance (node.right);
                    return result;
                } else {
                    node.right = new Node();
                    node.right.color = Color.RED;
                    node.right.value = value;
                    return true;
                }
            }
        }
    }

    private void colorSwap (Node node) {
        node.right.color = Color.BLACK;
        node.left.color = Color.BLACK;
        node.color = Color.RED;

    }

    private Node rightSwap (Node node) {
        Node right = node.right;
        Node between = right.left;
        right.left = node;
        node.right = between;
        right.color = node.color;
        node.color = Color.RED;
        return right;
    }

    private Node leftSwap (Node node) {
        Node left = node.left;
        Node between = left.right;
        left.right = node;
        node.left = between;
        left.color = node.color;
        node.color = Color.RED;
        return left;
    }
    private Node rebalance (Node node){
        Node result = node;
        boolean needRebalance;
        do {
            needRebalance = false;
            if (result.right != null && result.right.color == Color.RED &&
                    (result.left == null || result.left.color == Color.BLACK)) {
                needRebalance = true;
                result = rightSwap(result);
            }
            if (result.left != null && result.left.color == Color.RED &&
                    result.left.left != null && result.left.left.color == Color.RED){
                needRebalance = true;
                result = leftSwap(result);
            }
            if (result.left != null && result.left.color == Color.RED &&
                 result.right != null && result.right.color == Color.RED) {
                needRebalance = true;
                colorSwap(result);
            }
        }
        while(needRebalance);
        return result;
    }

    /*public boolean contains(V value){
        Node node = root;
        while (node != null){
            if (node.value.equals(value)){
                return true;
            }
            if (node.value.compareTo(value) > 0){
                node = node.left;
            }else{
                node = node.right;
            }
        }
        return false;
    }*/

    public boolean add(int value){
        if (root != null){
            boolean result = addNode (root, value);
            root = rebalance(root);
            root.color = Color.BLACK;
            return result;
        } else {
            root = new Node();
            root.color = Color.BLACK;
            root.value = value;
            return true;
        }
    }

    private class Node{
        private int value;
        private Color color;
        private Node left;
        private Node right;
    }

    private enum Color {
        RED, BLACK
    }

}