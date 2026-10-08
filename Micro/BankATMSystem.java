import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
class InterestCalculator {
    public double calculateSimpleInterest(double principal, double rate, double timeYears) {
        return (principal * rate * timeYears) / 100;
    }
    public double calculateTaxDeduction(double amount, double taxPercentage) {
        return (amount * taxPercentage) / 100;
    }
}
class AccountPlan {
    private String planName;
    private double minBalance;
    public AccountPlan() {
        planName = "Standard Savings";
        minBalance = 1000.0;
    }
    public AccountPlan(String nameInput) {
        planName = nameInput;
        minBalance = 1000.0;
    }
    public AccountPlan(String nameInput, double balanceInput) {
        planName = nameInput;
        minBalance = balanceInput;
    }
    public void displayPlan() {
        System.out.println("Plan: " + planName + " | Min Balance Required: $" + minBalance);
    }
}
class Customer {
    protected String name;
    public Customer(String customerName) {
        name = customerName;
    }
}
class BankAccount extends Customer {
    protected int accountNumber;
    public BankAccount(String customerName, int accNum) {
        super(customerName);
        accountNumber = accNum;
    }
    public void showAccountDetails() {
        System.out.println("Account No: " + accountNumber + " | Customer: " + name);
    }
}
class SavingsAccount extends BankAccount {
    private double balance;
    public SavingsAccount(String customerName, int accNum, double initialBalance) {
        super(customerName, accNum);
        balance = initialBalance;
    }
    public double getBalance() {
        return balance;
    }
    public void showSavingsDetails() {
        showAccountDetails();
        System.out.println("Current Account Balance: $" + balance);
    }
}
interface DepositService {
    void processDeposit(double amount);
}
interface WithdrawService {
    void processWithdrawal(double amount);
}
class TransactionManager implements DepositService, WithdrawService {
    private double balance = 5000.0;
    public void processDeposit(double amount) {
        balance += amount;
        System.out.println("Deposited $" + amount + " | New Balance: $" + balance);
    }
    public void processWithdrawal(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew $" + amount + " | Remaining Balance: $" + balance);
        } else {
            System.out.println("Transaction Failed: Insufficient funds.");
        }
    }
}
@FunctionalInterface
interface TransferFeeCalculator {
    double calculateFee(double transferAmount);
}
public class BankATMSystem {
    public static void validatePIN(int pin) throws Exception {
        if (pin != 4321) {
            throw new Exception("Authentication Failure! Incorrect ATM PIN.");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== ATM & BANKING MANAGEMENT SYSTEM ===");
        System.out.print("Enter 4-digit ATM PIN: ");
        int pin = scanner.nextInt();
        try {
            validatePIN(pin);
            System.out.println("PIN Verified Successfully!\n");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Continuing in Limited Guest Session...\n");
        } finally {
            System.out.println("Security verification complete.\n");
        }
        try {
            int[] recentTransactions = {100, 250, 500};
            System.out.println("Accessing invalid transaction record: " + recentTransactions[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array Exception Caught: " + e.getMessage());
        }
        try {
            int zeroDivide = 500 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception Caught: Cannot divide by zero.");
        }
        LocalDateTime sessionTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println("\nATM Session Timestamp: " + sessionTime.format(formatter));
        System.out.println("\n--- Basic Account Transactions ---");
        System.out.print("Enter primary deposit amount: ");
        double d1 = scanner.nextDouble();
        System.out.print("Enter secondary deposit amount: ");
        double d2 = scanner.nextDouble();
        double totalDeposit = d1 + d2;
        System.out.println("Total Funds Deposited: $" + totalDeposit);
        if (d1 >= 100 && d2 >= 100) {
            System.out.println("Status: Both deposits qualify for bonus interest.");
        } else {
            System.out.println("Status: Regular deposit rate applied.");
        }
        System.out.println("\nSelect ATM Service:");
        System.out.println("1. Check Annual Interest");
        System.out.println("2. Estimate Tax Deductions");
        System.out.print("Choice: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> System.out.println("Estimated Annual Interest (5%): $" + (totalDeposit * 0.05));
            case 2 -> System.out.println("Estimated Tax Deduction (10%): $" + (totalDeposit * 0.10));
            default -> System.out.println("Invalid Option");
        }
        scanner.nextLine();
        System.out.println("\n--- String Operations on Account Holder Name ---");
        System.out.print("Enter Account Holder Name: ");
        String holderName = scanner.nextLine();
        String reversedName = new StringBuilder(holderName).reverse().toString();
        System.out.println("Reversed Name Tag: " + reversedName);
        if (holderName.equalsIgnoreCase(reversedName)) {
            System.out.println("The holder name IS a Palindrome.");
        } else {
            System.out.println("The holder name IS NOT a Palindrome.");
        }
        int vowelCount = 0;
        for (char c : holderName.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(c) != -1) {
                vowelCount++;
            }
        }
        System.out.println("Total Characters in Name: " + holderName.length());
        System.out.println("Total Vowels in Name: " + vowelCount);
        System.out.println("\n--- Wrapper Class Conversions ---");
        int primitiveAccNo = 98765;
        Integer wrappedAccNo = Integer.valueOf(primitiveAccNo);
        int unboxedAccNo = wrappedAccNo.intValue();
        System.out.println("Autoboxed Object: " + wrappedAccNo + " | Unboxed Primitive: " + unboxedAccNo);
        System.out.println("\n--- Constructors & Inheritance Demo ---");
        AccountPlan plan1 = new AccountPlan();
        AccountPlan plan2 = new AccountPlan("Premium Gold", 5000.0);
        plan1.displayPlan();
        plan2.displayPlan();
        SavingsAccount account = new SavingsAccount(holderName, wrappedAccNo, totalDeposit);
        account.showSavingsDetails();
        TransactionManager manager = new TransactionManager();
        manager.processDeposit(200.0);
        manager.processWithdrawal(150.0);
        InterestCalculator calc = new InterestCalculator();
        System.out.println("Simple Interest (3 Years @ 4%): $" + calc.calculateSimpleInterest(totalDeposit, 4.0, 3.0));
        System.out.println("\n--- Lambdas & Built-in Functional Interfaces ---");
        TransferFeeCalculator feeCalc = amount -> amount * 0.02;
        System.out.println("Wire Transfer Fee ($1000): $" + feeCalc.calculateFee(1000.0));
        Consumer<String> notifyUser = msg -> System.out.println("SMS Alert: " + msg);
        Predicate<Double> isHighBalance = bal -> bal >= 10000.0;
        Function<Double, Double> applyBonus = bal -> bal + 50.0;
        Supplier<String> branchSupplier = () -> "Downtown Pune Branch";
        notifyUser.accept("Your balance has been updated.");
        System.out.println("Is Premium Tier? " + isHighBalance.test(account.getBalance()));
        System.out.println("Balance after Signup Bonus: $" + applyBonus.apply(account.getBalance()));
        System.out.println("Assigned Bank Branch: " + branchSupplier.get());
        System.out.println("\n--- Multithreading Operations ---");
        Thread oddThread = new Thread(() -> {
            for (int i = 1; i <= 10; i += 2) {
                System.out.println("ATM Terminal A (Odd ID): " + i);
            }
        });
        Thread evenThread = new Thread(() -> {
            for (int i = 2; i <= 10; i += 2) {
                System.out.println("ATM Terminal B (Even ID): " + i);
            }
        });
        Thread cashDispenserThread = new Thread(() -> {
            for (int i = 3; i >= 1; i--) {
                System.out.println("Dispensing Cash Count: " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ignored) {}
            }
        });
        oddThread.start();
        evenThread.start();
        cashDispenserThread.start();
        try {
            oddThread.join();
            evenThread.join();
            cashDispenserThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("\n--- Card Number Digit Processing ---");
        int cardPinCode = 87654;
        int temp = cardPinCode, rev = 0, sum = 0;
        while (temp > 0) {
            int digit = temp % 10;
            rev = rev * 10 + digit;
            sum += digit;
            temp /= 10;
        }
        System.out.println("Original Code: " + cardPinCode + " | Reversed Code: " + rev + " | Sum of Digits: " + sum);
        scanner.close();
    }
}
