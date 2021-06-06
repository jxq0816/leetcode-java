package utils;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    public static String print(ListNode node){
        StringBuilder sb=new StringBuilder();
        while(node!=null){
            sb.append(node.val);
            node=node.next;
        }
        return sb.toString();
    }
}