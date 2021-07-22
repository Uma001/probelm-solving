package practice.pracs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ColorFulNum {

    public static int colorful(int A) {

        Set<Integer> product=new HashSet<>();

        ArrayList<Integer> digits=new ArrayList<>();
        while(A>0){
            System.out.println(A%10+" ");
            digits.add(A%10);
            A/=10;
        }

        int prefix;

        for(int i=0;i<digits.size()-1;i++){
            prefix=1;
            for(int j=i;j<digits.size();j++){
                prefix*=digits.get(j);
                if(product.contains(digits)){
                    return 0;
                }
                product.add(prefix);
            }
        }
        return 1;

    }

    public static void main(String[] args) {
        System.out.println(colorful(123));

    }
}
