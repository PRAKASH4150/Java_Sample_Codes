/**
 * ElectronicProduct.java: This class is used to represent the Electronic product
 * It extends Product class to implement the abstract method and implements
 * methods present in Purchasable interface.
 *
 * @author Sai Surya Prakash Moka
 *
 * @date 09-10-2023.
 */
public class ElectronicProduct extends Product {

    private String brand;
    private String productType;

    /**
     *
     * @param productId - Unique ID assigned to each product
     * @param productName - Name of the Product
     * @param brand - Describes the brand of the electronic product
     * @param price - Price for that particular product with floating precision
     * @param description - Product description
     * @param productType - Describes the type of product(Clothing/Electronic)
     * @param quantity - Quantity represented as integer
     */
    ElectronicProduct(int productId,String productName,String brand,
                      double price,String description,String productType,int quantity)
    {
        super(productId,productName,price,description,quantity);
        this.brand=brand;
        this.productType=productType;
    }

    /**
     * displayInfo(): Displays the product details.
     */
    @Override
    void displayInfo() {
        System.out.println("Product ID: "+this.productId
                +"\nProduct Name: "+this.productName+
                "\nBrand: "+this.brand+
                "\nPrice: "+this.price+
                "\nDescription: "+this.description+
                "\nType: "+this.productType+
                "\nQuantity:"+this.quantity);
    }


}
