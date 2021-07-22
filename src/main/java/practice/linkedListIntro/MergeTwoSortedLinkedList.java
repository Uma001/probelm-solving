package practice.linkedListIntro;

import java.util.LinkedList;

import static com.linkedListIntro.LinkedListUtils.printNodes;

public class MergeTwoSortedLinkedList {

    public static void main(String[] args) {

        Node head=new Node(1);
        Node temp=head;
        for(int i=2;i<7;i++){
            Node node=new Node(i);
            temp.next=node;
            temp=node;
        }
        System.out.println("PRINT 1st LIST");
        printNodes(head);

        Node head2=new Node(1);
        Node temp2=head2;
        for(int i=4;i<9;i++){
            Node node=new Node(i);
            temp2.next=node;
            temp2=node;
        }
        System.out.println("PRINT 2nd LIST");
        printNodes(head2);

        System.out.println("MERGED BOTH LISTS INTO ONE");
        mergeLists(head,head2);

    }

    private static void mergeLists(Node head1, Node head2) {
        LinkedList<Integer> result = new LinkedList<>();
        Node one=head1;
        Node two=head2;

        while (one!=null && two!=null){
            if(one.data<=two.data){
                result.add(one.data);
                one=one.next;
            }else {
                result.add(two.data);
                two=two.next;
            }
        }

        while (two!=null){
            result.add(two.data);
            two=two.next;
        }
        while (one!=null){
            result.add(one.data);
            one=one.next;
        }

        for (int i=0;i<result.size();i++){
            System.out.print(result.get(i)+" ");
        }

    }
}
