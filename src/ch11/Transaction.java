public class Transaction {
    private java.util.Date date;
    private char type;
    private double amount;
    private double balance;
    private String description;

    public Transaction() {
        this('W', 0, 0, "Empty transaction");
    }
    
    public Transaction(char type, double amount, double balance, String description) {
        setType(type);
        setAmount(amount);
        setBalance(balance);
        this.description = description;
        date = new java.util.Date();
    }

    public char getType() {
        return type;
    }

    private void setType(char type) {
        switch (type) {
            case('W'): this.type = type; break;
            case('D'): this.type = type; break;
            default: System.out.println("ERROR: Bad transaction type. Defaulting to 'W'.");
                     this.type = 'W'; break;
        }
    }

    public double getAmount() {
        return amount;
    }

    private void setAmount(double amount) {
        // Switch negative amount values to positive
        if (amount >= 0) {
            this.amount = amount;
        } else {
            this.amount = -1 * amount;
        }
    }

    public double getBalance() {
        return balance;
    }

    private void setBalance(double balance) {
        if (balance < 0) {
            System.out.println("ERROR: Balance is less than 0!. Defaulting to 0");
            this.balance = 0;
        } else {
            this.balance = balance;
        }
    }

    @Override public String toString() {
        java.text.DecimalFormat moneyForm = new java.text.DecimalFormat("$###,##0.00");
        StringBuilder output = new StringBuilder();

        output.append(this.getClass().getName() + " " + description);
        output.append(" ("+ date + ") ");
        output.append(" Amount: " + moneyForm.format(amount));
        output.append(" Balance: " + moneyForm.format(balance) + "\n");

        return output.toString();
    }
}
