import java.util.Arrays;
public class Task_3 {
    public static void main(String[] args) {
        String [] arr = new String[100];
        for(int i = 1; i<arr.length; i++){
            if(i% 3==0 && i%5==0){
                arr[i-1]="FizzBuzz";
            }
            else if(i%3==0){
                arr[i-1]="Fizz";
            }else if(i%5==0){
                arr[i-1] = "Buzz";
            }
            else{
                arr[i-1] = String.valueOf(i);
            }
        }
        for (String s : arr) {
            System.out.println(s);
        }
    }
}
