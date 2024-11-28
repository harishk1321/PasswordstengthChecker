import java.util.Scanner;

public class PasswordStrengthChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        
        String strength = checkPasswordStrength(password);
        System.out.println(strength);

        scanner.close();
    }

    public static String checkPasswordStrength(String password) {
        boolean lengthCriteria = password.length() >= 8;
        boolean uppercaseCriteria = password.matches(".*[A-Z].*");
        boolean lowercaseCriteria = password.matches(".*[a-z].*");
        boolean numberCriteria = password.matches(".*[0-9].*");
        boolean specialCharCriteria = password.matches(".*[@$!%*?&].*");

        int score = 0;
        if (lengthCriteria) score++;
        if (uppercaseCriteria) score++;
        if (lowercaseCriteria) score++;
        if (numberCriteria) score++;
        if (specialCharCriteria) score++;

        // Determine strength based on score
        switch (score) {
            case 5:
                return "Password Strength: Very Strong";
            case 4:
                return "Password Strength: Strong";
            case 3:
                return "Password Strength: Medium";
            case 2:
                return "Password Strength: Weak";
            default:
                return "Password Strength: Very Weak";
        }
    }
}
