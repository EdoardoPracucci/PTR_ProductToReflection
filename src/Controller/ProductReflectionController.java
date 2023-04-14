package Controller;

import Model.Product;

import java.lang.reflect.Field;
import java.util.Arrays;

public class ProductReflectionController {
    public static void main(String[] args) {
        propertyProductAttributes();
    }
    public static void propertyProductAttributes(){
        Product product= new Product();
        Class cls = product.getClass();
        Field[] fields = cls.getDeclaredFields();
        for(int i=0;i<fields.length;i++){

            System.out.println(fields[i].getName());
        }
    }
    public static void propertyGenericClass(){

    }
}
