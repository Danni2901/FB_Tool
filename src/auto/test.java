package auto;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.JavascriptExecutor;

public class test {

	public static void main(String funame, String fpword, String fid, String num, String delaytime) throws Exception {

		// set value
		String username = funame;
		String password = fpword;
		String groupid = fid;
		int maxmem = Integer.parseInt(num) / 30; // max member in for loop
		int delay = Integer.parseInt(delaytime); // delay step
		delay = delay * 1000;
		String link = "";
		String linkview = "";
		System.setProperty("webdriver.chrome.driver", "/Applications/FBTool/chromedriver");
		// Using get() method to open a web page
		//ChromeOptions options = new ChromeOptions();
		// set chrome as Headless
		//options.addArguments("--headless");
		WebDriver driver = new ChromeDriver();
		// get link
		driver.get("https://www.facebook.com/");
		Thread.sleep(delay);
		// set data
		WebElement emailTxt = driver.findElement(By.name("email"));
		WebElement passTxt = driver.findElement(By.name("pass"));
		if (emailTxt != null && passTxt != null) {
			emailTxt.sendKeys(username);
			passTxt.sendKeys(password);
			Thread.sleep(delay);
			emailTxt.submit();
		}
		Thread.sleep(delay);

		driver.get("https://mbasic.facebook.com/groups/" + groupid + "/members");
		Thread.sleep(delay);
		driver.get("https://mbasic.facebook.com/browse/group/members/?id=" + groupid
				+ "&start=0&listType=list_nonfriend_nonadmin");
		for (int j = 0; j < maxmem; j++) {

			Thread.sleep(delay);
			List<WebElement> elements = driver.findElements(By.linkText("Add Friend"));
			for (int i = 0; i < elements.size(); i++) {
				// get link
				link = elements.get(i).getAttribute("href");
				// open add friend new tab
				((JavascriptExecutor) driver).executeScript("window.open('" + link + "','_blank');");
				Thread.sleep(delay);
				// close new tab
				ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(tabs.get(1));
				driver.close();
				// back line tab main
				driver.switchTo().window(tabs.get(0));
				Thread.sleep(delay);
			}
			List<WebElement> view = driver.findElements(By.cssSelector("a[href*='start']"));
			linkview = view.get(0).getAttribute("href");
			driver.get(linkview);
			Thread.sleep(delay);
		}
		driver.close();
	}
}
