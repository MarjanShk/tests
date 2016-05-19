package httpClient;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.*;

/**
 * Created by Admin on 16.05.2016.
 */
public class Get_2 {
    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet get = new HttpGet("http://hc.apache.org/httpcomponents-client-ga/tutorial/html/fundamentals.html");
        CloseableHttpResponse response = httpClient.execute(get);
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String res = reader.readLine();
        while (reader.readLine()!=null){
            res+=reader.readLine();
        }
        reader.close();
        FileWriter writer = new FileWriter(new File("C:\\Users\\Admin\\Desktop\\res2.html"));
        writer.write(res);
        writer.close();
        System.out.println(response.getStatusLine().getStatusCode());
        httpClient.close();
    }
}
