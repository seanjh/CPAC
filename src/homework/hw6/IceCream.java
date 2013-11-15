public class IceCream extends DessertItem {
    int cost;

    public IceCream() {
        this("", 1);
    }

    public IceCream(String name, int cents) {
        super(name);
        setCost(cents);
    }

    @Override
    public int getCost() {
        return cost;
    }

    public void setCost(int cents) {
        if (cents > 0) {
            cost = cents;
        } else {
            System.out.println("ERROR! Cost must be > 0. Defaulting to 100.");
            cost = 100;
        }
    }
}
