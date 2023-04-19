package Controller;

import java.lang.reflect.Field;
import  java.lang.*;
import java.sql.*;
import java.util.List;
;
import static javax.swing.UIManager.*;

public class BaseRepository<T> {
    static final String DB_URL = "jdbc:mysql://localhost:3306/PTR";
    String user = "root";
    String password = "ciao1234";

    public void printAttributesProperty(T obj){
        Class cls = obj.getClass();
        Field[] fields = cls.getDeclaredFields();
        String fieldString= "(";
        for(int i=0;i<fields.length;i++){
            fieldString += fields[i].getName();
            System.out.println(fields[i].getName());
            System.out.println(getInt(obj));
            if(fields.length-1==i){
                fieldString += ")" ;

            }
            else {
                fieldString += ",";
            }
        }
        System.out.println(fieldString);
        String sql = " insert into "+ obj.getClass().getSimpleName() + fieldString +" values " +obj.toString();
        System.out.println(sql);
        System.out.println(getInt(fields[0]));
    }

    public void insert(T obj){
        Class cls = obj.getClass();
        Field[] fields = cls.getDeclaredFields();

        String sql = " insert into "+ obj.getClass().getSimpleName()+ " " + this.fieldPropertyString(fields) + " values ("+this.getValuesLength(fields)+") ";
        try(Connection conn = DriverManager.getConnection(DB_URL, user, password);
            PreparedStatement pstmt = conn.prepareStatement(sql);
        )
        {
            for(int i=0;i<fields.length;i++){
                switch (fields[i].getName()){
                    case "int":
                        pstmt.setInt(i, getInt(fields[i]) );
                        break;
                    case "String":
                        pstmt.setString(i,getString(fields[i]));
                        break;
                    case "boolean":
                        pstmt.setBoolean(i,getBoolean(fields[i]));
                        break;
                    case "double":
//                        pstmt.setDouble(i,getDouble(fields[i]));
                        break;
                }
            }
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void update(T obj){

    }

    public void select(T obj){
        String sql = "select * from "+ obj.getClass().getSimpleName();
        try(Connection conn = DriverManager.getConnection(DB_URL, user, password);
            Statement stmt = conn.createStatement();
        ) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(T obj){

    }

    public String fieldPropertyString(Field[] fields){
        String fieldString= "(";
        for(int i=0;i<fields.length;i++){
            fieldString += fields[i].getName();
            if(fields.length-1==i){
                fieldString += ")" ;
            }
            else {
                fieldString += ",";
            }
        }
        return fieldString;
    }
    public String getValuesLength(Field[] fields){
        String valueLenght="";

        for (int i=0;i<fields.length;i++){
            if(i+1==fields.length){
                valueLenght+="?";
            }
            else{
                valueLenght+="?,";
            }

        }
        return valueLenght;
    }

    public void getObjectValues(T obj){
    }
}
