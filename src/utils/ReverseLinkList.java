package utils;

public class ReverseLinkList {
    public static ListNode reverse(ListNode head){
        if(head==null){
            return null;
        }
        ListNode pre=null;//1
        ListNode current=pre;//2
        while(current!=null){
            ListNode nextNode=current.next;//null
            current.next=pre;//2->1
            if(pre==head){
                pre.next=null;
            }
            pre=current;//pre=2
            current=nextNode;
        }
        return pre;
    }
    public static void main(String[] args) {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        node2.next=null;
        node1.next=node2;
        ListNode rs=reverse(node1);
        while(rs!=null){
            System.out.println(rs.val);
            rs=rs.next;
        }
    }
}
