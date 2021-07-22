package practice.pracs;

class MyHashMap {

    public static void main(String[] args) {
        MyHashMap obj = new MyHashMap();
        obj.put(1,1);
        obj.put(2,1);
        System.out.println(obj.get(1));
        System.out.println(obj.get(2));
        obj.put(2,2);
        System.out.println(obj.get(2));
        obj.get(2);
        obj.get(3);
        obj.get(3);
        obj.get(3);
        obj.get(3);
    }
    class Node{
        int key;
        int value;
        Node next;
        Node(int key, int value){
            this.key=key;
            this.value=value;
            this.next=null;
        }
    }
    int capacity;
    Node bucket[];
    /** Initialize your data structure here. */
    public MyHashMap() {
        capacity=16;
        bucket=new Node[capacity];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index= getIndex(key);

        Node node=bucket[index];
        Node incomingNode=new Node(key,value);
        if(node==null){
            bucket[index]=incomingNode;
            return;
        }



        while(node.next!=null){
            if(node.key==key){
                node.value=value;
                return;
            }
            node=node.next;
        }

        if(node.key!=key){
            node.next=incomingNode;
        }else{
            node.value=value;
        }
        return;
    }

    public int getIndex(int key){
        return key%16;
    }
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index= getIndex(key);
        Node prevNode=bucket[index];

        if(prevNode==null){
            return -1;
        }
        if(key==prevNode.key){
            return prevNode.value;
        }

        Node currentNode=prevNode.next;

        while(currentNode!=null){
            if(currentNode.key==key){
                return currentNode.value;
            }
            currentNode=currentNode.next;
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index= getIndex(key);
        Node prev =bucket[index];
        if(prev==null){
            return;
        }
        if(key==prev.key){
            bucket[index]=prev.next;
        }

        Node current=prev.next;

        while(current.next!=null){
            if(key==current.key){
                prev.next=current.next;
                return;
            }
            prev=current;
            current=current.next;
        }



    }
}



/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
