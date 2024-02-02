package someCoreTasks.turnAround;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] myArray = {4, 5, 8, 9, 10, 15};
        reverse(myArray);
        System.out.println(Arrays.toString(myArray));
    }

    public static void reverse(int[] numbersArray) {
        for (int i = 0; i < numbersArray.length / 2; i++) {
            int temp = numbersArray[i];
            numbersArray[i] = numbersArray[numbersArray.length - i - 1];
            numbersArray[numbersArray.length - i - 1] = temp;
        }
    }
}
