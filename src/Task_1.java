public class Task_1 {
    public static void binar(int a){
        int b;
        String temp = "";
        while(a !=0){
            b = a%2;
            temp = b + temp;
            a = a/2;
        } System.out.print(temp);
    }
    public static void main(String [] args) {
        binar(8);
    }
}
