package TwitterApi;

import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Random;

/**
 * Created by Admin on 21.05.2016.
 */
public class RemoveTwitt extends Base {
    @Test
    public void testRemoveTwitt() throws OAuthExpectationFailedException, OAuthCommunicationException, OAuthMessageSignerException, IOException {

        Random r = new Random();
        int number = r.nextInt(5);
        List<Long> ids = getAllTwittsId();
        Long deletedtwitt = ids.get(number);
        HttpPost request = new HttpPost("https://api.twitter.com/1.1/statuses/destroy/" + deletedtwitt + ".json");
        consumer.sign(request);
        HttpResponse response = httpClient.execute(request);
        System.out.println(response.getStatusLine().getStatusCode());
        String responseBody = getResponseBody(response);
        System.out.printf(responseBody);
        List<Long> newIds = getAllTwittsId();

        Assert.assertEquals(ids.size() - 1, newIds.size());
        Assert.assertFalse(newIds.contains(deletedtwitt));

    }

}
