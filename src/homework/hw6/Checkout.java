public class Checkout {
    private DessertItem[] desserts;
    private int numberOfItems; // numberOfItems represents the last valid index
    private int totalCost;
    private int totalTax;

    public Checkout() {
        desserts = new DessertItem[100]; // defaults
        numberOfItems = -1;
        totalCost = 0;
        totalTax = 0;
    }

    /* When an item is entered, also calculate the new totalCost and totalTax.
    *  Performing this operation up front means we don't need to traverse the 
    *  whole Checkout array each time we output these values.
    */
    public void enterItem(DessertItem item) {
        numberOfItems++;
        desserts[numberOfItems] = item;
        totalCost += item.getCost();
        totalTax += (int) Math.round(item.getCost() * DessertShoppe.TAX_RATE / 100);
    }

    public void clear() {
        // Reset the last valid index tracker and total aggregate values
        numberOfItems = -1;
        totalCost = 0;
        totalTax = 0;
    }

    public int numberOfItems() {
        return numberOfItems + 1; // Add 1 to the last valid index
    }

    public int totalCost() {
        return totalCost;
    }

    public int totalTax() {
        return totalTax;
    }

    @Override
    public String toString() {
        String output = "\tSean's Dessert Shoppe\n";
        output += "\t---------------------\n\n";
        
        for (int i = 0; i <= numberOfItems; i++) {
            output += ("" + desserts[i] + "\t");

            if (desserts[i].getName().length() < 16) { // extra tab needed for short names
                output += "\t";
            }

            output += ("" +  DessertShoppe.cents2dollarsAndCents(desserts[i].getCost()) +
                        "\n");
        }
        output += ("\nTax\t\t\t" + DessertShoppe.cents2dollarsAndCents(totalTax) + "\n");
        output += ("Total Cost\t\t" + DessertShoppe.cents2dollarsAndCents(totalCost + totalTax) +
                    "\n");

        return output;
    }
}
