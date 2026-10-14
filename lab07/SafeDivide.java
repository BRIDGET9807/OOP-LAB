import java.util.InputMismatchException;
import java.util.Scanner;

/** Exercise 1: read two ints and divide, handling bad input and divide by zero. */
public class SafeDivide {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            System.out.print("Enter numerator: ");
            int a = in.nextInt();
            System.out.print("Enter denominator: ");
            int b = in.nextInt();
            System.out.println(a + " / " + b + " = " + (a / b));
        } catch (InputMismatchException e) {
            System.out.println("That was not a whole number.");
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero.");
        }
    }
}

    

