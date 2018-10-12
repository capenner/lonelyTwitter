package ca.ualberta.cs.lonelytwitter;

import android.os.AsyncTask;
import android.util.Log;

import com.searchly.jestdroid.DroidClientConfig;
import com.searchly.jestdroid.JestClientFactory;
import com.searchly.jestdroid.JestDroidClient;

import java.util.ArrayList;
import java.util.List;

import io.searchbox.client.JestResult;
import io.searchbox.core.DocumentResult;
import io.searchbox.core.Index;
import io.searchbox.core.Search;

/**
 * Created by romansky on 10/20/16.
 */
public class ElasticsearchTweetController {
    private static JestDroidClient client;

    public static void verifySettings() {
        if (client == null) {
            DroidClientConfig.Builder builder = new DroidClientConfig.Builder("http://cmput301.softwareprocess.es:8080/");
            DroidClientConfig config = builder.build();

            JestClientFactory factory = new JestClientFactory();
            factory.setDroidClientConfig(config);
            client = (JestDroidClient) factory.getObject();
        }
    }

    // TODO we need a function which adds tweets to elastic search
    public static class AddTweetsTask extends AsyncTask<Tweet, Void, Void> {
        @Override
        protected Void doInBackground(Tweet... params) {
            verifySettings();

            Tweet tweet = params[0];
            Index index = new Index.Builder(tweet).index("REACT-serv").type("tweet").build();
            Log.d("Hello", "doInBackground: fac");
            try {
                DocumentResult result = client.execute(index);
                if (result.isSucceeded()) {
                    tweet.setTweetID(result.getId());
                }
            }
            catch (Exception e) {
                Log.i("Error", "The application failed to build and send the tweets");
            }
            return null;
        }
    }
	
    public static class GetTweetsTask extends AsyncTask<String, Void, ArrayList<Tweet>> {
        @Override
        protected ArrayList<Tweet> doInBackground(String... search_parameters) {
            verifySettings();

            ArrayList<Tweet> tweets = new ArrayList<Tweet>();
			Search search = new Search.Builder(search_parameters[0]).addIndex("REACT-serv").addType("Tweet").build();
            Log.d("Hello", "doInBackground: off");
            try {
               JestResult result = client.execute(search);
			   if (result.isSucceeded()) {
				   List<NormalTweet> tweetList;
				   tweetList = result.getSourceAsObjectList(NormalTweet.class);
				   tweets.addAll(tweetList);
			   }
            }
            catch (Exception e) {
                Log.i("Error", "Something went wrong when we tried to communicate with the elasticsearch server!");
            }

            return tweets;
        }
    }
}