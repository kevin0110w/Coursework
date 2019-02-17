import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import com.rometools.rome.io.SyndFeedOutput;
import com.sleepycat.je.EnvironmentLockedException;
import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.parser.TextParseData;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;
import edu.uci.ics.crawler4j.url.WebURL;

/**
 * @author 0808148w 
 * SE - AE1 - This is my class to test 4 defects with sample test data
 * NB to grader, I have come across the following exception from time to time - 
 *    com.sleepycat.je.EnvironmentLockedException: (JE 7.5.11) data\frontier The environment cannot be locked for single writer access. 
 *    ENV_LOCKED: The je.lck file could not be locked. Environment is invalid and must be closed.
 * I have found closing and re-starting Eclipse seems to overcome the problem.
 */
public class MyTest {
	private CrawlConfig config = new CrawlConfig();
	private String crawlStorageFolder = "data/";
	private CrawlController controller;
	private PageFetcher pageFetcher;
	private RobotstxtConfig robotstxtConfig;
	private RobotstxtServer robotstxtServer;
	private List<Object> datas = new ArrayList<Object>();

	/*
	 * Unit Test {@link ${HtmlParseData}#getText}
	 * 
	 * It was observed that the web crawler returned the entire test in lower case letters. The documentation showed 
	 * that the HtmlParseData class is responsible for extracting the page content
	 * 
	 * This test sets a test String with upper and lower case letters in a parse data object using the setText().
	 * It then calls the getText() method and tests whether the output matches the input String. This is not the case
	 * as all upper-case letters are returned in lower case and the assertEquals test evaluates to false. 
	 */
	@Test
	public void testTextFormatting() throws Exception {
		HtmlParseData hpd = new HtmlParseData();
		String test = "ThIs is fOr ThE fIrSt ASSIGNMENT";
		hpd.setText(test);
		assertEquals("Should return 'ThIs is fOr ThE fIrSt ASSIGNMENT' with same formatting exactly", test, hpd.getText());
	}

	/**
	 * Unit Test {@link ${TextParseData}#getText}
	 * 
	 * The web crawler returns the wrong numerical text (i.e. 0 is not returned correctly). 
	 * The documentation showed that the TextParseData class is responsible for extracting the page content that is of 
	 * content type text/plain
	 * 
	 * This test sets a test String with a range of numbers from 0-9 inclusive in a parse data object using 
	 * the setTextContented();
	 * It then calls getTextContent() and tests whether the output matches the input string of numbers. This is not the case
	 * as all 0s are returned as 1s and the assertEquals test evaluates to false
	 */
	@Test
	public void testNumericalText() throws Exception {
		TextParseData textParseData1 = new TextParseData();
		String testString2 = "123456789";
		textParseData1.setTextContent(testString2);
		assertEquals("This should return 123456789", testString2, textParseData1.getTextContent());  
		String testString = "010234567890";
		TextParseData textParseData = new TextParseData();
		textParseData.setTextContent("010234567890");
		assertEquals("This should return 010234567890", testString, textParseData.getTextContent());  
	}

	/*
	 * Unit Test {@link ${CrawlConfig}#getMaxOutgoingLinksToFollow}
	 * 
	 * It was observed that the crawler was not following the correct number of links. The documentation showed that
	 * the CrawlConfig class is responsible for setting/getting the correct number of links to follow
	 * 
	 * This test sets a test number in a crawlconfig object using setMaxOutgoingLinksToFollow().
	 * It then calls the getMaxOutgoingLinksToFollow() and tests whether output & input numbers match..
	 * Passing 5000, 2, 0 as argument for the setter method, expect 5000, 2, 0 but 3 is returned each time - the assertEquals test 
	 * evaluates to false
	 */
	@Test
	public void testNumberOfOutgoingLinks() throws Exception {
		config.setMaxOutgoingLinksToFollow(3); 
		assertEquals("number of links", 3, config.getMaxOutgoingLinksToFollow());
		config.setMaxOutgoingLinksToFollow(5000); 
		assertEquals("number of links", 5000, config.getMaxOutgoingLinksToFollow()); 
//		config.setMaxOutgoingLinksToFollow(2);    
//		assertEquals("number of links", 2, config.getMaxOutgoingLinksToFollow()); 
//		config.setMaxOutgoingLinksToFollow(0); 
//		assertEquals("number of links", 0, config.getMaxOutgoingLinksToFollow()); 
	}

	/**
	 * Unit Test {@link ${WebCrawler}#ProcessPage}
	 * 
	 * The crawler crawled pages it shouldn't have. A website passed to shouldVisit() returns false, yet is processed 
	 *  by the crawler - ("http://www.dcs.gla.ac.uk/~bjorn/sem20172018/ae2private/IDA.html" ). 
	 *  The documentation states that the processPage() in webcrawler class is responsible for processing pages based on shouldVisit(). 
	 * 
	 * Check processPage() by first, passing the url of a specific website to shouldVisit() that causes it to return false;  
	 * save this as a boolean variable. Then check whether the list of processed pages by crawler contains the 
	 * same url website, which it does, showing processPage() did not consult shouldVisit() properly as per documentation, assertEquals test 
	 * evaluates to false.  
	 * 
	 */
	@Test
	public void testVisitPrivateURL() throws Exception {     
		setUp();
		MyCrawler wc = new MyCrawler();
		wc.init(0, controller);
		WebURL privateURL = new WebURL();
		WebURL startingURL = new WebURL();
//		WebURL randomURL = new WebURL();
//		WebURL correctURL = new WebURL();
		startingURL.setURL("http://www.dcs.gla.ac.uk/~bjorn/sem20172018/ae2public/Machine_learning.html");
		privateURL.setURL("http://www.dcs.gla.ac.uk/~bjorn/sem20172018/ae2private/IDA.html");
//		randomURL.setURL("http://www.google.co.uk")
//		correctURL.setURL("http://www.dcs.gla.ac.uk/~bjorn/sem20172018/ae2public/Arthur_Samuel.html")
		Page startingPage = new Page(startingURL);
		boolean shouldItVisit = wc.shouldVisit(startingPage, privateURL); 
		boolean pageVisited = false;
//		boolean shouldItVisit = wc.shouldVisit(startingPage, randomURL);  //  expect false
//		boolean shouldItVisit = wc.shouldVisit(startingPage, correctURL); // expect true
		for (Object data: datas) {
			try {
				@SuppressWarnings("unchecked")
				ArrayList<Page> pages = (ArrayList<Page>) data;
				for (Page page: pages) {
//					if (page.getWebURL().getURL().equals(correctURL.getURL())) {
//					pageVisited = true;
//				}
					if (page.getWebURL().getURL().equals(privateURL.getURL())) {
						pageVisited = true;
					}
//					if (page.getWebURL().getURL().equals(randomURL.getURL())) {
//						pageVisited = true;
//					}
				}
			} catch (ClassCastException e) {
				System.out.println("Unable to extract page data.");
			}
		}
//		Assertion passes as expected
//		assertEquals("Should it process http://www.dcs.gla.ac.uk/~bjorn/sem20172018/ae2public/Arthur_Samuel.html? Did it? ", shouldItVisit, pageVisited); 
//		Assertion passes as expected
//		assertEquals("Should it process http://www.google.co.uk? Did it? ", shouldItVisit, pageVisited);
//		Assertion fails 
		assertEquals("Should it process http://www.dcs.gla.ac.uk/~bjorn/sem20172018/ae2private/IDA.html? Did it? ", shouldItVisit, pageVisited);
	}


	/** 
	 * Set up the configurations for the crawler only required for privateURL test
	 **/

	public void setUp() throws Exception {
		config.setCrawlStorageFolder(crawlStorageFolder);
		config.setIncludeBinaryContentInCrawling(false); 
		config.setMaxDepthOfCrawling(-1); 
		config.setMaxOutgoingLinksToFollow(5000); 
		pageFetcher = new PageFetcher(config);                            
		robotstxtConfig = new RobotstxtConfig();
		robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
		controller = new CrawlController(config, pageFetcher, robotstxtServer);
		controller.addSeed("http://www.dcs.gla.ac.uk/~bjorn/sem20172018/ae2public/Machine_learning.html");
		controller.start(MyCrawler.class, 1);   
		datas = controller.getCrawlersLocalData();
	}
}


