package practice.dsPrac.DyanmicConnectivity;

//a[i] is parent of i
//root of i is id[id[id[id[i]]]]
public class QuickWeighedUnion {
    private int id[];
    private int size[];

    QuickWeighedUnion(int n) {
        id = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i; //initially each element is parent of itself
        }
    }

    private int root(int i) {
        while (i != id[i]) {
            i = id[i];
        }
        return i;
    }

    private boolean isConnected(int p, int q) {

        return root(p) == root(q); //two elements are connected if they are from the same root
    }

    private void union(int p, int q) {

        //make first element child of the 2nd one
        // q
        // |
        // p
        int i = root(q);
        int j = root(p);
//        id[j] = i;
        if(i==j){
            return;
        }
        if (size[i] < size[j]) {
            id[i] = j;
            size[j]=size[j]+size[i];
        }else {
            id[j]=i;
            size[i]=size[i]+size[j];
        }
    }


}
