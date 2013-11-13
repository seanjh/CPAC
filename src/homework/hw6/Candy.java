public class Candy extends DessertItem {
    private double pounds;
    private int centsPerPound;

    public Candy() {
        this("", 0.1, 1);
    }

    public Candy(String name, double pounds, int cents) {
       super(name);
       setPounds(pounds);
       setCentsPerPound(cents);
    }

    public double getPounds() {
        return pounds;
    }

    public void setUnitPounds(double pounds) {
        if (pounds > 0) {
            this.pounds = pounds;
        } else {
            System.out.println("ERROR! The pounds/unit must be > 0. Defaulting to 0.1");
            pounds = 0.1;
        }
    }

    public int getCentsPerPound() {
        return centsPerPound;
    }

    public void setCentsPerPound(int cents) {
        if (cents > 0) {
            centsPerPound = cents;
        } else {
            System.out.println("ERROR! Cents/pound must be > 0. Defaulting to 1.");
            centsPerPound = 1;
        }
    }

    public int getCost() {
        return Math.round((float)(pounds * centsPerPound)); 
    }
}
