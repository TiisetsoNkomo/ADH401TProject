package service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.TweetEntity;

/**
 * Session Bean implementation class TweetEJB
 */
@Stateless
@LocalBean
public class TweetEJB {

	@PersistenceContext
	private EntityManager em;
	
    public TweetEJB() {
        // TODO Auto-generated constructor stub
    }
    public void addNewTweet(TweetEntity tweetentity) {
    	System.out.println("==========================Adding Tweet to Database==========================");
    	em.persist(tweetentity);
    }
    public List<TweetEntity> findTweets() {
    	
    	System.out.println("==========================Retrieving Tweets to Database==========================");
        List<TweetEntity> Listweet = em.createQuery("Select * from  tweet_tbl ",TweetEntity.class).getResultList();
        
        return Listweet;
        }
}
