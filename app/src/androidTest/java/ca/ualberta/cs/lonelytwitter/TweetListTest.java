package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

/**
 * Ayyy lmao
 *
 */

public class TweetListTest extends ActivityInstrumentationTestCase2 {
	public TweetListTest() {
		super(LonelyTwitterActivity.class);
	}
	
	public void testAddTweet() {
		TweetList tweets = new TweetList();
		Tweet tweet = new NormalTweet("tweet");
		tweets.addTweet(tweet);
		
		assertTrue("Should contain the tweet", tweets.hasTweet(tweet));
	}
	
	public void testDeleteTweet() {
		TweetList tweets = new TweetList();
		Tweet tweet = new NormalTweet("tweet");
		tweets.addTweet(tweet);
		assertTrue("Should contain the tweet", tweets.hasTweet(tweet));
		tweets.deleteTweet(tweet);
		assertTrue("Should not contain tweet", !tweet.hasTweet(tweet));
	}
	
	public void testGetTweet() {
		TweetList tweets = new TweetList();
		Tweet tweet = new NormalTweet("Tweet");
		tweets.addTweet(tweet);
		Tweet returnedTweet = tweets.getTweet(0);
		assertEquals(returnedTweet.getMessage(), tweet.getMessage());
		assertEquals(returnedTweet.getDate(), tweet.getDate());
	}
	
	public void testHasTweet() {
		TweetList tweets = new TweetList();
		Tweet tweet = new NormalTweet("tweet");
		tweets.addTweet(tweet);
		assertTrue("Should contain the tweet", tweets.hasTweet(tweet));
	}