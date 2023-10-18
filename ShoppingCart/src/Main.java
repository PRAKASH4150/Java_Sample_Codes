public class Main {
    public static void main(String[] args) {
        ElectronicProduct electronicProduct1 = new ElectronicProduct(1,
                "Laptop","Dell", 999.99,
                "High-performance laptop","Electronic Product",2);

        ElectronicProduct electronicProduct2 = new ElectronicProduct(2,
                "Smart Phone","Apple 14 Pro Max", 1200.00,
                "Cutting edge mobile phones","Electronic Product",5);

        ClothingProduct clothingProduct1 = new ClothingProduct(3,
                "T-shirt", "M",19.99,
                "Cotton T-shirt","Clothing Product",3);

        ClothingProduct clothingProduct2 = new ClothingProduct(4,
                "Trousers", "XL",10.99,
                "Cotton Jeans, Stretchable","Clothing Product",2);

        ClothingProduct clothingProduct3 = new ClothingProduct(5,
                "Shirt", "L",50.00,
                "Formal T-Shirt","Clothing Product",2);


        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addToCart(electronicProduct1);
        shoppingCart.addToCart(electronicProduct2);
        shoppingCart.addToCart(clothingProduct1);
        shoppingCart.addToCart(clothingProduct2);
        shoppingCart.addToCart(clothingProduct3);
        shoppingCart.displayItems();
        System.out.printf("\nTotal Price in Cart: $ %.2f",shoppingCart.calculateTotalPrice());
        System.out.println("\n-------------------------------------");
    }
}
