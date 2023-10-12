/**
 * ClothingProduct.java: This class is used to represent the Clothing product
 * It extends Product class to implement the abstract method and implements
 * methods present in Purchasable interface.
 *
 * @author Sai Surya Prakash Moka
 *
 * @date 09-10-2023.
 */
public class ClothingProduct extends Product implements Purchasable{
    private String size;
    private String productType;

    /**
     *
     * @param productId - Unique ID assigned to each product
     * @param productName - Name of the Product
     * @param size - Size of the clothing Product
     * @param price - Price for that particular product with floating precision
     * @param description - Product description
     * @param productType - Describes the type of product(Clothing/Electronic)
     * @param quantity - Quantity represented as integer
     */
    ClothingProduct(int productId,String productName,String size,
                    double price,String description,String productType,int quantity)
    {
        super(productId,productName,price,description,quantity);
        this.size=size;
        this.productType=productType;
    }


    /**
     * displayInfo(): Displays the product details.
     */
    @Override
    void displayInfo() {
        System.out.println("Product ID: "+this.productId
                +"\nProduct Name: "+this.productName+
                "\nSize: "+this.size+
                "\nPrice: "+this.price+
                "\nDescription: "+this.description+
                "\nType: "+this.productType+
                "\nQuantity:"+this.quantity);
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
