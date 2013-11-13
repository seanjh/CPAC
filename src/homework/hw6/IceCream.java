public class IceCream extends DessertItem {
    int centsCost;

    public IceCream() {
        this("", 1);
    }

    public IceCream(String name, int cents) {
        super(name);
        setCost(cents);
    }

    public int getCost() {
        return centsCost;
    }

    public void setCost(int cents) {
        if (cents > 0) {
            centsCost = cents;
        } else {
            System.out.println("ERROR! Cost must be > 0. Defaulting to 1.");
            centsCost = 1;
        }
    }
}
