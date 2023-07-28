
import java.util.Scanner;

// Bank Account Class
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient funds or invalid withdrawal amount.");
        }
    }
}

// ATM Class
class ATM {
    private final BankAccount bankAccount;

    public ATM(BankAccount account) {
        bankAccount = account;
    }

    public void displayOptions() {
        System.out.println("Choose an option:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void performTransaction(int option, double amount) {
        switch (option) {
            case 1 -> bankAccount.withdraw(amount);
            case 2 -> bankAccount.deposit(amount);
            case 3 -> System.out.println("Account Balance: " + bankAccount.getBalance());
            case 4 -> {
                System.out.println("Thank you for using our ATM. Goodbye!");
                System.exit(0);
            }
            default -> System.out.println("Invalid option. Please try again.");
        }
    }
}

// Main Class
public class Atminterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a bank account with an initial balance of 1000
        BankAccount userAccount = new BankAccount(1000);

        // Create an ATM with the user's bank account
        ATM atm = new ATM(userAccount);
        while(true) {
            atm.displayOptions();
            System.out.print("Enter option (1-4): ");
            int option = scanner.nextInt();

            if (option == 4) {
                atm.performTransaction(option, 0);
            } else {
                System.out.print("Enter amount: ");
                double amount = scanner.nextDouble();
                atm.performTransaction(option, amount);
            }

            System.out.println();
        }
    }
}
