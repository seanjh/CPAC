import java.text.DecimalFormat;
import java.util.ArrayList;

public class Account {
    private int id;
    private double balance;
    private double annualInterestRate;
    private java.util.Date dateCreated;
    private String name;
    private ArrayList<Transaction> transactions = new ArrayList<Transaction>();

    /* Default no-arg constructor */
    public Account() {
        this(0, 0.0, "Unknown name"); // Invole the 2-param constructor
    }

    /*  Constructor */
    public Account(int id, double balance, String name) {
        setID(id);
        setBalance(balance);
        setName(name); 
        annualInterestRate = 0;
        dateCreated = new java.util.Date();
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double rate) {
        annualInterestRate = rate / 100.0; // e.g. 5% = 5 / 100 = 0.05
    }

    public java.util.Date getDateCreated() {
        return dateCreated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMonthlyInterestRate() {
        return annualInterestRate / 12;
    }

    public double getMonthlyInterest() {
        return balance * getMonthlyInterestRate();
    }

    public void withdraw(double amount) {
        balance -= amount;
        transactions.add(new Transaction('W', amount, balance, "Withdraw"));
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add(new Transaction('D', amount, balance, "Deposit"));
    }

    @Override public String toString() {
        StringBuilder output = new StringBuilder();

        output.append(this.getClass().getName() + " Object {\n");
        output.append(" ID: " + id + "\n");
        DecimalFormat formatter = new DecimalFormat("$###,###.###");
        output.append(" Balance: " + formatter.format(balance) + "\n");
        formatter.applyPattern("###,###.###%");
        output.append(" APR: " + formatter.format(annualInterestRate) + "\n");
        output.append(" Created: " + dateCreated + "\n");
        output.append(" Transactions: \n");

        for (int i = 0; i < transactions.size(); i++) {
            output.append("\t#" + i + ": " + transactions.get(i).toString());
        }

        output.append("}");

        return output.toString();
    }
}
