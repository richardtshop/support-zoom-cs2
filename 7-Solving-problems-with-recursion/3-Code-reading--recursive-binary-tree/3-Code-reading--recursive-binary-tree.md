# Code Reading: Recursive Binary Trees

We saw how Think Like a Programmer approached recursive solutions to binary trees. We've also seen a graph structure in our branching story example, so moving to a binary tree (where each node has 0-2 children) is relatively straightforward. Here, we'll look at one implementation of a binary tree in Java, as well as a couple of methods that are designed recursively.

One special difference between the branching story graph and the binary tree used here is that we don't use node classes to represent the tree, but rather define a binary tree recursively in terms of itself. The left and right children, when they exist, are actually references to entire trees.

1. Draw a diagram of the binary tree created in the testing class. Be sure to label the nodes with the letter provided in the constructor.

2. Explain in English how the height() method works. Be sure to illustrate your understanding of recursion in your explanation.
   The height recursive method first checks the base case to see if the base node has no left nor right children. If not then it returns 1, which is the height of tree.

   The recursive call is then divided into three options in an if/else statement, if there is only a left child, only a right, or both for the current node. Each call inspects the current node of the tree, passing the rest of the tree/branch into the next call, adding 1 to indicate an increase in height, with the overall height of the tree being returned. The recursion calls continue to be called until a leaf node is reached, returning 1. In the case of two children existing the maximum value is returned.

3. Do the same for the leafData() method.
   The leafData method first creates a new ArrayList<String> to store the data from the tree. It then checks the base case to see if 1) there is data in the base node, and then checks if the node is a leaf with no children. If so it adds the data to the ArrayList.

   Then recursive calls are made if leftChild and rightChild nodes if they are not null. With each recursive call, the node is checked for data and if it's a leaf node the data is added to the ArrayList for that call, returning the ArrayList which is joined to the ArrayList from the previous calls using addAll(), allowing all Leaf node data to be added to the result ArrayList.
