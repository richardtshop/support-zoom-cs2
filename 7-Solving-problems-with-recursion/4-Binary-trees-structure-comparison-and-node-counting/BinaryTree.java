import java.util.ArrayList;

public class BinaryTree {
    private String data;
    private BinaryTree leftChild;
    private BinaryTree rightChild;

    // A constructor that takes root data only and
    // makes a tree with no children (i.e., a leaf)
    public BinaryTree(String d) {
        data = d;
        leftChild = null;
        rightChild = null;
    }

    // A constructor that takes root data as well as two subtrees
    // which then become children to this new larger tree.
    public BinaryTree(String d, BinaryTree left, BinaryTree right) {
        data = d;
        leftChild = left;
        rightChild = right;
    }

    // Get methods
    public String getData() {
        return data;
    }

    public BinaryTree getLeftChild() {
        return leftChild;
    }

    public BinaryTree getRightChild() {
        return rightChild;
    }

    // Set methods
    public void setData(String d) {
        data = d;
    }

    public void setLeftChild(BinaryTree left) {
        leftChild = left;
    }

    public void setRightChild(BinaryTree right) {
        rightChild = right;
    }

    // Return the height of the tree
    public int height() {
        // Base case: if there are no more children, return 1
        if (leftChild == null && rightChild == null) {
            return 1;
        }

        // Recursive case: one or neither child is null
        if (leftChild == null) {
            return 1 + rightChild.height();
        } else if (rightChild == null) {
            return 1 + leftChild.height();
        } else {
            return 1 + Math.max(leftChild.height(), rightChild.height());
        }
    }

    // Return all the leaves of the tree
    public ArrayList<String> leafData() {
        ArrayList<String> result = new ArrayList<String>();

        if (data != null) {
            // Base case: check if the current tree is a leaf, and if so,
            // add the data
            if ((leftChild == null) && (rightChild == null)) {
                result.add(data);
            }
        }

        // Recursive case: collect the leaves of the children and add them
        if (leftChild != null) {
            result.addAll(leftChild.leafData());
        }
        if (rightChild != null) {
            result.addAll(rightChild.leafData());
        }

        // Return all the leaves part of this tree
        return result;
    }

    // compare to trees to see if they have the same structure AND data
    public boolean hasSameContentsAs(BinaryTree tree) {
        // If comparison tree is empty return false
        if (tree == null) {
            return false;
        }

        // Base case if both nodes are leaf nodes, compare data and return if equal
        if (isLeafNode(leftChild, rightChild) && isLeafNode(tree.getLeftChild(), tree.getRightChild())) {
            return data == tree.getData();
        }

        // Compare data between two tree nodes, and return false if they are not equal
        if (data != tree.getData()) {
            return false;
        }

        // For the recursive call, if any call fails in comparison checks, false is
        // returned back through the each recusrive call and will return false for the
        // initial non-recursive call

        // If either child nodes on this tree is null, the matching child node on the
        // compared tree must be null
        if (((leftChild == null) && (tree.getLeftChild() != null))
                || ((rightChild == null) && (tree.getRightChild() != null))) {
            return false;
        }

        // recursive calls to compare next child nodes for each side if all previous
        // checks for inequality have passed
        if (((leftChild != null) && (leftChild.hasSameContentsAs(tree.getLeftChild()) == false))
                || ((rightChild != null) && (rightChild.hasSameContentsAs(tree.getRightChild()) == false))) {
            return false;
        }

        // data and nodes are the same for each call
        return true;
    }

    public int numberOfNodes() {
        // base case a single node
        if (leftChild == null && rightChild == null) {
            return 1;
        }

        // recursive calls if one or both child nodes are not null
        if (leftChild == null && rightChild != null) {
            return 1 + rightChild.numberOfNodes();
        } else if (leftChild != null && rightChild == null) {
            return 1 + leftChild.numberOfNodes();
        } else {
            return 1 + leftChild.numberOfNodes() + rightChild.numberOfNodes();
        }
    }

    // helper method to determine if a node is a leaf
    public boolean isLeafNode(BinaryTree left, BinaryTree right) {
        if ((left == null) && (right == null)) {
            return true;
        }
        return false;
    }
}
