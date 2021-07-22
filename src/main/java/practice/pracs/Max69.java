package practice.pracs;

public class Max69 {

    public static int maximum69Number (int num) {

        // return Integer.valueOf(String.valueOf(num).replaceFirst("6","9"));

        int temp=num;
        int sixIndex=-1;
        int i=0;
        while(temp>0){

            if(temp%10==6){
                sixIndex=i;
            }
            temp=temp/10;
            i++;
        }
        System.out.println(sixIndex);

        return sixIndex==-1 ? num: num+(3*(int)Math.pow(10,sixIndex));

    }

    public static void main(String[] args) {
        maximum69Number(9669);
    }

}
