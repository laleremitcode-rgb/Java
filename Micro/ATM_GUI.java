import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

class TransactionManager {
    private double balance = 5000.0;
    private ArrayList<String> transactionHistory = new ArrayList<>();

    public TransactionManager() {
        transactionHistory.add("Initial Balance: $5000.0");
    }

    public double getBalance() {
        return balance;
    }

    public void processDeposit(double amount) {
        balance += amount;
        transactionHistory.add("Deposited: +" + amount + " | New Balance: $" + balance);
    }

    public void processWithdrawal(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrew: -" + amount + " | Remaining Balance: $" + balance);
        }
    }

    public String getTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            return "No transactions recorded yet.";
        }
        StringBuilder sb = new StringBuilder("=== TRANSACTION HISTORY ===\n");
        for (String log : transactionHistory) {
            sb.append(log).append("\n");
        }
        return sb.toString();
    }
}

public class ATM_GUI {
    private static TransactionManager manager = new TransactionManager();

    public static void createGUI() {
        JFrame frame = new JFrame("ATM & Banking System");
        frame.setSize(550, 480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout(10, 10));

        JLabel title = new JLabel("ATM & BANKING MANAGEMENT SYSTEM", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        frame.add(title, BorderLayout.NORTH);

        JPanel buttons = new JPanel(new GridLayout(4, 2, 10, 10));

        JButton deposit = new JButton("Deposit");
        JButton withdraw = new JButton("Withdraw");
        JButton balance = new JButton("Check Balance");
        JButton interest = new JButton("Calculate Interest");
        JButton tax = new JButton("Calculate Tax");
        JButton account = new JButton("Account Details");
        JButton transactions = new JButton("Transaction Info");
        JButton exit = new JButton("Exit");

        buttons.add(deposit);
        buttons.add(withdraw);
        buttons.add(balance);
        buttons.add(interest);
        buttons.add(tax);
        buttons.add(account);
        buttons.add(transactions);
        buttons.add(exit);

        frame.add(buttons, BorderLayout.CENTER);

        JTextArea outputArea = new JTextArea(8, 40);
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        frame.add(new JScrollPane(outputArea), BorderLayout.SOUTH);

        // 1. Check Balance
        balance.addActionListener((ActionEvent e) -> {
            outputArea.setText("Current Account Balance: $" + manager.getBalance());
        });

        // 2. Deposit
        deposit.addActionListener((ActionEvent e) -> {
            String input = JOptionPane.showInputDialog(frame, "Enter deposit amount ($):");
            if (input != null) {
                try {
                    double amount = Double.parseDouble(input);
                    if (amount > 0) {
                        manager.processDeposit(amount);
                        outputArea.setText("SUCCESS: Deposited $" + amount + "\nUpdated Balance: $" + manager.getBalance());
                    } else {
                        outputArea.setText("ERROR: Amount must be greater than 0.");
                    }
                } catch (NumberFormatException ex) {
                    outputArea.setText("ERROR: Invalid number entered.");
                }
            }
        });

        // 3. Withdraw
        withdraw.addActionListener((ActionEvent e) -> {
            String input = JOptionPane.showInputDialog(frame, "Enter withdrawal amount ($):");
            if (input != null) {
                try {
                    double amount = Double.parseDouble(input);
                    if (amount <= 0) {
                        outputArea.setText("ERROR: Amount must be greater than 0.");
                    } else if (amount > manager.getBalance()) {
                        outputArea.setText("ERROR: Insufficient funds! Current balance is $" + manager.getBalance());
                    } else {
                        manager.processWithdrawal(amount);
                        outputArea.setText("SUCCESS: Withdrew $" + amount + "\nRemaining Balance: $" + manager.getBalance());
                    }
                } catch (NumberFormatException ex) {
                    outputArea.setText("ERROR: Invalid number entered.");
                }
            }
        });

        // 4. Calculate Interest
        interest.addActionListener((ActionEvent e) -> {
            double currentBal = manager.getBalance();
            double annualInterest = currentBal * 0.05; // 5% Interest
            outputArea.setText("=== ANNUAL INTEREST ESTIMATE ===\n" +
                               "Current Balance: $" + currentBal + "\n" +
                               "Estimated Annual Interest (5%): $" + annualInterest);
        });

        // 5. Calculate Tax
        tax.addActionListener((ActionEvent e) -> {
            double currentBal = manager.getBalance();
            double taxDeduction = currentBal * 0.10; // 10% Tax
            outputArea.setText("=== TAX DEDUCTION ESTIMATE ===\n" +
                               "Current Balance: $" + currentBal + "\n" +
                               "Estimated Tax Deduction (10%): $" + taxDeduction);
        });

        // 6. Account Details
        account.addActionListener((ActionEvent e) -> {
            outputArea.setText("=== ACCOUNT DETAILS ===\n" +
                               "Account Type: Savings Account\n" +
                               "Account Holder: Standard User\n" +
                               "Current Balance: $" + manager.getBalance());
        });

        // 7. Transaction Info (Shows Full History)
        transactions.addActionListener((ActionEvent e) -> {
            outputArea.setText(manager.getTransactionHistory());
        });

        // 8. Exit
        exit.addActionListener((ActionEvent e) -> System.exit(0));

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createGUI());
    }
}