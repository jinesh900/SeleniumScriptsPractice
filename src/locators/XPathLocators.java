package locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathLocators {
	
	public static WebElement selectByXPath(WebDriver driver, String text, int elementNum) {
		List<WebElement> el = driver.findElements(By.xpath(text));
		return el.get(elementNum);
		
	}

	public static WebElement selectByXPath(WebDriver driver, String text) {
		return driver.findElement(By.xpath(text));
		
	}
	
	public static void main (String args[]) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.openmrs.org/openmrs/login.htm");
		driver.manage().window().maximize();
		
		//<input class="form-control form-control-sm form-control-lg form-control-md" id="username" type="text" name="username" placeholder="Enter your username">
		//syntax for xPath with attribute //tagname[@attribute='value']
		XPathLocators.selectByXPath(driver, "//input[@id='username']").sendKeys("username by property");
		Thread.sleep(3000);
		XPathLocators.selectByXPath(driver, "//input[@id='username']").clear();
		
		//<input class="form-control form-control-sm form-control-lg form-control-md" id="username" type="text" name="username" placeholder="Enter your username">
		//<input class="form-control form-control-sm form-control-lg form-control-md" id="password" type="password" name="password" placeholder="Enter your password">
		//syntax for xPath with contains //tagname[contains(@attribute,'match string')]
		XPathLocators.selectByXPath(driver, "//input[contains(@class,'form-control-lg')]", 0).sendKeys("Contains username");
		XPathLocators.selectByXPath(driver, "//input[contains(@class,'form-control-lg')]", 1).sendKeys("Contains password");
		Thread.sleep(3000);
		
		//<i class="fa fa-eye" id="togglePassword"></i>
		//<i class="fa fa-eye-slash" id="togglePassword"></i>
		//Syntax for substring starts with //tag[starts-with(@attribute,'match string')]
		XPathLocators.selectByXPath(driver,"//i[starts-with(@class,'fa')]").click();
		Thread.sleep(3000);
		XPathLocators.selectByXPath(driver,"//i[starts-with(@class,'fa')]").click();
		Thread.sleep(3000);
		XPathLocators.selectByXPath(driver, "//input[contains(@class,'form-control-lg')]", 0).clear();
		XPathLocators.selectByXPath(driver, "//input[contains(@class,'form-control-lg')]", 1).clear();
		
		//<input class="form-control form-control-sm form-control-lg form-control-md" id="username" type="text" name="username" placeholder="Enter your username">
		//<input class="form-control form-control-sm form-control-lg form-control-md" id="password" type="password" name="password" placeholder="Enter your password">
		//syntax for get one item by index (//<xpath returns multiple elements)[index num]
		XPathLocators.selectByXPath(driver, "(//input[contains(@class,'form-control-lg')])[1]").sendKeys("un index");
		XPathLocators.selectByXPath(driver, "(//input[contains(@class,'form-control-lg')])[2]").sendKeys("pw index");
		Thread.sleep(3000);
		XPathLocators.selectByXPath(driver,"//i[starts-with(@class,'fa')]").click();
		Thread.sleep(3000);
		XPathLocators.selectByXPath(driver,"//i[starts-with(@class,'fa')]").click();
		XPathLocators.selectByXPath(driver, "(//input[contains(@class,'form-control-lg')])[1]").clear();
		XPathLocators.selectByXPath(driver, "(//input[contains(@class,'form-control-lg')])[2]").clear();
		
		//xpath with logical operators
		//OR
		//<input class="form-control form-control-sm form-control-lg form-control-md" id="username" type="text" name="username" placeholder="Enter your username">
		//<input class="form-control form-control-sm form-control-lg form-control-md" id="password" type="password" name="password" placeholder="Enter your password">
		//syntax to OR logic //tag[xpath1 or xpath2]
		XPathLocators.selectByXPath(driver, "//input[@id='username' or contains(@placeholder,'password')]",0).sendKeys("un by id");
		XPathLocators.selectByXPath(driver, "//input[@id='username' or contains(@placeholder,'password')]",1).sendKeys("pw by placeholder");
		XPathLocators.selectByXPath(driver,"//i[starts-with(@class,'fa')]").click();
		Thread.sleep(3000);
		XPathLocators.selectByXPath(driver,"//i[starts-with(@class,'fa')]").click();
		XPathLocators.selectByXPath(driver, "//input[@id='username']").clear();
		XPathLocators.selectByXPath(driver, "//input[@id='password']").clear();
		//AND
		//input[contains(@class,'form-control-lg') and contains(@placeholder,'username')]
		//syntax to OR logic //tag[xpath1 and xpath2]
		XPathLocators.selectByXPath(driver, "//input[contains(@class,'form-control-lg') and contains(@placeholder,'username')]").sendKeys("un AND");
		XPathLocators.selectByXPath(driver, "//input[contains(@class,'form-control-lg') and contains(@placeholder,'password')]").sendKeys("pw AND");
		XPathLocators.selectByXPath(driver,"//i[starts-with(@class,'fa')]").click();
		Thread.sleep(3000);
		XPathLocators.selectByXPath(driver,"//i[starts-with(@class,'fa')]").click();
		XPathLocators.selectByXPath(driver, "//input[@id='username']").clear();
		XPathLocators.selectByXPath(driver, "//input[@id='password']").clear();
		
		//traverse with relationships
		//following
		//when you can identify an element uniquely then you get get all elements after that with parlicular tag
		/*
		 * <ul id="sessionLocation" class="select">
                                    
                                    <li id="Inpatient Ward" tabindex="0" value="6" data-key="0" class="selected">Inpatient Ward</li>
                                    
                                    <li id="Isolation Ward" tabindex="0" value="4" data-key="1">Isolation Ward</li>
                                    
                                    <li id="Laboratory" tabindex="0" value="3" data-key="2">Laboratory</li>
                                    
                                    <li id="Outpatient Clinic" tabindex="0" value="7" data-key="3">Outpatient Clinic</li>
                                    
                                    <li id="Pharmacy" tabindex="0" value="2" data-key="4">Pharmacy</li>
                                    
                                    <li id="Registration Desk" tabindex="0" value="5" data-key="5">Registration Desk</li>
                                    
                                </ul>
		 */
		//syntax <path to element>//following::tagname to get all elements
		//syntax <path to element>//following::tagname<xpath> to get a particular element
		XPathLocators.selectByXPath(driver,"//ul[@id='sessionLocation']//following::input[2]").click();
		Thread.sleep(3000);
		
		//following-sibling
		//when you can identify an element uniquely then you get elements at the same hierarchy level with this
		XPathLocators.selectByXPath(driver,"//li[contains(@id,'Isolation')]//following-sibling::li[1]").click();
		Thread.sleep(3000);
		
		//Preceding
		//syntax <path to element>//preceding::tagname to get all elements
		XPathLocators.selectByXPath(driver,"//ul[@id='sessionLocation']//preceding::input[2]").sendKeys("preceding un");
		XPathLocators.selectByXPath(driver,"//ul[@id='sessionLocation']//preceding::input[1]").sendKeys("preceding pw");
		XPathLocators.selectByXPath(driver,"//i[starts-with(@class,'fa')]").click();
		Thread.sleep(3000);
		XPathLocators.selectByXPath(driver,"//i[starts-with(@class,'fa')]").click();
		XPathLocators.selectByXPath(driver, "//input[@id='username']").clear();
		XPathLocators.selectByXPath(driver, "//input[@id='password']").clear();
		
		//preceding-sibling
		XPathLocators.selectByXPath(driver,"//li[contains(@id,'Outpatient')]//preceding-sibling::li[1]").click();
		Thread.sleep(3000);
		
		//child
		//to identify a child element
		XPathLocators.selectByXPath(driver,"//ul[@id='sessionLocation']//child::li[5]").click();
		Thread.sleep(3000);
		
		//parent
		//to identify a parent element
		String t2 = XPathLocators.selectByXPath(driver,"//li[contains(@id,'Outpatient')]//parent::ul").getAttribute("class");
		XPathLocators.selectByXPath(driver, "//input[@id='username']").sendKeys(t2);
		Thread.sleep(3000);
		XPathLocators.selectByXPath(driver, "//input[@id='username']").clear();
		
		//descendant
		//to identify children and grand children
		XPathLocators.selectByXPath(driver,"//fieldset//descendant::li[4]").click();
		Thread.sleep(3000);
		
		//Ancestor
		//to identify parent and grand parent
		String t3 = XPathLocators.selectByXPath(driver,"//li[contains(@id,'Outpatient')]//ancestor::form").getText();
		XPathLocators.selectByXPath(driver, "//input[@id='username']").sendKeys(t3);
		Thread.sleep(3000);
		XPathLocators.selectByXPath(driver, "//input[@id='username']").clear();
		
		driver.quit();
	}		

}
