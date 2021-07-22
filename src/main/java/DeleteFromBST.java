public class DeleteFromBST {
  public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    public static TreeNode deleteNode(TreeNode root, int X)	{
        // code here.

        TreeNode parent=root;
        TreeNode temp=root;

        while(temp!=null){
            TreeNode current=temp;
            if(X<temp.val){
                temp=temp.left;
            }else if(X>temp.val){
                temp=temp.right;
            }else{
                if(temp.left!=null && temp.right!=null){
                    TreeNode closestBiggerNode= findExtremeLeft(temp.right);
                    System.out.println("Parent: "+parent.val+" ParentLeft: "+parent.left.val+" temp: "+temp.val
                            +" closestBiggestNode: "+closestBiggerNode.val
                    );

                    if(temp==parent.left){
                        parent.left=closestBiggerNode;
                    }else{
                        parent.right=closestBiggerNode;
                        //  closestBiggerNode.right=temp.right;
                    }
                    closestBiggerNode.left=temp.left;
                    if(closestBiggerNode!=temp.right){
                        closestBiggerNode.right=temp.right;
                    }


                }else if(temp.left==null && temp.right==null){
                    if(temp==parent.left){
                        parent.left=null;
                    }else{
                        parent.right=null;
                    }
                }else{
                    TreeNode leaf=temp.left==null ? temp.right: temp.left;
                    if(temp==parent.left){
                        parent.left=leaf;
                    }else{
                        parent.right=leaf;
                    }
                }

                break;

            }
            parent=current;

        }

        printIt(root);

        return root;



    }

    private static void printIt( TreeNode node){

        if(node==null)return;

        System.out.print(node.val+" ");
        printIt(node.left);
        printIt(node.right);

    }

    private static TreeNode findExtremeLeft(TreeNode node){
        TreeNode parent=node;

        while(node.left!=null){
            parent=node;
            node=node.left;
        }
        parent.left=null;
        return node;
    }

    public static void main(String[] args) {
        TreeNode node=new TreeNode(5);
        node.left=new TreeNode(3);
        node.left.left=new TreeNode(2);
        node.left.right=new TreeNode(4);

        deleteNode(node,3);
    }





}
