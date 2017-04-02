/**
 * Created by girmes on 31/03/17.
 *
 * https://leetcode.com/problems/add-two-numbers
 *
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 *  Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 *  Output: 7 -> 0 -> 8
 */
public class ListSum {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        l1.next=l2;
        l2.next=l3;
        l3.next=null;

        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);
        l4.next=l5;
        l5.next=l6;
        l6.next=null;

        ListNode sum = addTwoNumbers(l1, l4);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode currNode = head;
        Boolean carry = false;
        int sum = 0;
        while(l1 != null || l2 != null || carry){
            sum = (l1==null?0:l1.val) + (l2==null?0:l2.val) + (carry?1:0);
            if(sum >= 10){
                carry = true;
            }else{
                carry = false;
            }
            currNode.next = new ListNode(sum%10);
            currNode = currNode.next;
            l1 = l1!=null?l1.next:null;
            l2 = l2!=null?l2.next:null;
        }
        return head.next;
    }
}


 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }