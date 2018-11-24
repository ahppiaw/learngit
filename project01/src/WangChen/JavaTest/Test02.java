package WangChen.JavaTest;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.SQLOutput;

public class Test02 {
    public static void main(String[] arg){
        try {
            JsonParser parser = new JsonParser();
            JsonObject object = (JsonObject) parser.parse(new FileReader("test.json"));

            System.out.println("cat="+object.get("cat").getAsString());
            System.out.println("pop="+object.get("pop").getAsBoolean());

            JsonArray array = object.get("languages").getAsJsonArray();
            for (int i=0;i<array.size();i++){
                System.out.println("---------------");
                JsonObject subobject = array.get(i).getAsJsonObject();
                System.out.println("id="+subobject.get("id").getAsInt());
                System.out.println("name="+subobject.get("name").getAsString());
                System.out.println("ide="+subobject.get("ide").getAsString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
