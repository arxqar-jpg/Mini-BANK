package bank.services;

import bank.models.Account;
import bank.models.Client;
import bank.utils.InputUtil;

public class  BankService {

    private Client client;
    private Account account;


    public void registerClient() {
        System.out.print("Name: ");
        String name = InputUtil.scanner.nextLine();

        System.out.print("Age: ");
        int age = InputUtil.scanner.nextInt();
        InputUtil.scanner.nextLine();

        System.out.print("Телефон: ");
        String phone = InputUtil.scanner.nextLine();

        client = new Client(name, age, phone);

        System.out.println("✅ Client registered!");
    }
    public void openAccount() {
        if (client == null) {
            System.out.println("❌ PLEASE REGISTER!");
            return;
        }
        System.out.println("1 - InvestBank");
        System.out.println("2 - More BANK");
        int choice = InputUtil.scanner.nextInt();
        InputUtil.scanner.nextLine();

        if (choice == 1) {
            account = new Account("InvestBank", 0);
        } else if (choice == 2) {
            account = new Account("More BANK", 0);
        } else {
            System.out.println("❌ False!");
            return;
        }
        System.out.println("✅ Account opened: " + account.getType());
    }

    public void addMoney() {
        if (account == null || client == null) {
            System.out.println("❌ Please register Account!");
            return;
        }

        System.out.print("Enter the amount: ");
        double amount = InputUtil.scanner.nextDouble();
        InputUtil.scanner.nextLine();

        account.addMoney(amount);

        System.out.println("💰 BALANCE: " + account.getBalance() + " тг");
    }
    public void payTransport() {
        if (account == null || client == null) {
            System.out.println("❌ PLEASE CREAD ACCOUNT!");
            return;
        }

        double price = 110;

        if (!account.withdraw(price)) {
            System.out.println("❌ Insufficient balance!");
            return;
        }

        printReceipt("Transport fee", price);
    }

    public void showBalance() {
        if (account == null) {
            System.out.println("❌ The account has not been opened!");
            return;
        }

        System.out.println("💰 YOUR BALANCE: " + account.getBalance() + " тг");
    }

    private void printReceipt(String serviceName, double amount) {
        System.out.println("\n====== CHECK ======");
        System.out.println("SERVICE: " + serviceName);
        System.out.println("CLIENT: " + client.getName());
        System.out.println("AMOUNT: " + amount + " тг");
        System.out.println("Date: " + java.time.LocalDateTime.now());
        System.out.println("Remaining amount: " + account.getBalance() + " тг");
        System.out.println("=================\n");
    }
}




