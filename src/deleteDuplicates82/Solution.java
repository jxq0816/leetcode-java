package deleteDuplicates82;

import utils.ListNode;
import java.util.HashMap;
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead=head;
        HashMap<Integer,Integer> map=new HashMap();
        while(head!=null){
            int value=head.val;
            if(map.get(value)==null){
                map.put(value,1);
            }else{
                map.put(value,map.get(value)+1);
            }
            head=head.next;
        }
        ListNode sentinel=new ListNode(0,newHead);
        ListNode pre=sentinel,cur=newHead;
        while(cur!=null){
            if(map.get(cur.val)>=2){
                pre.next=cur.next;
                cur=cur.next;
            }else{
                pre=pre.next;
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
        Solution solution=new Solution();
        solution.deleteDuplicates(head);
    }
}
