import java.util.*;

/** Exercise 1: sum, max and reverse of 10 integers. */
public class ListStats {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(List.of(4, 9, 1, 7, 12, 3, 8, 15, 6, 2));
        int sum = 0;
        for (int n : nums) sum += n;
        System.out.println("List: " + nums);
        System.out.println("Sum: " + sum);
        System.out.println("Max: " + Collections.max(nums));
        Collections.reverse(nums);
        System.out.println("Reversed: " + nums);
    }
}

