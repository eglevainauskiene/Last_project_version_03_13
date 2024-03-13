import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       // int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        //boolean[] result = numEven(nums);
        Scanner scanner = new Scanner(System.in);

        int answer = new Random().nextInt(101);

        int guess;
        while(true){
            System.out.println("Įvesk bet kokį skaičių");
            guess = scanner.nextInt();
            if(guess==answer) {
                System.out.println("Atsakymas lygus spėjimui");
                break;
            }
            else if (guess>answer)
            {
                System.out.println("Atsakymas mažesnis nei spėjimas");

            }
            else
            {
                System.out.println("Atsakymas didesnis už spėjimą");
            }
          // if (guess.equals("quit")){
           //     break;
          //  }

        }
    }

   /* private static boolean[] numEven(int[] nums) {
        boolean[] evens = new boolean[nums.length];
        System.out.print("The even numbers in your array are: ");
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0)
                evens[i] = true;
            else{
                evens[i]=false;
            }
            System.out.println(evens[i]);
        }
            return evens;
    }*/


}
