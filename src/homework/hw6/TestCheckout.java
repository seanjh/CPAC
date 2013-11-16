/**
 * Author:  Sean Herman
 * Date:    11/17/2013
 * HW#:     7
 * File:    TestCheckout.java
 * Summary: This program implements a Dessert Shoppe stocked with various
 *  Dessert Items. The available desserts are: Candy, Cookie, Ice Cream, and Sundae 
 *  (an Ice Cream w/ 1 topping).
 * Assumptions: I implemented an additional nested class in Sundae named SundaeTopping.
 * I felt this was the right approach, since the topping on the Sundae *is* a
 * DessertItem itself, and I wanted to ensure the DessertItem constructor logic was
 * still available for this item, without duplicating that code. I made all its
 * methods and data private (including its constructor), which means that no
 * SundaeTopping objects may be created without creating a Sundae. The getCost method
 * in SundaeTopping is public, however, because I found that (for good reason) it
 * is not possible to override a parent public method with a method that has a
 * different visibility modifier.
 *
 */

public class TestCheckout {

  public static void main(String[] args) {
  
    Checkout checkout = new Checkout();
    
    checkout.enterItem(new Candy("Peanut Butter Fudge", 2.25, 399));
    checkout.enterItem(new IceCream("Vanilla Ice Cream",105));
    checkout.enterItem(new Sundae("Choc. Chip Ice Cream",145, "Hot Fudge", 50));
    checkout.enterItem(new Cookie("Oatmeal Raisin Cookies", 4, 399));
    
    System.out.println("\nNumber of items: " + checkout.numberOfItems() + "\n");
    System.out.println("\nTotal cost: " + checkout.totalCost() + "\n");
    System.out.println("\nTotal tax: " + checkout.totalTax() + "\n");
    System.out.println("\nCost + Tax: " + (checkout.totalCost() + checkout.totalTax()) + "\n");
    System.out.println(checkout);
    
    checkout.clear();
    
    checkout.enterItem(new IceCream("Strawberry Ice Cream",145));
    checkout.enterItem(new Sundae("Vanilla Ice Cream",105, "Caramel", 50));
    checkout.enterItem(new Candy("Gummy Worms", 1.33, 89));
    checkout.enterItem(new Cookie("Chocolate Chip Cookies", 4, 399));
    checkout.enterItem(new Candy("Salt Water Taffy", 1.5, 209));
    checkout.enterItem(new Candy("Candy Corn",3.0, 109));
    
    System.out.println("\nNumber of items: " + checkout.numberOfItems() + "\n");
    System.out.println("\nTotal cost: " + checkout.totalCost() + "\n");
    System.out.println("\nTotal tax: " + checkout.totalTax() + "\n");
    System.out.println("\nCost + Tax: " + (checkout.totalCost() + checkout.totalTax()) + "\n");
    System.out.println(checkout);

    checkout.clear();
    
    checkout.enterItem(new IceCream("Mint Choc. Ice Cream", -455));
    checkout.enterItem(new Sundae("Chocolate Ice Cream", 105, "Reese's Pieces", -50));
    checkout.enterItem(new Candy("Sour Apples", -0.5, 65));
    checkout.enterItem(new Cookie("Sugar Cookies", -30, -250));
    checkout.enterItem(new Candy("Gummy Bears", 2.8, 650));
    System.out.println(checkout);
  }
}
