package Controller;

import Model.BaseRepositoryCompatibleModel;

import java.lang.reflect.Field;
import  java.lang.*;
import java.sql.*;
import java.util.List;
;
import static javax.swing.UIManager.*;

public class BaseRepository<T extends BaseRepositoryCompatibleModel> {
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
            System.out.println(obj.getAllAttributesValue().get(fields[i].getName()));

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
    }

    public void insert(T obj){
        Class cls = obj.getClass();
        Field[] fields = cls.getDeclaredFields();

        String sql = " insert into "+ obj.getClass().getSimpleName()+ " " + this.fieldPropertyString(fields) + " values ("+this.getValuesLength(fields)+") ";
        System.out.println(sql);
        try(Connection conn = DriverManager.getConnection(DB_URL, user, password);
            PreparedStatement pstmt = conn.prepareStatement(sql);
        )
        {
            for(int i=0;i<fields.length;i++){
                switch (fields[i].getType().getSimpleName()){
                    case "int":
                        int intToInsert = (Integer)obj.getAllAttributesValue().get(fields[i].getName());
                        pstmt.setInt(i+1 , intToInsert);
                        break;
                    case "String":
                        String stringToInsert = (String)obj.getAllAttributesValue().get(fields[i].getName());
                        pstmt.setString(i+1 , stringToInsert );
                        break;
                    case "boolean":
                        boolean boolToInsert= (boolean)obj.getAllAttributesValue().get(fields[i].getName());
                        pstmt.setBoolean(i+1, boolToInsert);
                        break;
                    case "double":
                        double doubleToInsert= (double)obj.getAllAttributesValue().get(fields[i].getName());
                        pstmt.setDouble(i+1,doubleToInsert);
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
