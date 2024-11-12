/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        ListNode res1 = headA;
        ListNode res2 = headB;
        int count1 = 0;
        int count2 = 0;
        while(temp1!=null)
        {
            count1++;
            temp1 = temp1.next;
        }
        while(temp2!=null)
        {
            count2++;
            temp2 = temp2.next;
        }
        if(count1 > count2)
        {
            while(count1-- != count2)
            {
                res1 = res1.next;
            }
        }
        else
        {
            while(count2-- != count1)
            {
                res2 = res2.next;
            }
        }
        while(res1!=null && res2!=null)
        {
            if(res1 == res2)
            {
                return res1;
            }
            res1 = res1.next;
            res2 = res2.next;
        }
        return res1;
    }
}