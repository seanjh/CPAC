public class Checkout {
    private DessertItem[] desserts;
    private int numberOfItems = -1;
    private int totalCost = 0;
    private int totalTax = 0;

    public Checkout() {
        desserts = new DessertItem[100]; // default size 100
    }

    public void enterItem(DessertItem dessert) {
        /*if (numberOfItems >= desserts.length - 1) {
            extendArray();
        }*/
        numberOfItems++;
        desserts[numberOfItems] = dessert;
        totalCost += dessert.getCost();
        totalTax += Math.round((double)dessert.getCost() * DessertShoppe.TAX_RATE / 100);
    }

    /*private void extendArray() {
        // Copy the existing array to a new array with old-length + 100
        DessertItem[] temp = desserts;
        int newLength = temp.length + 100;
        desserts = System.arraycopy(temp, 0, new DessertItem[newLength], 0, newLength);
    }*/

    public void clear() {
        numberOfItems = -1;
        totalCost = 0;
        totalTax = 0;
    }

    public int numberOfItems() {
        return numberOfItems + 1;
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

    public int totalCost() {
        return totalCost;
    }

    public int totalTax() {
        return totalTax;
    }
}
