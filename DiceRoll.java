import java.util.Random;

public class DiceRoll {
    private static final Random random = new Random();

    // Method to perform a single dice roll
    public static int roll(int sides) {
        return random.nextInt(sides) + 1;
    }

    // Method to perform multiple dice rolls based on the input string
    public static int multiRoll(String dice) throws IllegalArgumentException {
        // Validate the input format
        if (!dice.matches("\\d*d\\d+(!)?")) {
            throw new IllegalArgumentException("Invalid dice format: " + dice);
        }
        boolean explode = dice.endsWith("!");
        dice = dice.replaceAll("!","");
        // Split the input string into the number of dice & the number of sides
        String[] parts = dice.split("d");
        int numDice = parts[0].isEmpty() ? 1 : Integer.parseInt(parts[0]);
        int sides = Integer.parseInt(parts[1]);


        // Perform the dice rolls and sum the results
        int total = 0;
        for (int i = 0; i < numDice; i++) {
            int rollResult = roll(sides);
            System.out.println("Roll: " + rollResult);
            total += rollResult;
            // explode if maxResult and exploded is enabled
            while (explode && rollResult == sides) {
                rollResult = roll(sides);
                System.out.println("Explode: " + rollResult);
                total += rollResult;
            }
        }

        return total;
    }
}
