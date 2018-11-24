package WangChen.JavaTest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;

public class Test01 {
    public static void main(String[] args){
        String xmlstring = "<root><people>AHPPIAW</people></root>";
        try {
            Document document = DocumentHelper.parseText(xmlstring);

        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
