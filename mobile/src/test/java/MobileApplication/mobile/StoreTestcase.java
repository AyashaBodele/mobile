package MobileApplication.mobile;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import utils.AndroidActions;

public class StoreTestcase extends BaseClass{
	

	@Test
	public void fillForm() throws InterruptedException {
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		String message = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		Assert.assertEquals(message,"Please enter your name");
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Ayasha Bodele");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("android:id/text1")).click();
		
		String country = "Argentina";
        WebElement ele = driver.findElement(AppiumBy.androidUIAutomator( "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().text(\"" + country + "\"))"));

        ele.click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        Thread.sleep(2000);
        
        String product = "Jordan 6 Rings";
        driver.findElement(AppiumBy.androidUIAutomator( "new UiScrollable(new UiSelector().scrollable(true))" +
                ".scrollIntoView(new UiSelector().text(\"" + product + "\"))"));
        
        int count = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
        
        for(int i= 0; i <count;i++) {
        	
        String name=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
        if (name.equalsIgnoreCase("Jordan 6 Rings")){
        	
        	driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
        }
        
        }        
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains(driver.findElement
        		(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
        
 
        Assert.assertEquals(driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText(), "Jordan 6 Rings");
	}
	
		
}



