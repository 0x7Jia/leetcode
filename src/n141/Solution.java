package n141;

import list.ListNode;
import list.ListUtils;

/**
 * @author echo
 * @version V1.0
 * @Package n141
 * @date 2020/9/19 22:36
 */
public class Solution {
    public static boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ListNode head = ListUtils.getList(new int[]{1}, 0);
        System.out.println(hasCycle(head));
    }
}
