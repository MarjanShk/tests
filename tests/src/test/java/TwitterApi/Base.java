package TwitterApi;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.testng.annotations.BeforeMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Admin on 21.05.2016.
 */
public class Base {
    String consumerKey = "uRIMIf0XqkXk2hbn7LhThgzJd";
    String consumerSecret = "3H97yoFsZwXZzedegFpdevkI17J6X0l7V2QctkMWOD7uv4ii75";
    String accessToken = "732266567489196034-rPaMZQ0sKslgeFi37zwySjiQrRB6QE4";
    String accessTokenSecret = "vBMwF2jOc97k8MVY6viyLJGvgY5IgBMHHL8OWkw8U4MqU";
    OAuthConsumer consumer;
    HttpClient httpClient;

    @BeforeMethod
    public void oAuth() {
        consumer = new CommonsHttpOAuthConsumer(consumerKey, consumerSecret);
        consumer.setTokenWithSecret(accessToken, accessTokenSecret);
        httpClient = HttpClients.createDefault();
    }

    public Set<Map.Entry<Long, String>> getAllTwitts() throws OAuthCommunicationException, OAuthExpectationFailedException, OAuthMessageSignerException, IOException {
        HttpGet getStatuses = new HttpGet("https://api.twitter.com/1.1/statuses/user_timeline.json?count=100");
        consumer.sign(getStatuses);
        HttpResponse httpResponse = httpClient.execute(getStatuses);
        BufferedReader reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
        String response = reader.readLine();
        while (reader.readLine() != null) {
            response += reader.readLine();
        }
        reader.close();

        JsonElement parsed = new JsonParser().parse(response);
        JsonArray jsonArray = parsed.getAsJsonArray();
        Map<Long, String> mapTwitts = new TreeMap<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            mapTwitts.put(jsonArray.get(i).getAsJsonObject().get("id_str").getAsLong(),
                    jsonArray.get(i).getAsJsonObject().get("text").getAsString());

        }
        return mapTwitts.entrySet();
    }

    public List<Long> getAllTwittsId() throws OAuthExpectationFailedException, OAuthCommunicationException, OAuthMessageSignerException, IOException {
        List<Long> ids = new ArrayList<>();
        Set<Map.Entry<Long, String>> allTwitts = getAllTwitts();
        for (Map.Entry<Long, String> t : allTwitts) {
            ids.add(t.getKey());
        }
        return ids;
    }

    public String getResponseBody(HttpResponse response) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String responseBody = reader.readLine();
        while (reader.readLine() != null) {
            responseBody += reader.readLine();
        }
        reader.close();
        return responseBody;
    }
}
