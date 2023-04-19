
import Controller.AnimalRepository;
import Controller.ProductRepository;
import Model.Animal;
import Model.Product;


public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to PTR from product its introspaction by Reflection");
        Product product = new Product(2,"lampada",16.30);
        Animal animali = new Animal(15,"gatto","panko",true,false);
        ProductRepository productRepository = new ProductRepository();
        AnimalRepository animaliRepository = new AnimalRepository();
        productRepository.printAttributesProperty(product);
//        animaliRepository.printAttributesProperty(animali);
        //productRepository.select(product);

    }

}