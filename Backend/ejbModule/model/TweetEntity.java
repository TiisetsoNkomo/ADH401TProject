package model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="tweet_tbl")

public class TweetEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long Id;
	private String tweetBody;
	private Date date;

	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
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
}
