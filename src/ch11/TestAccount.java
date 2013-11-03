import java.text.DecimalFormat;

public class TestAccount {
    public static void main(String[] args) {
        Account a = new Account(1, 500, "");
        System.out.println(a);
       
        DecimalFormat percentFormat = new DecimalFormat("###,###.00%");
        double apr = 5.5;
        System.out.println("Changing APR to " + percentFormat.format(apr));
        a.setAnnualInterestRate(5.5);
        System.out.println(a);

        DecimalFormat moneyFormat = new DecimalFormat("$###,###.00");
        double amount = 200.50;
        System.out.println("Withdrawing " + moneyFormat.format(amount));
        a.withdraw(amount);
        System.out.println(a);

        System.out.println("Montly Interest Rate: " + percentFormat.format(a.getMonthlyInterestRate()));
        System.out.println("Monthly Interest: " + moneyFormat.format(a.getMonthlyInterest()));

    }
}
