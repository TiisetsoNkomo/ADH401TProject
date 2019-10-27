package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="tweet")
@SessionScoped

public class Tweet {
	private String tweetBody;
	private Date date;
	private int tweetId;
	
	public String getTweetBody() {
		return tweetBody;
	}
	public void setTweetBody(String tweetBody) {
		this.tweetBody = tweetBody;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd '-T' HH:mm:ss z");
		Date datet = new Date(System.currentTimeMillis());
		
		this.date = datet;
	}
	public int getTweetId() {
		return tweetId;
	}
	public void setTweetId(int tweetId) {

		this.tweetId = tweetId;
	}
	public TweetEntity getEntity() {
		
		TweetEntity tweetEntity = new TweetEntity();
		tweetEntity.setId(tweetId);
		tweetEntity.setTweetBody(tweetBody);
		tweetEntity.setDate(date);
		
		return tweetEntity;
	}
}
