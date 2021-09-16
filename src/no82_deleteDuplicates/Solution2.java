package no82_deleteDuplicates;

import utils.ListNode;

public class Solution2 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode sentinel=new ListNode(0,head);
        ListNode cur=head;
        while(cur.next!=null&&cur.next.next!=null){
            if(cur.next.val==cur.next.next.val){
                int x=cur.next.val;
                while(cur.next!=null&&cur.next.val==x){
                    cur.next=cur.next.next;
                }
            }else{
                cur=cur.next;
            }
        }
        return sentinel.next;
    }
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        ListNode node2=new ListNode(1);
        head.next=node2;
        ListNode node3=new ListNode(2);
        node2.next=node3;
        node3.next=null;
        Solution2 solution=new Solution2();
        solution.deleteDuplicates(head);
    }
}
