import java.util.Scanner;

public class Task_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter expression:");
        final double res = evaluateExpression(scanner.nextLine());
        System.out.println("Result: " + res);
        scanner.close();  // Закриваємо сканер
    }

    private static double evaluateExpression(final String expression) {
        if (expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException("Expression cannot be null or empty.");
        }

        // Прибрано зайве екранування
        String[] parts = expression.replaceAll("[=?]", "").trim().split(" ");

        if (parts.length < 3) {
            throw new IllegalArgumentException("Invalid expression format. Use format '<number> <operator> <number>'.");
        }

        final double num1;
        final double num2;
        try {
            num1 = Double.parseDouble(parts[0]);
            num2 = Double.parseDouble(parts[2]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid numbers in expression.");
        }

        String operator = parts[1];

        // Заміна yield на return, якщо використовуєш старішу версію JDK
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 == 0) {
                    throw new ArithmeticException("Division by zero.");
                }
                return num1 / num2;
            default:
                throw new IllegalArgumentException("There is no operation like: " + operator);
        }
    }
}
