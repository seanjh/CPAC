/* Sundae *has a* topping, and *is an* IceCream.
*/
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
        return this.cost + topping.cost;
    }
    
    @Override 
    public String toString() {
        String output = topping.name + " Sundae with\n";
        output += name;
        return output;
    }

    /* SundaeTopping is a nested Inner Class of Sundae. SundaeTopping is only
    *  relevant within Sundae, but it still *is a* DessertItem (and we still
    *  want DessertItem's constructor.
    */
    class SundaeTopping extends DessertItem {
        private int cost; // cost in cents

        private SundaeTopping() {
            this("Topping", 100); // defaults
        }

        private SundaeTopping(String name, int cents) {
            super(name);
            setCost(cents);
        }

        private void setCost(int cents) {
            if (cents > 0) {
                cost = cents;
            } else {
                System.out.println(this.getClass().getName() + " (" + this.name + ")" +
                    " ERROR! Cost must be > 0. Defaulting to 100.\n");
                cost = 100;
            }
        }

        // public to allow override of DessertItem's public getCost
        @Override
        public int getCost() {
            return cost;
        }
    }
}