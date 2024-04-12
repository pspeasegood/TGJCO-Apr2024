import java.util.Random;

public class DiceRoll {
    private static final Random random = new Random();

    // Existing roll method
    public static int roll(int sides) {
        return random.nextInt(sides) + 1;
    }

    // Method to perform multiple dice rolls based on the input string
    public static int multiRoll(String dice) {
        // Validate the input format
        if(dice.startsWith("d")) {
            dice = "1" + dice;
        }
        if (!dice.matches("\\d+d\\d+")) {
            throw new IllegalArgumentException("Invalid dice format: " + dice);
        }

        // Split the input string into the number of dice and the number of sides
        String[] parts = dice.split("d");
        int numDice = Integer.parseInt(parts[0]);
        int sides = Integer.parseInt(parts[1]);

        // Perform the dice rolls and sum the results
        int total = 0;
        for (int i = 0; i < numDice; i++) {
            int rollResult = roll(sides);
            System.out.println("Roll: " + rollResult);
            total += rollResult;
        }

        return total;
    }
}
