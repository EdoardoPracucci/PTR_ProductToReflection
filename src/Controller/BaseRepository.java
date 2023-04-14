package Controller;

import java.lang.reflect.Field;

public class BaseRepository <T> {
    public void printAttributesProperty(){
        BaseRepository<T> baseRepository = new BaseRepository<T>();
        Class cls = baseRepository.getClass();
        Field[] fields = cls.getDeclaredFields();
        for(int i=0;i<fields.length;i++){

            System.out.println(fields[i].getName());
        }
    }
    public void test(Object obj){
        BaseRepository<T> baseRepository = new BaseRepository<T>();
        System.out.println(baseRepository.getClass().getName());
        System.out.println(baseRepository.getClass().getNestHost().getName());
        Field[] fields = obj.getClass().getDeclaredFields();
        for(int i=0;i<fields.length;i++){

            System.out.println(fields[i].getName());
        }
        System.out.println(fields.length);
    }
}
