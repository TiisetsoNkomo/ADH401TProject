package controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.websocket.server.PathParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import model.Tweet;
import model.TweetEntity;
import service.TweetEJB;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

@ManagedBean(name="tweetcontroller")
@SessionScoped

@Produces("application/json")
@Path("/usertweet")

public class TweetController {
	@EJB
	TweetEJB tweetservice;
	
	@ManagedProperty(value="#{tweet}")
	
	private Tweet tweet;
    private List<TweetEntity> listOfTweets = new ArrayList<>();
    
	public Tweet getTweet() {
		return tweet;
	}
	public void setTweet(Tweet tweet) {
		this.tweet = tweet;
	}
	public String addNewTweet() throws TwitterException {
		
		System.out.println("Is in use");
		Twitter twitter = getTwitterInstance();
	
		Status status = twitter.updateStatus(tweet.getEntity().getTweetBody());
		
		System.out.println("Is in Use");
		
		tweetservice.addNewTweet(tweet.getEntity());
		
		return status.getText();
	}
	public static Twitter getTwitterInstance() {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		.setOAuthConsumerKey("kOZcnpJ9jab7hkCod6CKzC8KN")
		.setOAuthConsumerSecret("9uQPEvYxLUc8mpNOoj2ISI53jagOthipO6MfIYPjFmnZCdSBfK")
		.setOAuthAccessToken("380848063-Zv52qIuaRUUCtAgtObSqBTjDqCdjFvup6JpmIwis")
		.setOAuthAccessTokenSecret("Fg42FfObRaCDqO7YaPeO356WQgV13oW0H8zQqLYZa7vqh");
		
		
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();
		System.out.println(twitter);
		
		return twitter;
	}
	public List<TweetEntity> getTweetList() {
		listOfTweets = tweetservice.findTweets();

        return listOfTweets;
    }
}
