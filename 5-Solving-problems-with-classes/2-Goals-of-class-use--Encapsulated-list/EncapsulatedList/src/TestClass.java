public class TestClass {
    public static void main(String[] args) {
        // Here are some objects we can store in our lists...

        ReadThis r1 = new ReadThis("http://www.bustle.com/articles/" + "63466-im-brianna-wu-and-im-risking-"
                + "my-life-standing-up-to-gamergate");

        ReadThis r2 = new ReadThis("http://i.imgur.com/4NjBQzn.jpg");

        ReadThis r3 = new ReadThis("http://imgur.com/zhppgSx");

        ReadThis r4 = new ReadThis("http://gnuu.org/2009/09/18/writing-" + "your-own-toy-compiler/all/1/");

        ReadThis r5 = new ReadThis(
                "https://gigaom.com/2015/02/10/samsung-" + "tvs-start-inserting-ads-into-your-movies/");

        ////
        // We can manually create a linked list
        // with two nodes like this:

        ListNode listHead = new ListNode(r1, new ListNode(r2));
        LinkedList linkedList = new LinkedList(listHead);

        ListNode.printNumNodes(); // <- best way to call a static method
        // listHead.printNumNodes(); // <- prints the same thing, but should avoid
        // listHead.getNext().printNumNodes(); // <- prints the same thing, but should
        // avoid

        linkedList.printListFromHere();

        ////
        // Now we can add nodes to the beginning, end, and middle:

        linkedList.addNodeToBeginning(new ListNode(r3));

        linkedList.addNodeToEnd(new ListNode(r4));

        linkedList.addNodeAfterNode(new ListNode(r5), linkedList.getListHead());

        ListNode.printNumNodes();
        linkedList.printListFromHere();

        ////
        // Let's test removing nodes from the beginning, middle, and end:

        linkedList.removeFirstNode();
        linkedList.printListFromHere();

        linkedList.removeLastNode();
        linkedList.printListFromHere();

        linkedList.removeNode(linkedList.getListHead().getNext());
        linkedList.printListFromHere();

        linkedList.removeNode(linkedList.getListHead());
        linkedList.printListFromHere();

        linkedList.removeNode(linkedList.getListHead());
        System.out.println(linkedList.getListHead()); // <- should be null!
    }
}