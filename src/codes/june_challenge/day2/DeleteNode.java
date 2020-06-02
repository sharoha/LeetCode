package codes.june_challenge.day2;

public class DeleteNode {
    public void deleteNode(ListNode node) {
        node.val = node.next.val; // There is no null check required since the problem does not ask to delete tail node.
        node.next = node.next.next;
    }

    static class ListNode {
        int val;
        ListNode next;
    }
}
