package no138_copyRandomList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    Map<Node,Node> cacheNode=new HashMap<Node,Node>();
    public Node copyRandomList(Node head) {
        if (head==null) {
            return null;
        }
        if(!cacheNode.containsKey(head)){
            Node newHead=new Node(head.val);
            cacheNode.put(head,newHead);
            newHead.next=copyRandomList(head.next);
            newHead.random=copyRandomList(head.random);
        }
        return cacheNode.get(head);
    }
}
