import java.util.Scanner;

public class MultiCalculator {

    // ── Constants ──────────────────────────────────────────────────────────────
    private static final String[] MENU = {
            "0: Volume of a sphere",
            "1: Perimeter of a rectangle",
            "2: Circumference of a circle",
            "3: Dollar to Peso conversion (and vice versa)"
    };

    // ── Entry point ────────────────────────────────────────────────────────────
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Welcome to Multi-Calculator!");

            boolean continueRunning = true;
            while (continueRunning) {
                printMenu();
                System.out.print("Select operation (0-3): ");
                String op = scanner.nextLine().trim();

                switch (op) {
                    case "0" -> sphereVolume(scanner);
                    case "1" -> rectanglePerimeter(scanner);
                    case "2" -> circleCircumference(scanner);
                    case "3" -> currencyConversion(scanner);
                    default -> System.out.println(
                            "Invalid selection. Please choose 0, 1, 2, or 3.");
                }

                System.out.println();
                continueRunning = askToContinue(scanner);
            }

            System.out.println("Thank you for using Multi-Calculator! Goodbye.");
        }
    }

    // ── Menu ───────────────────────────────────────────────────────────────────
    private static void printMenu() {
        System.out.println();
        System.out.println("──── Operations ────");
        System.out.println(String.join("\n", MENU));
        System.out.println("────────────────────");
    }

    // ── Operation: Volume of a Sphere ──────────────────────────────────────────
    private static void sphereVolume(Scanner scanner) {
        System.out.println("\n[Volume of a Sphere]");
        double radius = readPositiveDouble(scanner, "Enter radius: ");
        double volume = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
        System.out.printf("Volume = %.4f cubic units%n", volume);
    }

    // ── Operation: Perimeter of a Rectangle ───────────────────────────────────
    private static void rectanglePerimeter(Scanner scanner) {
        System.out.println("\n[Perimeter of a Rectangle]");
        double length = readPositiveDouble(scanner, "Enter length: ");
        double width = readPositiveDouble(scanner, "Enter width:  ");
        double perimeter = 2 * (length + width);
        System.out.printf("Perimeter = %.4f units%n", perimeter);
    }

    // ── Operation: Circumference of a Circle ───────────────────────────────────
    private static void circleCircumference(Scanner scanner) {
        System.out.println("\n[Circumference of a Circle]");
        double radius = readPositiveDouble(scanner, "Enter radius: ");
        double circumference = 2 * Math.PI * radius;
        System.out.printf("Circumference = %.4f units%n", circumference);
    }

    // ── Operation: Currency Conversion ─────────────────────────────────────────
    private static void currencyConversion(Scanner scanner) {
        System.out.println("\n[Currency Conversion]");

        double rate = readPositiveDouble(scanner, "Enter current USD to PHP exchange rate: ");

        System.out.println("  a: USD to PHP");
        System.out.println("  b: PHP to USD");
        System.out.print("Choose direction (a/b): ");
        String direction = scanner.nextLine().trim().toLowerCase();

        switch (direction) {
            case "a" -> {
                double usd = readPositiveDouble(scanner, "Enter amount in USD: ");
                System.out.printf("%.2f USD = %.2f PHP  (rate: %.2f)%n",
                        usd, usd * rate, rate);
            }
            case "b" -> {
                double php = readPositiveDouble(scanner, "Enter amount in PHP: ");
                System.out.printf("%.2f PHP = %.2f USD  (rate: %.2f)%n",
                        php, php / rate, rate);
            }
            default -> System.out.println("Invalid choice. Please enter 'a' or 'b'.");
        }
    }

    // ── Helpers ────────────────────────────────────────────────────────────────

    /**
     * Repeatedly prompts the user until a valid positive number is entered.
     * Uses nextLine() exclusively to avoid Scanner newline issues.
     *
     * @param scanner the shared Scanner instance
     * @param prompt  the message shown before each input attempt
     * @return a positive double value
     */
    private static double readPositiveDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                double value = Double.parseDouble(input);
                if (value <= 0) {
                    System.out.println("  Value must be greater than zero. Please try again.");
                } else {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.println("  \"" + input + "\" is not a valid number. Please try again.");
            }
        }
    }

    /**
     * Asks the user whether they want to run another calculation.
     *
     * @param scanner the shared Scanner instance
     * @return true if the user wants to continue, false otherwise
     */
    private static boolean askToContinue(Scanner scanner) {
        while (true) {
            System.out.print("Perform another calculation? (y/n): ");
            String answer = scanner.nextLine().trim().toLowerCase();
            if (answer.equals("y"))
                return true;
            if (answer.equals("n"))
                return false;
            System.out.println("  Please enter 'y' or 'n'.");
        }
    }
}