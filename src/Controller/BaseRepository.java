package Controller;

import java.lang.reflect.Field;

public class BaseRepository<T> {
    public void printAttributesProperty(T obj){
        Class cls = obj.getClass();
        Field[] fields = cls.getDeclaredFields();
        for(int i=0;i<fields.length;i++){
            System.out.println(fields[i].getName());
        }

    }
}
