package no143_ReorderList;

import utils.ListNode;
import java.util.Stack;
public class Solution {
    public void reorderList(ListNode head) {
        ListNode curr=head;
        Stack<ListNode> stack=new Stack<ListNode>();
        while(head!=null){
            stack.push(head);
            head=head.next;
        }
        while(curr!=null){
            ListNode reorderNode=stack.pop();
            //当链表节点个数为奇数时的退出条件
            if(reorderNode==curr){
                break;
            }
            ListNode tmp=curr.next;//防止链表中断，缓存
            //当链表节点个数为偶数时的退出条件，偶数会出现循环指针的情况，即自身指向自身3->3
            if(curr==tmp){
                break;
            }
            curr.next=reorderNode;//重排,1->4
            curr=curr.next;//cur=4
            curr.next=tmp;//重排,1->4->2
            curr=curr.next;//cur=2
        }
        curr.next=null;//断除尾节点后的无效节点
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        ListNode head=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        head.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=null;
        solution.reorderList(head);
        while(head!=null){
            System.out.print(head.val+"->");
            head=head.next;
        }
        System.out.println();
    }
}
