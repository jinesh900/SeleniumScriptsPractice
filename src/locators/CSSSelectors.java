package locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSSelectors {
	
	public static WebElement selectByCssSelector(WebDriver driver, String text, int elementNum) {
		List<WebElement> el = driver.findElements(By.cssSelector(text));
		return el.get(elementNum);
		
	}

	public static WebElement selectByCssSelector(WebDriver driver, String text) {
		return driver.findElement(By.cssSelector(text));
		
	}

	
	public static void main (String args[]) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.openmrs.org/openmrs/login.htm");
		driver.manage().window().maximize();
		//<input class="form-control form-control-sm form-control-lg form-control-md" id="username" type="text" name="username" placeholder="Enter your username">
		//syntax for CSS selector with ID attribute tag#id
		CSSSelectors.selectByCssSelector(driver, "input#username").sendKeys("input#username");
		Thread.sleep(2000);
		CSSSelectors.selectByCssSelector(driver, "input#username").clear();
		
		/*<legend class="w-auto">
                                <i class="icon-lock small"></i>
                                Login
                            </legend>*/
		//syntax for CSS selector with class attribute tag.id
		String txt = (CSSSelectors.selectByCssSelector(driver, "legend.w-auto").getText());
		CSSSelectors.selectByCssSelector(driver, "input#username").sendKeys(txt);
		Thread.sleep(3000);
		CSSSelectors.selectByCssSelector(driver, "input#username").clear();
		
		//<input class="form-control form-control-sm form-control-lg form-control-md" id="username" type="text" name="username" placeholder="Enter your username">
		//syntax for CSS selector with other attributes tag[attribute=value]
		CSSSelectors.selectByCssSelector(driver, "input[name=username]").sendKeys("By Attribute");
		Thread.sleep(2000);
		CSSSelectors.selectByCssSelector(driver, "input#username").clear();
		
		//<input class="form-control form-control-sm form-control-lg form-control-md" id="username" type="text" name="username" placeholder="Enter your username">
		//<input class="form-control form-control-sm form-control-lg form-control-md" id="password" type="password" name="password" placeholder="Enter your password">
		//Syntax for substring contains tag[atrribute*='substring']
		CSSSelectors.selectByCssSelector(driver, "input[class*='form-control-lg']",0).sendKeys("input.class");
		CSSSelectors.selectByCssSelector(driver, "input[class*='form-control-lg']",1).sendKeys("input.classPW");
		
		//<i class="fa fa-eye" id="togglePassword"></i>
		//<i class="fa fa-eye-slash" id="togglePassword"></i>
		//Syntax for substring starts with tag[atrribute^='substring']
		CSSSelectors.selectByCssSelector(driver, "i[class^='fa']").click();
		Thread.sleep(5000);
		CSSSelectors.selectByCssSelector(driver, "i[class^='fa']").click();
		Thread.sleep(2000);
		CSSSelectors.selectByCssSelector(driver, "input[class*='form-control-lg']",0).clear();
		CSSSelectors.selectByCssSelector(driver, "input[class*='form-control-lg']",1).clear();
		
		//input class="form-control form-control-sm form-control-lg form-control-md" id="username" type="text" name="username" placeholder="Enter your username">
		//<input class="form-control form-control-sm form-control-lg form-control-md" id="password" type="password" name="password" placeholder="Enter your password">
		//Syntax for substring ends with tag[atrribute$='substring']
		CSSSelectors.selectByCssSelector(driver, "input[class$='form-control-md']",0).sendKeys("input.classMD");
		CSSSelectors.selectByCssSelector(driver, "input[class*='form-control-md']",1).sendKeys("input.classPWMD");
		CSSSelectors.selectByCssSelector(driver, "i[class^='fa']").click();
		Thread.sleep(5000);
		CSSSelectors.selectByCssSelector(driver, "i[class^='fa']").click();
		CSSSelectors.selectByCssSelector(driver, "input[class*='form-control-lg']",0).clear();
		CSSSelectors.selectByCssSelector(driver, "input[class*='form-control-lg']",1).clear();
		
		/*<p class="left">
               <label for="username">
                      Username:
                </label>
                <input class="form-control form-control-sm form-control-lg form-control-md" id="username" type="text" name="username" placeholder="Enter your username">
          </p>*/
		//Syntax for direct child cssSelectorOfParent>child_tag
		CSSSelectors.selectByCssSelector(driver, "p.left>input",0).sendKeys("direct Child un");
		CSSSelectors.selectByCssSelector(driver, "p.left>input",1).sendKeys("direct Child pw");
		CSSSelectors.selectByCssSelector(driver, "i[class^='fa']").click();
		Thread.sleep(5000);
		
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
		//Syntax for nth child cssSelectorOfParent tagOfChild:nth-child(childNumber)
		CSSSelectors.selectByCssSelector(driver, "ul#sessionLocation li:nth-child(3)").click();
		Thread.sleep(5000);
		CSSSelectors.selectByCssSelector(driver, "ul#sessionLocation li:nth-child(5)").click();
}
}

