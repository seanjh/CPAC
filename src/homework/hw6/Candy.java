import java.text.DecimalFormat;

public class Candy extends DessertItem {
    private double pounds;
    private int costPerPound;

    public Candy() {
        this("Candy", 1.0, 100); // defaults
    }

    public Candy(String name, double pounds, int cents) {
       super(name);
       setPounds(pounds);
       setCostPerPound(cents);
    }

    public double getPounds() {
        return pounds;
    }

    public void setPounds(double pounds) {
        if (pounds > 0) {
            this.pounds = pounds;
        } else {
            System.out.println(this.getClass().getName() + " (" + this.name + ")" +
                " ERROR! The pounds must be > 0. Defaulting to 1.0.\n");
            this.pounds = 1.0;
        }
    }

    public int getCostPerPound() {
        return costPerPound;
    }

    public void setCostPerPound(int cents) {
        if (cents > 0) {
            costPerPound = cents;
        } else {
            System.out.println(this.getClass().getName() +  " (" + this.name + ")" +
                " ERROR! Cents/pound must be > 0. Defaulting to 100.\n");
            costPerPound = 100;
        }
    }

    @Override
    public int getCost() {
        return (int) Math.round(pounds * costPerPound); 
    }

    @Override
    public String toString() {
        DecimalFormat formatter = new DecimalFormat("#.##");
        String output = ("" + formatter.format(pounds) + " lbs. @ " + 
                    DessertShoppe.cents2dollarsAndCents(costPerPound) + 
                    " /lb.\n");
        output += name;

        return output;
    }
}