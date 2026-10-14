/** Exercise 3: a checked exception. */
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) { super(message); }
}

public class AgeValidator {
    // Throws the checked exception for ages outside 0-120
    static void validateAge(int age) throws InvalidAgeException {
        if (age < 0 || age > 120) {
            throw new InvalidAgeException("Age " + age + " is outside 0-120");
        }
        System.out.println("Age " + age + " is valid");
    }

    public static void main(String[] args) {
        for (int age : new int[]{25, -3, 150}) {
            try {
                validateAge(age);
            } catch (InvalidAgeException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
