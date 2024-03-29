package no2_add_two_numbers;
import utils.ListNode;
/**
给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
示例：
输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
 */

public class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null&&l2==null){
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int addOne = 0;
        while(l1!=null || l2!=null || addOne!=0){
            int val1=l1==null?0:l1.val;
            int val2=l2==null?0:l2.val;
            int sum=val1+val2+addOne;
            curr.next=new ListNode(sum%10);
            curr=curr.next;
            addOne=sum/10;
            if(l1!=null){
                l1=l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1_1=new ListNode(2);
        ListNode l1_2=new ListNode(4);
        ListNode l1_3=new ListNode(3);
        l1_1.next=l1_2;
        l1_2.next=l1_3;

        ListNode l2_1=new ListNode(5);
        ListNode l2_2=new ListNode(6);
        ListNode l2_3=new ListNode(4);
        l2_1.next=l2_2;
        l2_2.next=l2_3;

        ListNode rs=addTwoNumbers(l1_1,l2_1);
        System.out.println(ListNode.print(rs));
    }
}
