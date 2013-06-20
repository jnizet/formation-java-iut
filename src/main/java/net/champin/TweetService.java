package net.champin;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import com.ninja_squad.formation.Tweet;

import java.util.*;

/**
 * A service offering various views on a list of tweets.
 *
 * Created with IntelliJ IDEA.
 * User: pa
 * Date: 6/19/13
 * Time: 2:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class TweetService {

    private TweetDAO dao;
    private int ndays;

    /**
     * Construct a TweetService over all tweets provided by dao in the last ndays days.
     * @param dao the TweetDAO providing the tweets
     * @param ndays the size of the temporal window to use (in days)
     */
    public TweetService(TweetDAO dao, int ndays) {
        this.dao = dao;
        this.ndays = ndays;
    }

    /**
     * Construct a TweetService over all tweets provided by dao in the last 30 days.
     * @param dao the TweetDAO providing the tweets
     */
    public TweetService(TweetDAO dao) {
        this(dao, 30);
    }

    private List<Tweet> getTweets() {
        Date d2 = new Date();
        Date d1 = new Date(d2.getTime()-ndays*24*3600*1000);
        return dao.getTweetsByDates(d1, d2);
    }

    /**
     * extrait les senders des tweets, dans le m\u00eame ordre que les tweets
     */
    public List<String> extractSenders() {
        List<Tweet> tweets = getTweets();
        ArrayList<String> senders = new ArrayList<>(tweets.size());
        for (Tweet tweet: tweets) {
            senders.add(tweet.getSender());
        }
        return senders;
    }

    /**
     * extrait les senders des tweets, dans le m\u00eame ordre que
     les tweets, mais sans duplicata
     Pour chaque sender, on garde uniquement sa première apparition.
     */
    public List<String> extractSendersWithoutDuplication() {
        List<Tweet> tweets = getTweets();
        HashSet<String> present = new HashSet<>();
        ArrayList<String> senders = new ArrayList<>(tweets.size());
        for (Tweet tweet: tweets) {
            String sender = tweet.getSender();
            if (! present.contains(sender)) {
                senders.add(sender);
                present.add(sender);
            }
        }
        return senders;
    }

    /**
     * extrait les senders des tweets, sans duplicata, et tri\u00e9s
     par ordre alphab\u00e9tique
     */
    public SortedSet<String> extractSendersInAlphabeticalOrder() {
        TreeSet<String> senders = new TreeSet<>();
        for (Tweet tweet: getTweets()) {
            senders.add(tweet.getSender());
        }
        return senders;
    }

    /**
     * extrait les tweets contenant un hashtag donn\u00e9, en conservant
     l\u2019ordre
     * @param hashtag the hashtag to look for, with a leading <code>#</code>
     */
    public List<Tweet> extractTweetsWithHashTag(String hashtag) {
        ArrayList<Tweet> tweetsWithHashTag = new ArrayList();
        for(Tweet tweet: getTweets()) {
            if (tweet.containsHashTag(hashtag)) {
                tweetsWithHashTag.add(tweet);
            }
        }
        return tweetsWithHashTag;
    }

    /**
     * extrait les tweets contenant un
     hashtag donn\u00e9, tri\u00e9s par sender, puis par dateextrait les tweets contenant un
     hashtag donn\u00e9, tri\u00e9s par sender, puis par date
     */
    public SortedSet<Tweet> extractTweetsWithHashTagSortedBySenderAndDate(String hashtag) {
        throw new NotImplementedException();
    }

    /**
     *  extrait les hashtags des tweets
     */
    public Set<String> extractHashTags()  {
        throw new NotImplementedException();
    }

    /**
     * extrait les tweets et les range par sender
     */
    public Map<String, List<Tweet>> extractTweetsBySender() {
        throw new NotImplementedException();
    }

    /**
     * extrait les tweets et les range en deux cat\u00e9gories : ceux qui
     contiennent un hashtag donn\u00e9, et ceux qui ne le contiennent pas\uf0b7
     \uf0b7
     */
    public Map<Boolean, List<Tweet>> splitTweetsForHashTag(String hashtag) {
        throw new NotImplementedException();
    }

    /**
     * calcule le nombre total de caract\u00e8res des tweets, ainsi que le
     nombre moyen de caract\u00e8res par tweet

     the map associates to each tweed-id the # of characters in the tweet,
     and to 0 the total number of characters
     */

    public TweetStats computeCharacterStatistics() {
        throw new NotImplementedException();
    }

    /**
     * calcule, pour chaque jour entre deux dates donn\u00e9es, le nombre
     de tweets envoy\u00e9 par chaque sender, et les sauvegarde en base de donn\u00e9es (en appelant la
     m\u00e9thode saveDailyStats)
     */
    public void computeAndSaveDailyStats(Date d1, Date d2) {
        throw new NotImplementedException();
    }

}
