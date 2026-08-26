
import bank.Account;
public class Main {
    public static void main(String[] args) {
        Account acc1 = new Account("ACC101", "Alice", 1000);
        Account acc2 = new Account("ACC102", "Bob", 500);
        acc1.checkBalance();
        acc2.checkBalance();
        acc1.deposit(250);
        acc1.withdraw(100);
        acc2.withdraw(600);
        acc2.deposit(150);
        acc2.withdraw(200);
        acc1.checkBalance();
        acc2.checkBalance();
    }
}