package net.champin;

import com.ninja_squad.formation.Tweet;
import com.ninja_squad.formation.DailyStats;
import java.util.Date;
import java.util.List;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created with IntelliJ IDEA.
 * User: pa
 * Date: 6/19/13
 * Time: 2:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class TweetDAO {
    /**
     * List all tweets between d1 and d2 (included).
     */
    public List<Tweet> getTweetsByDates(Date d1, Date d2) {
        throw new NotImplementedException();
    };

    /**
     * Store stats in the database.
     */
    public void storeDailyStats(DailyStats stats) {
        throw new NotImplementedException();
    }
}
