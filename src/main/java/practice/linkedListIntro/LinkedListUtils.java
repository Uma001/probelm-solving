package practice.linkedListIntro;

public class LinkedListUtils {

    public static void printNodes(Node head) {

        while (head!=null){
            System.out.print(head.data+" ");
            head=head.next;
        }
        System.out.println();
    }
}
