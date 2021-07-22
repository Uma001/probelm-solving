package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class TreeNode{
    int val;
    List<TreeNode> children;
    public TreeNode(int val){
        this.val=val;
    }
}

public class MirrorNaryTree {

    public static void main(String[] args) {
        System.out.println(new String(new char[]{'a','b'}));
        TreeNode root=new TreeNode(1);
        root.children=new ArrayList<>(Arrays.asList(new TreeNode(2), new TreeNode(3), new TreeNode(4)));
        root.children.get(0).children=new ArrayList<>(Arrays.asList(new TreeNode(5), new TreeNode(6), new TreeNode(7)));

//        createMirror(root);
//
//        root.children.stream().map(node->node.val).forEach(System.out::println);

        System.out.println(getHeight(root));
    }

    private static int getHeight(TreeNode root) {
        int ht=-1;
        if(root.children!=null){
            for(TreeNode child: root.children){
                int childHeight=getHeight(child);
                ht=Math.max(childHeight, ht);
            }
        }
        //before returning the root will just add 1 to the height calculated from its children
        ht+=1;
        return ht;
    }

    private static void createMirror(TreeNode root) {
        if(root.children==null)return;
        for(TreeNode child:root.children){
            createMirror(child);
        }
        Collections.reverse(root.children);
    }
}
