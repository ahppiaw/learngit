package WangChen.JavaTest;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test06 {
    public static void main(String[] args){

    }
    static class Post extends Thread{
        HttpClient client = HttpClients.createDefault();
        @Override
        public void run() {
            try {
                HttpPost post = new HttpPost("http://openapi.youdao.com/");
                List<BasicNameValuePair> parameters = new ArrayList<>();
                parameters.add(new BasicNameValuePair("q","parser"));
                parameters.add(new BasicNameValuePair("from","EN"));
                parameters.add(new BasicNameValuePair("to","zh_CH"));
                parameters.add(new BasicNameValuePair("appKey","23acdf67351440c5"));
                parameters.add(new BasicNameValuePair("salt","2"));
                parameters.add(new BasicNameValuePair("sign","569111E25BC835333E974E896C23048A"));

                post.setEntity(new UrlEncodedFormEntity(parameters,"UTF-8"));
                HttpResponse response = client.execute(post);
                HttpEntity entity = response.getEntity();
                String result = EntityUtils.toString(entity,"UTF-8");
                System.out.println(result);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
