import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;

// Test task "douglas" for Josh's customer
// first version as an "all-in-one" class solution - not a realy framework, pom
// SDET: Volkan Akin (Github: volkan-dev)

public class BrowserTest {

	public static void main(String[] args) {
		parfumTesting();

	}

	public static void parfumTesting()	{

		/**
		 * Attention:
		 * 
		 * if not as a maven rep. project, starting with driver setups.
		 * 
		 * e.g. /drivers Firefox: geckodriver only in case of using the firefox version
		 * 47 or above System.setProperty("webdriver.gecko.driver",
		 * "C:\\Users\\LENOVO\\eclipse-workspace\\automation\\selenium\\SeleniumJavaFramework\\drivers\\geckodriverFirefox\\geckodriver.exe");
		 * ------------------------------------- generic for location independency:
		 * String projectPath = System.getProperty("user.dir"); System.out.println("the
		 * projectPath is: " + projectPath);
		 * System.setProperty("webdriver.gecko.driver", projectPath +
		 * "\\drivers\\geckodriverFirefox\\geckodriver.exe");
		 * 
		 * OR
		 * 
		 * with WebDriverManager as maven rep.
		 * 
		 * OR
		 * 
		 * as maven repo like below | all-in
		 */

		// Browsers: imports are separately or automatically.
		// --------------------------------------------------

		// 1. Browser: Mozilla Firefox
		WebDriver driver = new FirefoxDriver();

		// 2. Browser: Google Chrome
		// WebDriver driver = new ChromeDriver();

		// 3. Browser: Microsoft Internet Explorer / Edge
		// WebDriver driver = new InternetExplorerDriver();

		// --------------------------------------------------

		// window maximizer
		// driver.manage().window().maximize();

		// ############ POINT 1: navigation to the douglas site ############

		// invokig the URL
		driver.get("https://www.douglas.de/de");

		// window appear for 6k milliseconds (6 seconds) before closing
		// for waiting in case of bad internet connection
		// a wait especially for some cookies window etc.
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// does not work with ie. / edge!

		// ############ POINT 2: cookie handling ############

		// finding / identification of an element
		// e.g. as an cssSelector locator / selector
		// and save it as a variable for WebElement.
		WebElement cookieAccepting = driver
				.findElement(By.cssSelector("button[class='button button__secondary uc-list-button__deny-all']"));
		cookieAccepting.click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// ############ POINT 3: click on a top menu selection "Parfum" ############

		// finding the element via XPath
		driver.findElement(By.xpath("//a[normalize-space()='PARFUM']")).click();
		driver.navigate().refresh();
		// driver.quit(); to close for all running chrome browsers.

		// closing the current browser window.
		// driver.close();

		System.out.println("Test is done: successful");
	}
}