public class Main {
    public static void main(String[] args) {
        ElectronicProduct electronicProduct = new ElectronicProduct(1,
                "Laptop","Dell", 999.99,
                "High-performance laptop","Electronic Product",2);
        ClothingProduct clothingProduct = new ClothingProduct(2,
                "T-shirt", "M",19.99,
                "Cotton T-shirt","Clothing Product",3);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addToCart(electronicProduct);
        shoppingCart.addToCart(clothingProduct);
        shoppingCart.displayItems();
        System.out.println("Total Price in Cart: $" + shoppingCart.calculateTotalPrice());
    }
}
