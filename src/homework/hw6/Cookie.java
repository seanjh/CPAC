public class Cookie extends DessertItem {
    private int number;
    private int costPerDozen;

    public Cookie() {
        this("", 1, 1);a
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
            System.out.println("ERROR! Number of Cookies must be > 0. Defaulting to 1.");
            this.number = 1;
        }
    }

    public int getCostPerDozen() {
        return costPerDozen;
    }

    public void setCostPerDozen(int cents) {
        if (price > 0) {
            centsPerDozen = cents;
        } else {
            System.out.println("ERROR! Price/dozen Cookies must be > 0. Defaulting to 100.");
            costPerDozen = 100;
        }
    }

    @Override
    public int getCost() {
        double dozens = (double) number / 12.0; 
        return Math.round((float)(dozens * centsPerDozen));
    }
}
