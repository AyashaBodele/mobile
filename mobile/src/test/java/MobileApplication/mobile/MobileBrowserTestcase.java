package MobileApplication.mobile;



import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class MobileBrowserTestcase extends BrowserBaseClass{
	
	@Test
	public void browser() throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("span[class='navbar-toggler-icon']")).click();     
		driver.findElement(By.cssSelector("a[routerlink*='products']")).click();  
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,1000)", "");
		String text =driver.findElement(By.cssSelector("a[href*='/products/3']")).getText();  
		assertEquals(text,"Devops");
	}		
}



