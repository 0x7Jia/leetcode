package list;

/**
 * @author echo
 * @version V1.0
 * @Package list
 * @date 2020/9/19 22:22
 */
public class ListUtils {
    public static ListNode getList(int[] arr, int pos){
        ListNode head=null, t = null;
        for (int value : arr) {
            ListNode temp = new ListNode(value);
            if (head == null) {
                head = temp;
                t = head;
                continue;
            }
            t.next = temp;
            t = t.next;
        }

        if (pos != -1){
            t.next = getCycleNode(head, pos);
        }
        return head;
    }

    private static ListNode getCycleNode(ListNode head, int pos) {
        int idx = 0;
        ListNode t = head;
        while (idx++!=pos){
            t = t.next;
        }
        return t;
    }

    public static void main(String[] args) {
        ListNode list = getList(new int[]{3, 2, 0, -4}, 1);
        System.out.println(list);
    }
}
