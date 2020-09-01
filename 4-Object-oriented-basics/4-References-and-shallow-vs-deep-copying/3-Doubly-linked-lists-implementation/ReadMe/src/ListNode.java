public class ListNode {
    public ReadThis data;
    public ListNode next;
    public ListNode prev;

    public static int totalNodes = 0;

    public ListNode(ReadThis newData) {
        this(newData, null, null);
    }

    public ListNode(ReadThis newData, ListNode newNext, ListNode newPrev) {
        data = newData;
        next = newNext;
        if (next != null) {
            next.prev = this;
        }
        prev = newPrev;
        if (prev != null) {
            prev.next = this;
        }
        totalNodes++;
    }

    public static void printNumNodes() {
        System.out.println(totalNodes + " have been created so far.");
    }

    // Prints the list from "this" node
    public void printListFromHere() {
        System.out.println("----------\nStart List\n----------");
        ListNode currNode = this;
        while (currNode != null) {
            System.out.println("\t" + currNode.data);
            currNode = currNode.next;
        }
        System.out.println("----------\nEnd List\n----------");
    }

    // Add a node to the beginning of the list, assuming
    // "this" node is the beginning, and return the new
    // start of the list
    public ListNode addNodeToBeginning(ListNode newNode) {
        newNode.prev = null; // does this need to be explicitly set?
        newNode.next = this;
        newNode.next.prev = this;
        return newNode;
    }

    // Add a node to the end of the list "this" belongs to
    public void addNodeToEnd(ListNode newNode) {
        ListNode currNode = this;
        while (currNode.next != null) {
            currNode = currNode.next;
        }

        currNode.next = newNode;
        currNode.next.prev = currNode; // add current node as previous for new last node
    }

    // Add a node after a given node, starting the search
    // at "this"
    public void addNodeAfterNode(ListNode newNode, ListNode addAfter) {
        ListNode currNode = this;

        // Use short-circuiting: if currNode ends up being
        // null, the first part of the and expression will be
        // false and the second part will never get evaluated
        // (this avoids a null pointer exception)
        while (currNode != null && !currNode.data.equals(addAfter.data)) {
            currNode = currNode.next;
        }

        // currNode will either be null if we got to the
        // end of the list without finding the node,
        // or the node we want to add the new one after
        if (currNode != null) {
            newNode.next = currNode.next;
            newNode.prev = currNode; // set previous on new node to the current node
            currNode.next.prev = newNode; // update the previous node on the next node to point to the new node
            currNode.next = newNode;
        }
    }

    // Remove the first node in the list, and return
    // the new head
    public ListNode removeFirstNode() {
        // We just need to cut out the head node,
        // making the second node in the list the head
        // (if there isn't one, that's ok, head will
        // just become null)
        next.prev = null; // set the new first node's prev to null
        return next;
    }

    // Remove the last node from the list, and return
    // the head in case it changes because the list
    // is now empty

    // no need to update prev if removing the last node
    public ListNode removeLastNode() {
        // If there's only one item in the list,
        // the new list should be empty (i.e. head
        // is null)
        if (next == null) {
            return null;
        }

        // Otherwise, find the last node to remove
        else {
            // First we have to actually find the end of the list,
            // but we also have to hang onto the node right before the
            // last one so we can update its next reference
            ListNode prevNode = null;
            ListNode currNode = this;
            while (currNode.next != null) {
                prevNode = currNode;
                currNode = currNode.next;
            }

            // currNode is the last one in the list; now we can cut it out
            // using the previous node
            prevNode.next = null;

            // The head isn't changing in this case, so
            // just return this
            return this;
        }
    }

    // Remove the given node from the list, and return
    // the head in case it changes
    public ListNode removeNode(ListNode toRemove) {
        // Check if the head is the one to remove;
        // if so, link it out by returning a new head
        // (which can be null)
        if (data.equals(toRemove.data)) {
            return next;
        }

        // Otherwise, we can search the list for the
        // node to remove and link it out
        else {

            ListNode currNode = this;

            // Stop when the next node's data equals the data
            // we want to remove
            while (currNode.next != null && !currNode.next.data.equals(toRemove.data)) {
                currNode = currNode.next;
            }

            // If currNode's next is null, then we never found the
            // node to remove
            if (currNode.next != null) {
                currNode.next = currNode.next.next;
                currNode.prev = currNode; // set the new next node's previous after removing a node to the current
                                          // node
            }

            // If we got this far, the head hasn't changed
            return this;
        }
    }

    // Get the length of the list, assuming "this" is
    // the beginning
    public int getLength() {
        // To get the length, walk through the list one
        // node at a time, adding one for each node we
        // visit

        int length = 0;

        ListNode currNode = this;
        while (currNode != null) {
            length++;
            currNode = currNode.next;
        }

        return length;
    }

    public String concatenate() {
        String concat = "";
        ListNode currNode = this;
        while (currNode != null) {
            concat += currNode.data.url + ", ";
            currNode = currNode.next;
        }
        return concat;
    }

    public ListNode reverse() {
        ListNode currNode = this;
        // assign current
        ListNode listHead = this;
        while (currNode != null) { // swap prev and next for each node
            ListNode temp = currNode.prev;
            currNode.prev = currNode.next;
            currNode.next = temp;
            // assign listHead to current node
            listHead = currNode;
            // change current node to prev (formerly next) node
            currNode = currNode.prev;
        }
        return listHead;
    }

}
