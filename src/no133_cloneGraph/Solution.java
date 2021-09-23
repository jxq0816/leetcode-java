package no133_cloneGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Solution {
    HashMap<Node,Node> visited=new HashMap<Node,Node>();
    public Node cloneGraph(Node node) {
        if(node==null){
            return null;
        }
        if(visited.containsKey(node)){
            return visited.get(node);
        }
        Node newNode=new Node(node.val);
        visited.put(node,newNode);
        List<Node> newList=new ArrayList<>();
        List<Node> list=node.neighbors;
        for(Node nb:list){
            newList.add(cloneGraph(nb));
        }
        newNode.neighbors=newList;
        return newNode;
    }
}
