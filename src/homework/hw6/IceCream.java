public class IceCream extends DessertItem {
    int cost;

    public IceCream() {
        this("Ice Cream", 100); // defaults
    }

    public IceCream(String name, int cents) {
        super(name);
        setCost(cents);
    }

    public void setCost(int cents) {
        if (cents > 0) {
            cost = cents;
        } else {
            System.out.println(this.getClass().getName() + " (" + this.name + ")" +
                " ERROR! Cost must be > 0. Defaulting to 100.\n");
            cost = 100;
        }
    }

    @Override
    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return name;
    }
}