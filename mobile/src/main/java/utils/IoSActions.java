package utils;



import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.ios.IOSDriver;


public class IoSActions extends AppiumUtils {
	
	public IOSDriver  driver;
	public IoSActions(IOSDriver driver) {
		this.driver=driver;
	}
		
	public void longPressOniOS(WebElement ele) {
		driver.executeScript("mobile: touchAndHold", ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),
				"duration",2000));
	}
	
	public void scrolltoElement(WebElement ele,String direction,String value,String value2 ) {	
		driver.executeScript("mobile:scroll", ImmutableMap.of("element",((RemoteWebElement)ele).getId()
				,"direction",direction),
				"percentage", 0.70,
				"endX",value,
				"endY",value2);
	}
	
	public void swipeElement(String direction,WebElement ele ) {
		((JavascriptExecutor)driver).executeScript("mobile:swipe",ImmutableMap.of("element",((RemoteWebElement)ele).getId(),
				"direction",direction));
	}
	
	
	public void launchNativeApp(String name) {
		Map<String,String> params = new HashMap<>();
		params.put("bundleId", name);
		driver.executeScript("mobile: launchApp", params);
		
	}
	
}
