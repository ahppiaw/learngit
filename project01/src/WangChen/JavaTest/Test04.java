package WangChen.JavaTest;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Test04 {
    public static void main(String[] args){
        new ReadByPost().start();
    }
    static class ReadByPost extends Thread{
        @Override
        public void run() {
            try {
                URL url = new URL("http://openapi.youdao.com/");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.addRequestProperty("encoding","UTF-8");
                connection.setDoInput(true);
                connection.setDoOutput(true);
                connection.setRequestMethod("POST");

                OutputStream os = connection.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os);
                BufferedWriter bw = new BufferedWriter(osw);

                bw.write("api?q=paser&from=EN&to=zh_CH&appKey=23acdf67351440c5&salt=2&sign=569111E25BC835333E974E896C23048A");
                bw.flush();

                InputStream is = connection.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);


                String line;
                StringBuilder builder  = new StringBuilder();
                while((line = br.readLine())!=null){
                    builder.append(line);
                }

                bw.close();
                osw.close();
                os.close();
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
