/**
 * Product.java: This file acts as a POJO object for both ClothingProduct
 * and ElectronicProduct classes.
 *
 * @author Sai Surya Prakash Moka
 *
 * @date 09-10-2023.
 */
public abstract class Product implements Purchasable{
    protected int productId;
    protected String productName;
    protected double price;
    protected String description;
    protected int quantity;

    /**
     *
     * @param productId - Unique ID assigned to each product
     * @param productName - Name of the Product
     * @param price - Price for that particular product with floating precision
     * @param description - Product description
     * @param quantity - Quantity represented as integer
     */
     Product(int productId,String productName,double price,String description,int quantity)
    {
        this.productId=productId;
        this.productName=productName;
        this.price=price;
        this.description=description;
        this.quantity=quantity;
    }

    abstract void displayInfo();

    /**
     * @return quantity represented as Integer.
     */
    public int getQuantity()
    {
        return this.quantity;
    }

     /**
     *
     * @param qty- Accepts Qty
     * @return - Returns qty multiplied by price.
     */
    @Override
    public double calculatePrice(int qty) {
        return qty*this.price;
    }
}
