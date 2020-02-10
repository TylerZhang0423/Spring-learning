package GSON;

import JSON.Student;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Field;

public class CreateByGson {
    public static void main(String[] args){
        Student student = new Student();
        student.setName("tyler");
        student.setAge(14);
        student.setAddress("China");


        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        gsonBuilder.setFieldNamingStrategy(new FieldNamingStrategy() {
            public String translateName(Field field) {
                if (field.getName().equals("name")) {
                    return "NAME";
                }
                return field.getName();
            }
        });
        Gson gson = gsonBuilder.create();
        System.out.println(gson.toJson(student));
    }

}
