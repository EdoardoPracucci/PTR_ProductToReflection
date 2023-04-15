
import Controller.AnimalRepository;
import Controller.ProductRepository;
import Model.Animal;
import Model.Product;


public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to PTR from product its introspaction by Reflection");
        Product product = new Product();
        Animal animali = new Animal();
        ProductRepository productRepository = new ProductRepository();
        AnimalRepository animaliRepository = new AnimalRepository();
        productRepository.printAttributesProperty(product);
        animaliRepository.printAttributesProperty(animali);
    }

}