package Task_7;

public class Main {
    public static void main(String[] args) {
        bank bank1 = new bank("MonoBank");
        bank bank2 = new bank("OshchadBank 24");

        bank1.addExchangeRate("USD", 1.0);
        bank1.addExchangeRate("EUR", 0.9);
        bank2.addExchangeRate("USD", 1.0);
        bank2.addExchangeRate("EUR", 0.85);

        bankAccount account1 = new bankAccount("42341", bank1, "USD", "Carl"
                , 10000);
        bankAccount account2 = new bankAccount("78902", bank1, "EUR", "Alice"
                , 1500);
        bankAccount account3 = new bankAccount("92985", bank2, "USD", "Bob"
                , 700);

        account1.transferTo(account2, 350);

        account1.transferTo(account3, 135);
    }
}
