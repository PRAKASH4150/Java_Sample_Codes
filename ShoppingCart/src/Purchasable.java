/**
 * Purchasable.java: This is an interface called
 * Purchasable with two abstract methods namely calculatePrice
 * and getQuantity.
 *
 * @author Sai Surya Prakash Moka
 *
 * @date 09-10-2023.
 */
public interface Purchasable {
    double calculatePrice( int qty );
    int getQuantity();
}
