package httpClient;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.*;

/**
 * Created by Admin on 16.05.2016.
 */
public class GET_ex {
    public static void main(String[] args) throws IOException {
        String uri = "http://www.protesting.ru/";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet get = new HttpGet(uri);
        CloseableHttpResponse response = httpClient.execute(get);
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println(statusCode);
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String res = reader.readLine();
        while (reader.readLine() != null) {
            res += reader.readLine();
        }
        reader.close();
        FileWriter writer = new FileWriter(new File("C:\\Users\\Admin\\Desktop\\res.html"));
        writer.write(res);
        writer.close();
        System.out.println(res);
    }
}
