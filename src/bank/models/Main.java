package bank;
import bank.services.BankService;
import bank.utils.InputUtil;
public class Main {
    public static void main(String[] args) {
        BankService bank = new BankService();
        while (true) {
            System.out.println("\n--- MINI BANK ---");
            System.out.println("1. REGISTER");
            System.out.println("2. CREATE ACCOUNT (OnlineBank/More Bank)");
            System.out.println("3. DEPOSIT MONEY");
            System.out.println("4. Pay for transport (110 KZT)");
            System.out.println("5. CHECK BALANCE");
            System.out.println("0. EXIT");

            System.out.print("YOUR CHOISE: ");
            int choice = InputUtil.scanner.nextInt();
            InputUtil.scanner.nextLine();

            switch (choice) {
                case 1 -> bank.registerClient();
                case 2 -> bank.openAccount();
                case 3 -> bank.addMoney();
                case 4 -> bank.payTransport();
                case 5 -> bank.showBalance();
                case 0 -> {
                    System.out.println("👋 The program has been closed.");
                    System.exit(0);
                }
                default -> System.out.println("❌ FALSE!");
            }
        }
    }
}
