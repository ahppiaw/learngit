package WangChen.JavaTest;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.io.IOException;

public class Test05 {
    public static void main(String[] args){
        new Get().start();
    }
    static class Get extends Thread{
        HttpClient client = HttpClients.createDefault();

        @Override
        public void run() {
            HttpGet get = new HttpGet("http://www.baidu.com");
            try {
                HttpResponse response = client.execute(get);
                HttpEntity entity = response.getEntity();
                String result = EntityUtils.toString(entity,"UTF-8");
                System.out.println(result);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
