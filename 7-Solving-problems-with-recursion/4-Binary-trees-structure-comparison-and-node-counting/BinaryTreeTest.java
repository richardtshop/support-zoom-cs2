public class BinaryTreeTest {
        public static void main(String[] args) {
                BinaryTree root1 = new BinaryTree("A", new BinaryTree("B", new BinaryTree("C", new BinaryTree("D"),
                                new BinaryTree("E", new BinaryTree("F", new BinaryTree("G"), new BinaryTree("I")),
                                                new BinaryTree("H"))),
                                new BinaryTree("J",
                                                new BinaryTree("K", null,
                                                                new BinaryTree("L", null, new BinaryTree("M"))),
                                                new BinaryTree("N", null, new BinaryTree("O")))),
                                new BinaryTree("P", new BinaryTree("Q"), new BinaryTree("R",
                                                new BinaryTree("S", new BinaryTree("T"), null), new BinaryTree("U"))));

                // Tree the same as the first tree
                BinaryTree root2 = new BinaryTree("A", new BinaryTree("B", new BinaryTree("C", new BinaryTree("D"),
                                new BinaryTree("E", new BinaryTree("F", new BinaryTree("G"), new BinaryTree("I")),
                                                new BinaryTree("H"))),
                                new BinaryTree("J",
                                                new BinaryTree("K", null,
                                                                new BinaryTree("L", null, new BinaryTree("M"))),
                                                new BinaryTree("N", null, new BinaryTree("O")))),
                                new BinaryTree("P", new BinaryTree("Q"), new BinaryTree("R",
                                                new BinaryTree("S", new BinaryTree("T"), null), new BinaryTree("U"))));

                // Tree that is different from the first two both in data and stucture
                BinaryTree root3 = new BinaryTree("A", new BinaryTree("B", new BinaryTree("C", null,
                                new BinaryTree("D", new BinaryTree("F", new BinaryTree("G"), new BinaryTree("I")),
                                                new BinaryTree("H"))),
                                new BinaryTree("J",
                                                new BinaryTree("K", null,
                                                                new BinaryTree("L", null, new BinaryTree("M"))),
                                                new BinaryTree("N", null, new BinaryTree("O")))),
                                new BinaryTree("P", new BinaryTree("Q"), new BinaryTree("R",
                                                new BinaryTree("S", new BinaryTree("T"), null), null)));

                // Tree is structurally the same as 1, but holds different data
                BinaryTree root4 = new BinaryTree("Z", new BinaryTree("B", new BinaryTree("C", new BinaryTree("D"),
                                new BinaryTree("E", new BinaryTree("F", new BinaryTree("G"), new BinaryTree("I")),
                                                new BinaryTree("H"))),
                                new BinaryTree("J",
                                                new BinaryTree("K", null,
                                                                new BinaryTree("L", null, new BinaryTree("M"))),
                                                new BinaryTree("N", null, new BinaryTree("O")))),
                                new BinaryTree("P", new BinaryTree("Q"), new BinaryTree("R",
                                                new BinaryTree("S", new BinaryTree("T"), null), new BinaryTree("U"))));

                // Tree is identical to 4
                BinaryTree root5 = new BinaryTree("Z", new BinaryTree("B", new BinaryTree("C", new BinaryTree("D"),
                                new BinaryTree("E", new BinaryTree("F", new BinaryTree("G"), new BinaryTree("I")),
                                                new BinaryTree("H"))),
                                new BinaryTree("J",
                                                new BinaryTree("K", null,
                                                                new BinaryTree("L", null, new BinaryTree("M"))),
                                                new BinaryTree("N", null, new BinaryTree("O")))),
                                new BinaryTree("P", new BinaryTree("Q"), new BinaryTree("R",
                                                new BinaryTree("S", new BinaryTree("T"), null), new BinaryTree("U"))));

                // Tree is four nodes shorter than 5
                BinaryTree root6 = new BinaryTree("Z", new BinaryTree("B", new BinaryTree("C", new BinaryTree("D"),
                                new BinaryTree("E", new BinaryTree("F", new BinaryTree("G"), new BinaryTree("I")),
                                                new BinaryTree("H"))),
                                new BinaryTree("J",
                                                new BinaryTree("K", null,
                                                                new BinaryTree("L", null, new BinaryTree("M"))),
                                                new BinaryTree("N", null, new BinaryTree("O")))),
                                new BinaryTree("P", new BinaryTree("Q"), null));

                System.out.println("The tree's height is: " + root1.height());
                System.out.println("The tree's leaves are: " + root1.leafData());

                String comparisonText = "Tree comparison results comparing trees  ";

                System.out.println(comparisonText + "1 and 2: " + root1.hasSameContentsAs(root2)); // true
                System.out.println(comparisonText + "1 and 3: " + root1.hasSameContentsAs(root3)); // false
                System.out.println(comparisonText + "1 and 4: " + root1.hasSameContentsAs(root4)); // false
                System.out.println(comparisonText + "2 and 3: " + root2.hasSameContentsAs(root3)); // false
                System.out.println(comparisonText + "5 and 4: " + root5.hasSameContentsAs(root4)); // true
                System.out.println(comparisonText + "5 and 6: " + root5.hasSameContentsAs(root6)); // false

                System.out.println("Tree 1 has " + root1.numberOfNodes() + " nodes"); // 21
                System.out.println("Tree 2 has " + root2.numberOfNodes() + " nodes"); // 21
                System.out.println("Tree 3 has " + root3.numberOfNodes() + " nodes"); // 19
                System.out.println("Tree 4 has " + root4.numberOfNodes() + " nodes"); // 21
                System.out.println("Tree 5 has " + root5.numberOfNodes() + " nodes"); // 21
                System.out.println("Tree 6 has " + root6.numberOfNodes() + " nodes"); // 17
        }
}
