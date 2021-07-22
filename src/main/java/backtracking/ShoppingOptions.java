package backtracking;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
*
* The customer must buy shoes for 4 dollars since there is only one option. This leaves 6 dollars to spend on the other 3 items. Combination of prices paid for jeans, skirts, and tops respectively that add up to 6 dollars or fewer [2,2,2], [2,2,1], [3,2,1], [2,3,1].
* There are 4 ways the customer can purchase all 4 items.
Functional Description
Complete the getNumberOfOptions function in the editor below. The function must return an integer that represents the number of options present to buy the four items. getNumberOfOptions has 5 parameters:
List<Integer> priceOfJeans : An integer array list that contains the price of the pairs of jeans available.
List<Integer> priceOfShoes: An integer array list that contains the price of the pairs of shoes available.
List<Integer> priceOfSkirts: An integer array list that contains the price of the skirts available.
List<Integer> priceOfTops : An integer array list that contains the price of the tops available.
*
* */
public class ShoppingOptions {
    private  static int totalWays=0;

    public static void getNumberOfOptions(int dollars, int moneySpent, int pos, List<List<Integer>> products)
    {
        if(moneySpent>dollars){
            return ;
        }
        if(moneySpent<=dollars && pos==products.size()-1){
            totalWays++;
            System.out.println(totalWays);
            return;
        }
        if(pos==products.size()-1){
            return;
        }
        List<Integer> currProduct = products.get(pos);
        for (int num: currProduct){
            moneySpent+=num;
            getNumberOfOptions(dollars,moneySpent,pos+1,products);
            moneySpent-=num;
        }
    }

    public static void main(String[] args) {
        totalWays=0;
        List<List<Integer>> products= new ArrayList<>();
        products.add(Arrays.asList(2,3));
        products.add(Arrays.asList(4));
        products.add(Arrays.asList(2,3));
        products.add(Arrays.asList(1,2));

        getNumberOfOptions(10,0,0,products);
    }
}
