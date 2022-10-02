package files;

import java.io.File;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FileDownload {
	
	static By downloadButton = By.id("js-download-hero");
	
	public void fileDownload(String fileName, WebDriver driver, WebElement e) {
		File file = new File(System.getProperty("user.dir") + "\\"+fileName);
	   if (file.exists())
	       file.delete();
		e.click();
				
	}
	
	public void waitForDownload(String fileName, WebDriver driver) throws InterruptedException {
		final int SLEEP_TIME_MILLIS = 1000;
	    final int timeout = 60* SLEEP_TIME_MILLIS;
	    int timeElapsed = 0;
	    File file = new File(System.getProperty("user.dir") + "\\"+fileName);
	    while (timeElapsed<timeout){
	        if (file.exists()) {
	        	System.out.println(fileName + " is present");
	        	break;
	           
	        } else {
	            timeElapsed +=SLEEP_TIME_MILLIS;
	            Thread.sleep(SLEEP_TIME_MILLIS);
	        }
	    }
	}
	
	public static void main (String args[])  {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> chromePref = new HashMap<>();
		chromePref.put("download.default_directory", System.getProperty("user.dir"));
		chromePref.put("download.prompt_for_download", false);
		chromePref.put("safebrowsing.enabled", "true");
		options.setExperimentalOption("prefs", chromePref);
	    WebDriver driver = new ChromeDriver(options);
	    driver.get("https://www.google.com/intl/en_sg/chrome/");
	    FileDownload f = new FileDownload();
	    f.fileDownload("ChromeSetup.exe", driver,driver.findElement(downloadButton));
	    try {
			f.waitForDownload("ChromeSetup.exe", driver);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    driver.close();
	    driver.quit();
	    

}
}
