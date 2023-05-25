package com.techelevator;

/**
 * Bookstore
 */
public class Bookstore {

    public static void main(String[] args) {
        System.out.println("Welcome to the Tech Elevator Bookstore");

        // Create a book object using the default constructor. Then set the book's properties
        Book twoCities = new Book();
        twoCities.setTitle("A Tale of Two Cities");
        twoCities.setAuthor("Charles Dickens");
        twoCities.setPrice(14.99);

        // Create two more book object and set their properties using a constructor
        Book threeMusketeers = new Book("The Three Musketeers", "Alexandre Dumas", 12.95);
        Book childhoodEnd = new Book("Childhood's End", "Arthur C. Clark", 5.99);

        // Add all three books to the shopping cart and print a receipt
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(twoCities);
        shoppingCart.add(threeMusketeers);
        shoppingCart.add(childhoodEnd);
//        System.out.println(shoppingCart.receipt());

        //Add new movies and purchase them
        Movie toystory = new Movie("Toy Story", "R", 81, 19.99);
        shoppingCart.add(toystory);

        Movie airplane = new Movie();
        airplane.setTitle("Airplane!");
        airplane.setRating("PG-13");
        airplane.setRunLength(88);
        airplane.setPrice(14.99);

        shoppingCart.add(airplane);

        System.out.println(shoppingCart.receipt());
    }
}
