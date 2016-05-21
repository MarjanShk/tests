package TwitterApi;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Created by Admin on 20.05.2016.
 */
public class UpdateStatus extends Base {
    private String uri = "https://api.twitter.com/1.1/statuses/update.json";

    @Test
    public void testUpdateStatus() throws IOException, OAuthCommunicationException, OAuthExpectationFailedException, OAuthMessageSignerException {

        Random r = new Random();
        String twitt = "newStatusFromJava" + r.nextInt();

        HttpPost post = new HttpPost(uri);
        List<BasicNameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("status", twitt));
        post.setEntity(new UrlEncodedFormEntity(params));
        consumer.sign(post);
        HttpResponse response = httpClient.execute(post);
        System.out.println(response.getStatusLine().getStatusCode());
        String responseBody = getResponseBody(response);
        System.out.println(responseBody);
        JsonElement parsed = new JsonParser().parse(responseBody);
        String statusId = parsed.getAsJsonObject().get("id_str").getAsString();
        String twittFromResponse = parsed.getAsJsonObject().get("text").getAsString();

        Assert.assertEquals(twitt, twittFromResponse);

        System.out.println("ID of created status: " + statusId);

    }

}