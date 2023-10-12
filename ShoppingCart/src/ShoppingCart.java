/**
 * ShoppingCart.java:This class represents the Shopping cart.
 * User can add, remove and display the items present in the
 * cart.
 *
 * @author Sai Surya Prakash Moka
 *
 * @date 09-10-2023.
 */

import java.util.ArrayList;
import java.util.List;

class ShoppingCart {
    private List<Purchasable> cartList=new ArrayList<Purchasable>();

    /**
     *
     * @param item - used to append the product to the list.
     */
    public void addToCart(Purchasable item) {
        cartList.add(item);
    }

    /**
     *
     * @param item - removes items from the list.
     */
    public void removeFromCart(Purchasable item) {
        cartList.remove(item);
    }

    /**
     * displayItems(): Used to display the items present in the cart.
     */
    public void displayItems() {
        System.out.println("Shopping Cart Contents:");
        for (Purchasable product : cartList) {
            System.out.println("-------------------------------------");
            if (product instanceof Product) {
                ((Product) product).displayInfo();
            }
        }
        System.out.println("-------------------------------------");
    }

    /**
     *@return totalPrice- Returns the total cart value.
     */
    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (Purchasable product : cartList) {
            totalPrice += product.calculatePrice(product.getQuantity());
        }
        return totalPrice;
    }

}