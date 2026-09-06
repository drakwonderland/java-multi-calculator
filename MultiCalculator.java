import java.util.Scanner;

public class MultiCalculator {
    public static void main(String[] args) {
        String[] menu = {
                "0: Volume of a sphere",
                "1: Perimeter of a rectangle",
                "2: Circumference of a circle",
                "3: Dollar to Peso conversion (and vice versa)"
        };

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Welcome to Multi-Calculator!");
            for (String item : menu) {
                System.out.println(item);
            }

            System.out.print("Select operation (0-3): ");
            String op = scanner.nextLine().trim();

            switch (op) {
                case "0" -> {
                    System.out.println("\n[Volume of a Sphere]");
                    System.out.print("Enter radius: ");
                    double radius = scanner.nextDouble();
                    double volume = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
                    System.out.printf("The volume of the sphere is: %.4f%n", volume);
                }
                case "1" -> {
                    System.out.println("\n[Perimeter of a Rectangle]");
                    System.out.print("Enter length: ");
                    double length = scanner.nextDouble();
                    System.out.print("Enter width: ");
                    double width = scanner.nextDouble();
                    double perimeter = 2 * (length + width);
                    System.out.printf("The perimeter is: %.2f%n", perimeter);
                }
                case "2" -> {
                    System.out.println("\n[Circumference of a Circle]");
                    System.out.print("Enter radius: ");
                    double radius = scanner.nextDouble();
                    double circumference = 2 * Math.PI * radius;
                    System.out.printf("The circumference is: %.4f%n", circumference);
                }
                case "3" -> {
                    System.out.println("\n[Currency Conversion]");
                    System.out.println("a: USD to PHP");
                    System.out.println("b: PHP to USD");
                    System.out.print("Choose conversion direction (a/b): ");
                    String subChoice = scanner.next().trim().toLowerCase();

                    final double usdToPhpRate = 58.50;

                    if (subChoice.equals("a")) {
                        System.out.print("Enter amount in USD: ");
                        double usd = scanner.nextDouble();
                        System.out.printf("%.2f USD = %.2f PHP%n", usd, (usd * usdToPhpRate));
                    } else if (subChoice.equals("b")) {
                        System.out.print("Enter amount in PHP: ");
                        double php = scanner.nextDouble();
                        System.out.printf("%.2f PHP = %.2f USD%n", php, (php / usdToPhpRate));
                    } else {
                        System.out.println("Invalid currency choice.");
                    }
                }
                default -> System.out.println(
                        "Invalid operation selected. Please run the program again and select the options 0, 1, 2, or 3.");
            }
        }
    }
}