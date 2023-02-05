package auto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.server.browserlaunchers.DrivenSeleniumLauncher;


public class comment {

	public static void main(String funame, String fpword, String fid, String delaytime, String fcmt, String numpost)
			throws InterruptedException {
		// TODO Auto-generated method stub
		String cmt = fcmt;
		// Cat chuoi luu vao mang
		String[] arrCmt = cmt.split("\\/");

		// set value
		int numPost = (Integer.parseInt(numpost) / 7);// number of for loop
		int numCmt = arrCmt.length;
		String username = funame;
		String password = fpword;
		String groupid = fid;
		int delay = Integer.parseInt(delaytime) * 1000;
		String link ="";
		System.setProperty("webdriver.chrome.driver", "/Applications/FBTool/chromedriver");
		// only chrome version 105.0.5
		ChromeOptions options = new ChromeOptions();
		// set chrome as Headless
		options.addArguments("--headless");
		WebDriver driver = new ChromeDriver(options);
		// get link
		driver.get("https://www.facebook.com/");
		Thread.sleep(delay);
		// set data
		WebElement emailTxt = driver.findElement(By.name("email"));
		WebElement passTxt = driver.findElement(By.name("pass"));

		emailTxt.sendKeys(username);
		passTxt.sendKeys(password);
		Thread.sleep(delay);
		emailTxt.submit();

		Thread.sleep(delay);
		driver.get("https://m.facebook.com/groups/" + groupid);
		Thread.sleep(delay);
		Random rd = new Random();
		for (int j = 0; j < numPost; j++) {
			List<WebElement> elements = driver.findElements(By.cssSelector("a[data-click*='click_comment_ufi']"));
			Thread.sleep(delay);
			for (int i = 1; i <= 7 ; i++) {
				// get link
				 link = elements.get(i).getAttribute("href");
				// open add friend new tab
				((JavascriptExecutor) driver).executeScript("window.open('" + link + "','_blank');");
				Thread.sleep(delay);
				// close new tab
				ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(tabs.get(1));
				// Random trong mang
				int value = rd.nextInt(numCmt);
				// Gan noi dung cmt len input va submit
				WebElement cmtTxt = driver.findElement(By.id("composerInput"));
				cmtTxt.sendKeys(arrCmt[value]);
				cmtTxt.submit();
				Thread.sleep(delay);
				
				// Xong phien lam viec, dong cua so hien tai
				driver.close();
				// back line tab main
				driver.switchTo().window(tabs.get(0));
				Thread.sleep(delay);
			}
			//sang mbasic moi
			String linkht = driver.getCurrentUrl();
			 String linkmbasic = (AddCharAt(linkht, 9));
		     driver.get(linkmbasic);
		     //chuyen page
			Thread.sleep(delay);
			WebElement newpost = driver.findElement(By.xpath("//*[@id=\"m_group_stories_container\"]/div/a"));
			String refest = newpost.getAttribute("href");
			driver.get(refest);
			
			//get url hien tai chuyen sang m.fb
			Thread.sleep(delay);
			String link2 = driver.getCurrentUrl();
		    String newlink = (removeCharAt(link2, 9));
		    driver.get(newlink);
		}
		driver.close();
	}
	  public static String removeCharAt(String s, int pos) {
	      return s.substring(0, pos) + s.substring(pos + 5);
	   }
	 
    
      public static String AddCharAt(String s, int pos) {
	      return  "https://mbasic" + s.substring(pos + 0);
	   }

}
