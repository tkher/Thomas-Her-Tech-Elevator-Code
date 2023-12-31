package com.techelevator;

public class Exercise03_Shirts {

    private final static char SMALL_TSHIRT = 'S';
    private final static char MEDIUM_TSHIRT = 'M';
    private final static char LARGE_TSHIRT = 'L';

    /*
    A t-shirt company rep from Top Threads just finished taking an order
    from a client and needs to key it into the system. The client ordered,
    3 Small shirts ('S'), 2 Medium shirts ('M'), and 1 Large shirt ('L').

    Implement the logic to reflect an order of 6 t-shirts.

    Examples:
    buildOrder() → ['S', 'S', 'S', 'M', 'M', 'L']
     */
    public char[] buildOrder() {
<<<<<<< HEAD
        char[] shirtOrder = new char[6];
        shirtOrder [0] = 'S';
        shirtOrder [1] = 'S';
        shirtOrder [2] = 'S';
        shirtOrder [3] = 'M';
        shirtOrder [4] = 'M';
        shirtOrder [5] = 'L';
        return shirtOrder;
    }


=======
        return new char[] {};    
    }

>>>>>>> 6cf82d46e82b190b79c85c70bfcc67aaf55f72dc
    /*
    Another customer called in and is hosting a large networking event and
    needs a bulk order. Rather than indicate how many of each shirt they
    wanted, they've asked for as even distribution as possible.

    Implement the logic to generate an order representing as even a distribution
    as possible, for example: ('S', 'M', 'L', 'S', 'M', 'L', 'S', ...)

    Note: The number of shirts ordered is guaranteed to be non-negative.

    Examples:
    buildBulkOrder(6) → ['S', 'M', 'L', 'S', 'M', 'L']    
    buildBulkOrder(3) → ['S', 'M', 'L']
    buildBulkOrder(4) → ['S', 'M', 'L', 'S']
    buildBulkOrder(0) → []
     */
<<<<<<< HEAD
    public char[] buildBulkOrder(int numberOfShirts) {
        char[] evenDistribution = new char[numberOfShirts];
        for (int i = 0; i < numberOfShirts; i+=3) {
            evenDistribution[i] = SMALL_TSHIRT;
            //evenDistribution[i+1] = MEDIUM_TSHIRT;
            //evenDistribution[i+2] = LARGE_TSHIRT;
        }
        for (int i = 1; i < numberOfShirts; i+=3) {
            evenDistribution[i] = MEDIUM_TSHIRT;
        }
        for (int i = 2; i < numberOfShirts; i+=3) {
            evenDistribution[i] = LARGE_TSHIRT;
        }
        return evenDistribution;
=======
    public char[] buildBulkOrder(int numberOfShirts) { 
        return new char[] {};    
>>>>>>> 6cf82d46e82b190b79c85c70bfcc67aaf55f72dc
    }

    /*
    The warehouse is out of small shirts and will only request more when the
    next order comes in that includes an 'S' shirt.

    Implement the logic to look through the next incoming order `char[] order`
    and return true if we need to place an order for Small shirts.

    Examples:
    placeRequest(['M', 'L', 'S']) → true
    placeRequest(['M', 'S', 'L']) → true
    placeRequest(['M', 'M', 'L']) → false
    placeRequest([]) → false
     */
    public boolean placeRequest(char[] order) {
<<<<<<< HEAD
        boolean requestSmalls = false;
        for (int a = 0; a < order.length; a++) {
            if(order[a] == 'S') {
                requestSmalls = true;
            }
        }
        return requestSmalls;
=======
        return false; 
>>>>>>> 6cf82d46e82b190b79c85c70bfcc67aaf55f72dc
    }
}
