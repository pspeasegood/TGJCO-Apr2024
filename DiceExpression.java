import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class evaluates dice expressions, such as "2d6 + 1d8 - 5", and calculates the result.
 * It supports addition, subtraction, and multiplication of dice rolls and numbers.
 */
public class DiceExpression {
    private String expression;

    /**
     * Constructs a new DiceExpression with the given expression.
     * Removes all whitespace from the expression for easier parsing.
     *
     * @param expression the dice expression to evaluate
     */
    public DiceExpression(String expression) {
        this.expression = expression.replaceAll("\\s", "");
    }

    /**
     * Evaluates the dice expression and prints the result.
     * Handles dice rolls (e.g., "2d6") and arithmetic operations (+, -, *).
     */
    public void evaluate() {
        int total = 0;
        // Pattern to match numbers, dice rolls, and arithmetic operations
        Pattern numberPattern = Pattern.compile("[+-\\\\*]?\\d*[Dd]?\\d+");

        Matcher matcher = numberPattern.matcher(expression);
        while (matcher.find()) {
            String match = matcher.group();
            // Determine the operation and apply it to the total
            if (match.startsWith("+")) {
                total += processMatch(match.substring(1));
            } else if (match.startsWith("-")) {
                total -= processMatch(match.substring(1));
            } else if (match.startsWith("*")) {
                total *= processMatch(match.substring(1));
            } else {
                total += processMatch(match);
            }
        }

        System.out.println("Result: " + total);
    }

    /**
     * Processes a match from the expression, handling dice rolls and numbers.
     *
     * @param match the part of the expression to process
     * @return the result of processing the match
     */
    private int processMatch(String match) {
        if (match.contains("d")) {
            return DiceRoll.multiRoll(match);
        } else {
            return Integer.parseInt(match);
        }
    }
}
