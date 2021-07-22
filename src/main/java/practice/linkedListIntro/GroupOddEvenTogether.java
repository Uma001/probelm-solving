package practice.linkedListIntro;

public class GroupOddEvenTogether {
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

        //update the same linked list such than odd elements are grouped 1st then even elements
        //relative order should be maintained 1 2 3 4 5 6 7-> 1 3 5 7 2 4 6
    }
}
