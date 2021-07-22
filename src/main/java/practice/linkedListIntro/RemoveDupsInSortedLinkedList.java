package practice.linkedListIntro;

public class RemoveDupsInSortedLinkedList {

    //remove duplicate elements from a sorted linked list

    public static void main(String[] args) {

        Node head=new Node(1);
        Node temp=head;
        for(int i=2;i<10;i++){
            Node node=new Node(i);
            temp.next=node;
            temp=node;
            if(i==3||i==5){
                Node node1=new Node(i);
                temp.next=node1;
                temp=node1;
            }
        }

        LinkedListUtils.printNodes(head);

        removeDuplicateNodes(head);

        System.out.println("Removed duplicate elements head");
        LinkedListUtils.printNodes(head);

    }

    private static void removeDuplicateNodes(Node head) {

        Node temp=head;

        while (temp!=null && temp.next!=null){

            if(temp.data==temp.next.data){
                temp.next=temp.next.next;
            }
            temp=temp.next;

        }
        System.out.println("Removed duplicate elements");
        LinkedListUtils.printNodes(head);
    }
}
