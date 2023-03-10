package auto;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class checkKey {
	public boolean cUuid() {
		//Check MAC address on Database
		GetHardwareInfo getHardwareInfo = new GetHardwareInfo();
		boolean bl = false;
		// your code for windows OS, Extract link WebDriver in Local
		System.setProperty("webdriver.chrome.driver", "C:\\FB_Tool\\chromedriver.exe");
		// New Option for Driver
		ChromeOptions options = new ChromeOptions();
		// set Chrome as Headless
		options.addArguments("--headless");
		WebDriver driver = new ChromeDriver(options);
		// Get key Link
		driver.get("https://webhostphp29.000webhostapp.com/sendkey/senkey.php?product_check="+getHardwareInfo.printComputerSystemProductInfo());
		//Get List Key on API
		List<WebElement> elements = driver.findElements(By.cssSelector("h1.uuid"));
		for (WebElement element : elements) {
			//Get Single Key and Compare
			String temp = element.getText();
			if(temp.equals("Check Successful")) {
				bl = true;
			}else {
				bl = false;
			}
		}
		// close the browser
		driver.close();
		//Print debug
		System.out.println(bl);
		return bl;
	}
	//Check key
	public boolean cKey(String key) {
		GetHardwareInfo getHardwareInfo = new GetHardwareInfo();
		boolean bl = false;
		String keys = key;
		// your code for windows OS.Extract link WebDriver in Local
		System.setProperty("webdriver.chrome.driver", "C:\\FB_Tool\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		// set chrome as Headless
		options.addArguments("--headless");
		WebDriver driver = new ChromeDriver(options);
		// Get key Link
		driver.get("https://webhostphp29.000webhostapp.com/sendkey/senkey.php?key_active="+keys+"&product_id="+getHardwareInfo.printComputerSystemProductInfo());
		//Get List key Link
		List<WebElement> elements = driver.findElements(By.cssSelector("h1.faild"));
		for (WebElement element : elements) {
			//Cut, get Sigle Key and copmpare
			String temp = element.getText();
			if(temp.equals("Active Successful")) {
				bl = true;
			}else {
				bl = false;
			}
			System.out.println(temp);
		}
		// close the browser
		driver.close();
		//Print Debug
		System.out.println(bl);
		System.out.println(keys);
		return bl;
	}
}
