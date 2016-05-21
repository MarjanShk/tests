package TwitterApi;

import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * Created by Admin on 21.05.2016.
 */
public class GetTwitts extends Base {

    @Test
    public void testGetTwitts() throws OAuthExpectationFailedException, OAuthCommunicationException, OAuthMessageSignerException, IOException {
        Set<Map.Entry<Long, String>> allTwitts = getAllTwitts();
        System.out.println("Number of all twitts: " + allTwitts.size());
        for (Map.Entry<Long, String> twitt : allTwitts) {
            System.out.println(twitt.getKey() + " : " + twitt.getValue());
        }

    }
}
