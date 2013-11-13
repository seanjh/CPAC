public class Cookie extends DessertItem {
    private int number;
    private int centsPerDozen;

    public Cookie() {
        this("", 1, 1);a
    }

    public Cookie(String name, int number, int cents) {
        super(name);
        setNumber(number);
        setCentsPerDozen(cents);
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

    public int getCentsPerDozen() {
        return pricePerDozen;
    }

    public void setCentsPerDozen(int cents) {
        if (price > 0) {
            centsPerDozen = cents;
        } else {
            System.out.println("ERROR! Price/dozen Cookies must be > 0. Defaulting to 1.");
            centsPerDozen = 1;
        }
    }

    public int getCost() {
        double dozens = (double) number / 12.0; 
        return Math.round((float)(dozens * centsPerDozen));
    }
}
