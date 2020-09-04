public class ListNode {
    private ReadThis data;
    private ListNode next;

    private static int totalNodes = 0;

    ////
    // Constructors
    public ListNode(ReadThis newData) {
        this(newData, null);
    }

    public ListNode(ReadThis newData, ListNode newNext) {
        setData(newData);
        setNext(newNext);
        totalNodes++;
    }
    ////
    // getters

    public ReadThis getData() {
        return data;
    }

    public ListNode getNext() {
        return next;
    }

    ////
    // setters
    public void setData(ReadThis newData) {
        data = newData;
    }

    public void setNext(ListNode newNext) {
        next = newNext;
    }

    ////
    // Other methods
    public static void printNumNodes() {
        System.out.println(totalNodes + " have been created so far.");
    }

    ////
}