public class Sundae extends IceCream {
    private SundaeTopping topping;

    public Sundae() {
        this("", 1, "", 1);
    }

    public Sundae(String name, int cents, String toppingName, int toppingCents) {
        super(name, cents); // IceCream 2-arg constructor
        topping = new SundaeTopping(toppingName, toppingCents); // SundaeTopping 2-arg constructor
    }

    @Override
    public int getCost() {
        return this.cost + topping.cost;
    }

    // TODO: getter/setters for topping

    class SundaeTopping extends DessertItem {
        private int cost; // cost in cents

        private SundaeTopping() {
            this("", 1);
        }

        private SundaeTopping(String name, int cents) {
            super(name);
            setCost(cents);
        }

        @Override
        private int getCost() {
            return cost;
        }

        private void setCost(int cents) {
            if (cents > 0) {
                this.cost = cents;
            } else {
                System.out.println("ERROR! Cost must be > 0. Defaulting to 1.");
                this.cost = 1;
            }
        }
    }
}
