public class Sundae extends IceCream {
    private SundaeTopping topping;

    public Sundae() {
        this("Sundae", 100, "Topping", 100);
    }

    public Sundae(String name, int cents, String toppingName, int toppingCents) {
        super(name, cents); // IceCream 2-arg constructor
        topping = new SundaeTopping(toppingName, toppingCents); // SundaeTopping 2-arg constructor
    }

    @Override
    public int getCost() {
        return this.cost + topping.toppingCost;
    }
    
    @Override 
    public String toString() {
        String output = topping.name + " Sundae with\n";
        output += name;
        return output;
    }

}

    // TODO: getter/setters for topping

    class SundaeTopping extends DessertItem {
        protected int toppingCost; // cost in cents

        protected SundaeTopping() {
            this("Topping", 100); // default values
        }

        protected SundaeTopping(String name, int cents) {
            super(name);
            setCost(cents);
        }

        @Override
        public int getCost() {
            return toppingCost;
        }

        protected void setCost(int cents) {
            if (cents > 0) {
                toppingCost = cents;
            } else {
                System.out.println("ERROR! Cost must be > 0. Defaulting to 100.");
                toppingCost = 100;
            }
        }
    }
