package WangChen.JavaTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;



public class Test03 {
    public static void main(String[] args){
        new ReadByGet().start();
    }
    static class ReadByGet extends Thread{
        @Override
        public void run() {
            try {
                URL url = new URL("http://openapi.youdao.com/api?q=paser&from=EN&to=zh_CH&appKey=23acdf67351440c5&salt=2&sign=569111E25BC835333E974E896C23048A");

                URLConnection connection = url.openConnection();
                InputStream is = connection.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);

                String line;
                StringBuilder builder = new StringBuilder();
                while((line = br.readLine()) != null){
                    builder.append(line);
                }
                br.close();
                isr.close();
                is.close();
                System.out.println(builder.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
