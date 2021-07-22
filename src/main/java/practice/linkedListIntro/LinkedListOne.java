package practice.linkedListIntro;

public class LinkedListOne {

    public static class Node{
        int data;
        Node next;
        Node(){
        }
        Node(int val){
            this.data=val;
        }
        Node(int val,Node next){
            this.data=val;
            this.next=next;
        }
    }
    public static void main(String[] args) {
        Node head=new Node(1,null);
        head.next=new Node(2,null);
        head.next.next=new Node(3,new Node(4));
//        print all elements
//        while (head!=null){
//            System.out.print(head.data+" ");
//            head=head.next;
//        }

        //get size of LinkedList
//        int size=0;
//        while (head!=null){
//            size++;
//            head=head.next;
//        }
//        System.out.println(size);

        //remove first
//        if(head!=null){
//            head=head.next;
//        }
//        while (head!=null){
//            System.out.print(head.data+" ");
//            head=head.next;
//        }

        //add at an index as in new node should come at index i now
        int atIndex=3;
        Node node=new Node(8);
        Node temp=head;
        for(int i=0;i<atIndex-1;i++){
            temp=temp.next;
        }
        node.next=temp.next;
        temp.next=node;
        display(head);

        //reverse pointer iterative
        System.out.println("Reversing the linked list::::");
        reverseLinkedList(head);
        display(head);


    }

    private static void reverseLinkedList(Node head) {
        Node prev=null;
        Node current=head;

        while (current!=null){
            Node temp=current.next;
            current.next=prev;
            prev=current;
            current=temp;
        }
        display(prev);
//        head=prev;
    }

    private static void display(Node head) {
//        Node temp=head;
        while (head!=null){
            System.out.print(head.data+" ");
            head=head.next;
        }
        System.out.println();
    }
}
