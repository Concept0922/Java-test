package Task_6;

import java.util.HashMap;
import java.util.Map;

public class converter {
    private final Map<String, current> currencies = new HashMap<>();

    public converter() {
        currencies.put("UAH", new current("UAH", 1.0));
        currencies.put("USD", new current("USD", 41.3));
        currencies.put("CAD", new current("CAD", 30.22));
        currencies.put("EUR", new current("EUR", 45.52));
    }

    public double convertCurrency(final String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Invalid input format.");
        }

        String[] parts = input.split(" ");
        if (parts.length != 4 || !parts[2].equalsIgnoreCase("into")) {
            throw new IllegalArgumentException("Invalid format. Use format '100 UAH into USD'.");
        }

        final double amount;
        try {
            amount = Double.parseDouble(parts[0]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("The first part must be a number.");
        }

        final String fromCurrencyString = parts[1].toUpperCase();
        final String toCurrencyCodeString = parts[3].toUpperCase();

        current fromCurrency = currencies.get(fromCurrencyString);
        current toCurrency = currencies.get(toCurrencyCodeString);

        if (fromCurrency == null || toCurrency == null) {
            throw new IllegalArgumentException("Unknown currency: " + fromCurrencyString + " or " + toCurrencyCodeString);
        }

        final double amountInUAH = fromCurrency.convertToUAH(amount);
        return toCurrency.convertFromUAH(amountInUAH);
    }

}
