package practice.linkedListIntro;

public class KthElementFromEndProblem1 {

    public static class Node{

        int data;
        Node next;

        Node(){
        }

        Node(int val){
            data=val;
        }

        Node(int val,Node node){
            data=val;
            next=node;
        }
    }

    public static void main(String[] args) {
        //return kth element of the linked list in a single pass

        Node head=new Node(1,new Node(2,new Node(3,new Node(4,new Node(5,new Node(6))))));
        printNodes(head);
        printNodes(head);
        int k=3;
        System.out.println("get KTH: "+k+" LAST NODE's DATA");
        getKthLastNode(head,3);

    }

    private static void getKthLastNode(Node head,int K) {
        //print kth last node
        Node slow=head;
        Node fast=head;

        for (int i=1;i<=K;i++){
            fast=fast.next;
        }

        while (fast!=null){
            slow=slow.next;
            fast=fast.next;
        }
        System.out.println(slow.data);
    }

    private static void printNodes(Node head) {

        while (head!=null){
            System.out.print(head.data+" ");
            head=head.next;
        }
        System.out.println();
    }
}
