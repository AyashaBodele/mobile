package MobileApplication.mobile;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import utils.AndroidActions;

public class testcases extends BaseClass{
	




	@Test
	public void launchApp() throws MalformedURLException, URISyntaxException {
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"WiFi settings\"]")).click();
		driver.findElement(By.id("android:id/edit")).sendKeys("Ayasha Wifi");
		driver.findElement(By.id("android:id/button1")).click();
	}

	@Test
	public void testLongPressAction() {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId( "Expandable Lists")).click();
		driver.findElement(AppiumBy.accessibilityId( "1. Custom Adapter")).click();
		WebElement ele = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		//longPress(ele);
		assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());
	}
	@Test
	public void scrollToTheElement() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
	    driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
		//scrollToElement("WebView");		
} 
	
	@Test
	public void swipeToElementto() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
		WebElement ele = driver.findElement(By.xpath("(//android.widget.ImageView)[3]"));
		//swipeto(ele,"left");
	    Thread.sleep(2000);
		WebElement ele2 = driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
		//swipeto(ele2,"right");
		 Thread.sleep(2000);
	}
	
	@Test
	public void swipeToElement() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		WebElement ele = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
	//	dragDrop(ele,627,553);
		WebElement text = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text"));
        Assert.assertEquals(text.getText(),"Dropped!");
        DeviceRotation landscape = new DeviceRotation(0,0,90);
		driver.rotate(landscape);
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
       
        
        Activity activity = new Activity("io.appium.android.apis","io.appium.android.apis.preference.DefaultValues");
       ( (JavascriptExecutor)driver).executeScript("mobile: startActivity", ImmutableMap.of("intent","io.appium.android.apis/io.appium.android.apis.preference.DefaultValues"));
       driver.pressKey(new KeyEvent(AndroidKey.BACK));
       driver.pressKey(new KeyEvent(AndroidKey.ENTER));
	}
	
	
	
}
