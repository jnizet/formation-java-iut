package net.champin;


import java.util.*;

import com.ninja_squad.formation.Tweet;
import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat
import static org.mockito.Mockito.*;

/**
 * Unit test for simple App.
 */
public class TweetServiceTest
{
    private TweetService service;

    @Before
    public void setUp() {
        TweetDAO mockDAO = mock(TweetDAO.class);
        when(mockDAO.getTweetsByDates(any(Date.class), any(Date.class)))
                .thenReturn(Tweet.TWEETS);
        this.service = new TweetService(mockDAO);

    }

    @Test
    public void extractSendersWorks() {
        List<String> expected = Arrays.asList(
                "@clacote", "@cedric_exbrayat", "@jbnizet", "@agnes_crepet", "@brian_goetz", "@jbnizet");
        assertThat(service.extractSenders())
                .isEqualTo(expected);
    }

    @Test
    public void extractSendersWithoutDuplicationWorks() {
        List<String> expected = Arrays.asList(
                "@clacote", "@cedric_exbrayat", "@jbnizet", "@agnes_crepet", "@brian_goetz");
        assertThat(service.extractSendersWithoutDuplication())
                .isEqualTo(expected);
    }

    @Test
    public void extractSendersInAlphabeticalOrderWorks() {
        List<String> expected = Arrays.asList(
                "@agnes_crepet", "@brian_goetz", "@cedric_exbrayat", "@clacote", "@jbnizet");
        List<String> got = new ArrayList<>(service.extractSendersInAlphabeticalOrder());
        assertThat(got).isEqualTo(expected);
    }

    /**
     * extrait les tweets contenant un hashtag donn\u00e9, en conservant
     l\u2019ordre
     */
    public void extractTweetsWithHashTagLambda() {
        assertThat(service.extractTweetsWithHashTag("#lambda")).onProperty("id")
    }

    public void extractTweetsWithHashTagAbsent() {
        assertThat(service.extractTweetsWithHashTag("#absent")).isEmpty();
    }

    /**
     * extrait les tweets contenant un
     hashtag donn\u00e9, tri\u00e9s par sender, puis par dateextrait les tweets contenant un
     hashtag donn\u00e9, tri\u00e9s par sender, puis par date
     */
    public void xtestExtractTweetsWithHashTagSortedBySenderAndDate() {
        assert false;
    }

    /**
     *  extrait les tweets contenant
     */
    public void xtestExtractHashTags()  {
        assert false;
    }

    /**
     * extrait les tweets et les range par sender
     */
    public void xtestExtractTweetsBySender() {
        assert false;
    }

    /**
     * extrait les tweets et les range en deux cat\u00e9gories : ceux qui
     contiennent un hashtag donn\u00e9, et ceux qui ne le contiennent pas\uf0b7
     \uf0b7
     */
    public void xtestSplitTweetsForHashTag() {
        assert false;
    }

    /**
     * calcule le nombre total de caract\u00e8res des tweets, ainsi que le
     nombre de caract\u00e8res par tweet

     the map associates to each tweed-id the # of characters in the tweet,
     and to 0 the total number of characters
     */
    public void xtestComputeCharacterStatistics() {
        assert false;
    }

    /**
     * calcule, pour chaque jour entre deux dates donn\u00e9es, le nombre
     de tweets envoy\u00e9 par chaque sender, et les sauvegarde en base de donn\u00e9es (en appelant la
     m\u00e9thode saveDailyStats)
     */
    public void xtestComputeAndSaveDailyStats() {
        assert false;
    }

}
