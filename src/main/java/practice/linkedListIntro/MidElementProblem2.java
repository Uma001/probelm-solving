package practice.linkedListIntro;

public class MidElementProblem2 {
    public static void main(String[] args) {
        Node head=new Node(1,new Node(2,new Node(3,new Node(4,new Node(5,new Node(6,
        new Node(7,new Node(8))
        ))))));
        getMidOfLinkedList(head);

        Node head2=new Node(1,new Node(2,new Node(3,new Node(4,new Node(5)))));
        getMidOfLinkedList(head2);
    }

    private static void getMidOfLinkedList(Node head) {
        Node slow=head;
        Node fast=head;

        while (fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }

        System.out.println(slow.data);


    }
}
