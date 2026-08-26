package bank;
public class Account {
    private String accountNumber;
    private String holderName;
    private double balance;
    public Account(String accNum, String name, double initialBalance) {
        accountNumber = accNum;
        holderName = name;
        balance = initialBalance;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited " + amount + " into account " + accountNumber);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew " + amount + " from account " + accountNumber);
        } else {
            System.out.println("Insufficient balance or invalid amount for account " + accountNumber);
        }
    }
    public void checkBalance() {
        System.out.println("Account: " + accountNumber + " | Holder: " + holderName + " | Balance: " + balance);
    }
}