import java.util.Scanner;

// BankAccount Class
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }
}

// ATM Class
class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        scanner = new Scanner(System.in);
    }

    public void start() {
        int option;

        System.out.println(" Welcome to the Java ATM!");

        do {
            displayMenu();
            option = getUserChoice();

            switch (option) {
                case 1 -> withdrawOption();
                case 2 -> depositOption();
                case 3 -> checkBalanceOption();
                case 4 -> System.out.println(" Thank you for using the ATM. Goodbye!");
                default -> System.out.println(" Invalid option. Please try again.");
            }
            System.out.println();

        } while (option != 4);
    }

    private void displayMenu() {
        System.out.println("==================================");
        System.out.println("1.Withdraw");
        System.out.println("2.Deposit");
        System.out.println("3.Check Balance");
        System.out.println("4.Exit");
        System.out.println("==================================");
        System.out.print("Please select an option: ");
    }

    private int getUserChoice() {
        while (!scanner.hasNextInt()) {
            System.out.print(" Invalid input. Enter a number: ");
            scanner.next(); // discard invalid input
        }
        return scanner.nextInt();
    }

    private void withdrawOption() {
        System.out.print(" Enter amount to withdraw: ₹");
        double amount = getValidAmount();
        if (account.withdraw(amount)) {
            System.out.println(" Withdrawal successful! New balance: ₹" + account.getBalance());
        } else {
            System.out.println(" Withdrawal failed! Insufficient balance or invalid amount.");
        }
    }

    private void depositOption() {
        System.out.print(" Enter amount to deposit: ");
        double amount = getValidAmount();
        if (account.deposit(amount)) {
            System.out.println(" Deposit successful! New balance: ₹" + account.getBalance());
        } else {
            System.out.println(" Deposit failed! Please enter a valid amount.");
        }
    }

    private void checkBalanceOption() {
        System.out.println("Your current balance is: ₹" + account.getBalance());
    }

    private double getValidAmount() {
        while (!scanner.hasNextDouble()) {
            System.out.print(" Invalid input. Enter a numeric amount: ");
            scanner.next(); // discard invalid input
        }
        return scanner.nextDouble();
    }
}

// Main Class
public class ATMInterface {
    public static void main(String[] args) {
        // Create a Bank Account with an initial balance
        BankAccount account = new BankAccount(10000.00);

        // Connect ATM with the bank account
        ATM atm = new ATM(account);

        // Start ATM session
        atm.start();
    }
}
