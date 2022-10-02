package files;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileUpload {
	By addFileButton     = By.xpath(".//input[@type='file']");
	By startUploadButton = By.xpath(".//span[text()='Start upload']");
	By editButton        = By.xpath(".//span[text()='Edit']");
	By deleteButton      = By.xpath(".//span[text()='Delete']");
	
	public void uploadFile (String fileName, WebDriver driver) {
		
		driver.findElement(addFileButton).sendKeys(System.getProperty("user.dir")+"\\"+ fileName);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(editButton)));
		driver.findElement(startUploadButton).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(deleteButton));
		if(driver.findElement(By.xpath("//a[text()='"+fileName+"']")).isDisplayed()) {
			System.out.println("File uploaded");
		}else {
			System.out.println("File not uploaded");
		}
		
	}
	
	public static void main (String args[]) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		driver.manage().window().maximize();
		FileUpload f = new FileUpload();
		f.uploadFile("download.png",driver);
		

}
}
