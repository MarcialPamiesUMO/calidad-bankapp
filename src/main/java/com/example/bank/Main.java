package com.example.bank;

public class Main {

    // Regla java:S2068 (hardcoded credentials)
    private static final String dbPassword = "admin123";

    public static void main(String[] args) {
        BankService service = new BankService(new UserRepository());

        String userInput = args.length > 0 ? args[0] : "alice";
        service.findAndGreet(userInput);

        // Regla java:S1147 (System.exit)
        System.exit(0);
    }
}
