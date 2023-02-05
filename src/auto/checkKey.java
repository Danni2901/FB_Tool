package auto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class checkKey {
	//Khai bao vi tri file listkeys
	//Kiem tra uuid co tren mysql hay chua
	public boolean cUuid() {
		GetHardwareInfo getHardwareInfo = new GetHardwareInfo();
		boolean bl = false;
		// your code for windows OS.
		System.setProperty("webdriver.chrome.driver", "/Applications/FBTool/chromedriver");
		ChromeOptions options = new ChromeOptions();
		// set chrome as Headless
		options.addArguments("--headless");
		WebDriver driver = new ChromeDriver(options);
		// Link lay key
		driver.get("https://webhostphp29.000webhostapp.com/sendkey/senkey.php?product_check="+getHardwareInfo.printComputerSystemProductInfo());
		// Lay danh sach key tu website
		List<WebElement> elements = driver.findElements(By.cssSelector("h1.uuid"));
		for (int i = 0; i < elements.size(); i++) {
			//Cat chuoi, chi lay key dem so sanh
			String temp = elements.get(i).getText();
			if(temp.equals("Check Successful")) {
				bl = true;
			}else {
				bl = false;
			}
		}
		// close the browser
		driver.close();
		System.out.println(bl);
		return bl;
	}
	//Kiem tra key con han su dung kong
	public boolean cKey(String key) {
		GetHardwareInfo getHardwareInfo = new GetHardwareInfo();
		
		boolean bl = false;
		String keys = key;
		// your code for windows OS.
		System.setProperty("webdriver.chrome.driver", "/Applications/FBTool/chromedriver");
		ChromeOptions options = new ChromeOptions();
		// set chrome as Headless
		options.addArguments("--headless");
		WebDriver driver = new ChromeDriver(options);
		// Link lay key
		driver.get("https://webhostphp29.000webhostapp.com/sendkey/senkey.php?key_active="+keys+"&product_id="+getHardwareInfo.printComputerSystemProductInfo());
		// Lay danh sach key tu website
		List<WebElement> elements = driver.findElements(By.cssSelector("h1.faild"));
		for (int i = 0; i < elements.size(); i++) {
			//Cat chuoi, chi lay key dem so sanh
			String temp = elements.get(i).getText();
			if(temp.equals("Active Successful")) {
				bl = true;
			}else {
				bl = false;
			}
			System.out.println(temp);
		}
		// close the browser
		driver.close();
		System.out.println(bl);
		System.out.println(keys);
		return bl;
	}
}
