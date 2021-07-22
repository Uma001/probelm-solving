package practice.dsPrac.DyanmicConnectivity;

//slowest
//union goes through each element of the array so for 1 union time complexity n
//if u union then time complexity=n*n=n^2


public class QuickFind {

    int id[];

    QuickFind(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i; //every element is connected to itself
        }
    }

    boolean isConnected(int p, int q) {
        return id[p] == id[q];
    }

    void union(int p, int q) {  //copy 1st into 2nd
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++) {

            if (id[i] == qid) {
                id[i] = pid;
            }
        }

    }

    public static void main(String[] args) {
        QuickFind qf = new QuickFind(10);
        //define connections
        qf.union(5, 1);
        qf.union(2, 5);
        qf.union(5, 3);
        qf.union(4, 5);

        System.out.println(qf.isConnected(5, 1));
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.print(qf.id[i] + " ");
        }


    }
}
