import java.util.Scanner;

public class DiceRoller {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        do {
            input = getDiceExpression(scanner);
            if (!input.equalsIgnoreCase("exit")) {
                DiceExpression expression = new DiceExpression(input);
                expression.evaluate();
            }
        } while (!input.equalsIgnoreCase("exit"));
    }

    public static String getDiceExpression(Scanner scanner) {
        System.out.print("Enter a dice roll expression (e.g., 2d6!): ");
        String expression = scanner.nextLine();
        // Check for exit command before validating the input
        if (expression.equalsIgnoreCase("exit")) {
            return "exit";
        }
        if (!expression.matches("(\\d*d\\d+(!)?|\\d+)(\\s*[+\\-*/]\\s*(\\d*d\\d+(!)?|\\d+))*")) {
            System.out.println("Error! Invalid dice format. Try again.");
            return getDiceExpression(scanner); // Recursively call to get a valid input
        }
        return expression;
    }
}
