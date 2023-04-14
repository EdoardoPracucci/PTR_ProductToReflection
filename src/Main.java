import Controller.BaseRepository;
import Controller.ProductRepository;
import Model.Animali;
import Model.Product;


public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to PTR from product its introspaction by Reflection");
        Product product = new Product();
        Animali animali = new Animali();
        ProductRepository productRepository = new ProductRepository();
        productRepository.test(product);
        productRepository.test(animali);
    }

}