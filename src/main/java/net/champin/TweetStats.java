package net.champin;

/**
 * Created with IntelliJ IDEA.
 * User: pa
 * Date: 6/19/13
 * Time: 2:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class TweetStats {
    private long total;
    private long average;

    public long getTotal() {
        return total;
    }

    public long getAverage() {
        return average;
    }

    public TweetStats(long total, long average) {
        this.total = total;
        this.average = average;
    }

}
