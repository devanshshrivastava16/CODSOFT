import java.util.Scanner;

class BankAccount {
    private double balance;
    private String Acnumber;

    public BankAccount(String accNumber, double initialBalance) {
        this.Acnumber = Acnumber;
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public String getAcnumber() {
        return Acnumber;
    }
}

class ATM {
    private BankAccount userAccount;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.userAccount = account;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("\n=== Welcome to ATM ===");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
        System.out.print("Choose an option (1-4): ");
    }

    public void processUserChoice(int choice) {
        switch (choice) {
            case 1:
                checkBalance();
                break;
            case 2:
                handleDeposit();
                break;
            case 3:
                handleWithdrawal();
                break;
            case 4:
                System.out.println("Thank you for using ATM. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    private void checkBalance() {
        System.out.println("\n=== Balance Information ===");
        System.out.println("Account Number: " + userAccount.getAcnumber());
        System.out.printf("Current Balance: $%.2f%n", userAccount.getBalance());
    }

    private void handleDeposit() {
        System.out.println("\n=== Deposit Money ===");
        System.out.print("Enter amount to deposit: $");
        try {
            double amount = scanner.nextDouble();
            if (amount <= 0) {
                System.out.println("Error: Amount must be positive.");
                return;
            }

            if (userAccount.deposit(amount)) {
                System.out.printf("Successfully deposited $%.2f%n", amount);
                System.out.printf("New balance: $%.2f%n", userAccount.getBalance());
            } else {
                System.out.println("Error: Deposit failed. Please try again.");
            }
        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please enter a valid number.");
            scanner.nextLine(); // Clear scanner buffer
        }
    }

    private void handleWithdrawal() {
        System.out.println("\n=== Withdraw Money ===");
        System.out.print("Enter amount to withdraw: $");
        try {
            double amount = scanner.nextDouble();
            if (amount <= 0) {
                System.out.println("Error: Amount must be positive.");
                return;
            }

            if (amount > userAccount.getBalance()) {
                System.out.println("Error: Insufficient funds.");
                System.out.printf("Current balance: $%.2f%n", userAccount.getBalance());
                return;
            }

            if (userAccount.withdraw(amount)) {
                System.out.printf("Successfully withdrew $%.2f%n", amount);
                System.out.printf("Remaining balance: $%.2f%n", userAccount.getBalance());
            } else {
                System.out.println("Error: Withdrawal failed. Please try again.");
            }
        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please enter a valid number.");
            scanner.nextLine();
        }
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a bank account with initial balance
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Account Number ");
        String Acno=scanner.nextLine();
        System.out.println("Enter Initial Balance ");
        Double ibal=scanner.nextDouble();
        BankAccount account = new BankAccount(Acno, ibal);
        ATM atm = new ATM(account);

        while (true) {
            atm.displayMenu();
            try {
                int choice = scanner.nextInt();
                atm.processUserChoice(choice);
            } catch (Exception e) {
                System.out.println("Error: Invalid input. Please enter a number between 1-4.");
                scanner.nextLine(); // Clear scanner buffer
            }
        }
    }
}
