public class Cookie extends DessertItem {
    private int number;
    private int costPerDozen;

    public Cookie() {
        this("Cookie", 1, 100); // Default arguments
    }

    public Cookie(String name, int number, int cents) {
        super(name);
        setNumber(number);
        setCostPerDozen(cents);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        if (number > 0) {
            this.number = number;
        } else {
            System.out.println(this.getClass().getName() + " (" + this.name + ")" +
                " ERROR! Number of Cookies must be > 0. Defaulting to 1.\n");
            this.number = 1;
        }
    }

    public int getCostPerDozen() {
        return costPerDozen;
    }

    public void setCostPerDozen(int cents) {
        if (cents > 0) {
            costPerDozen = cents;
        } else {
            System.out.println(this.getClass().getName()  + " (" + this.name + ")" +
                " ERROR! Price/dozen Cookies must be > 0. Defaulting to 100.\n");
            costPerDozen = 100;
        }
    }

    @Override
    public int getCost() {
        // First calculate the number of dozens, since cookie cost is by the dozen
        double dozens = (double) number / 12.0; 
        return (int) Math.round((dozens * costPerDozen));
    }

    @Override
    public String toString() {
        String output;
        output = ("" + number + " @ " + DessertShoppe.cents2dollarsAndCents(costPerDozen) +
                " /dz.\n");
        output += name;
        return output;
    }
}
