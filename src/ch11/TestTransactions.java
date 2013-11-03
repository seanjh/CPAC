public class TestTransactions {
    public static void main(String[] args) {

        // Create the new account
        Account a = new Account(1221, 1000, "George");
        a.setAnnualInterestRate(1.5);
        System.out.println(a);

        a.deposit(30);
        a.deposit(40);
        a.deposit(50);

        a.withdraw(5);
        a.withdraw(4);
        a.withdraw(2);

        System.out.println(a);
    }
}    
