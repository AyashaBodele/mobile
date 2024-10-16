package MobileApplication.mobile;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import utils.IoSActions;

public class IoSMobileTestcase extends IoSActions{
	
	public IoSMobileTestcase(IOSDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}



	@Test
	public void launchiOSApp() {
		driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
		//driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == 'Confirm / Cancel'`]")).click();
		driver.findElement(AppiumBy.iOSNsPredicateString("name == 'Text Entry'")).click();
		driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeTextField'")).sendKeys("Ayasha");
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == 'OK'`]")).click();
		driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value BEGINSWITH[c] 'Confirm'")).click();
		String message =driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value BEGINSWITH 'A message'")).getText();
		String message2 =driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value ENDSWITH 'complete sentence.'")).getText();
		System.out.println(message);
		System.out.println(message2);
		String value = "A message should be a short, complete sentence.";
		assertEquals(message,value);	
		assertEquals(message2,value);	
	}
	
	
	
	 @Test
	 public void longPressTestcase() throws InterruptedException {
		 driver.findElement(AppiumBy.accessibilityId("Steppers")).click();
		 WebElement ele =  driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == 'Increment'`][3]"));
         driver.executeScript("mobile: touchAndHold", ImmutableMap.of("elementId", ((RemoteWebElement)ele).getId(),
				"duration",2000));
		 Thread.sleep(2000);
	 }
	 
	 
	 @Test
	 public void valueScroll() {
		WebElement ele =  driver.findElement(AppiumBy.accessibilityId("Toolbars"));
		 scrolltoElement(ele,"down","209","660");
	 }
	
	 
	 @Test
	 public void datepicker() {
		 driver.findElement(AppiumBy.accessibilityId("Picker View")).click();;
		 WebElement ele1 = driver.findElement(AppiumBy.accessibilityId("Red color component value"));
		 WebElement ele2 = driver.findElement(AppiumBy.accessibilityId("Green color component value"));
		 WebElement ele3 =  driver.findElement(AppiumBy.accessibilityId("Blue color component value"));
		 ele1.sendKeys("90");
		 ele2.sendKeys("250");
		 ele3.sendKeys("190");
		Assert.assertEquals(ele1.getText(),"90");
		Assert.assertEquals(ele2.getText(),"250");
		Assert.assertEquals(ele3.getText(),"190");
	 }
	 
	 @Test
	 public void sliderOptions() throws InterruptedException {
		WebElement ele = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeSlider[`name == 'AppElem'`]"));
		ele.sendKeys("0%");
		Assert.assertEquals(ele.getAttribute("value"),"0%");
		Thread.sleep(1000);
		ele.sendKeys("1%");
		Assert.assertEquals(ele.getAttribute("value"),"100%");

	 }
	 
	 
	
}
