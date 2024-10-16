package MobileApplication.mobile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import MobileApplication.mobile.pageObjects.iOS.NativeAppPhotos;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import utils.IoSActions;

public class IoSMobileNativeApp extends IoSActions{
	 
	
	public IoSMobileNativeApp(IOSDriver driver) {
		super(driver);
	}

	@Test
	public void swipeNativeApp() {
		
		launchNativeApp( "com.apple.mobileslideshow");
		
		NativeAppPhotos photos = new NativeAppPhotos(driver);
		photos.selectAllPhotosIcon();

		List<WebElement> allPhotos =photos.getAllPhotos();
		int photosize =photos.getAllPhotos().size();
		
		//driver.findElement(AppiumBy.accessibilityId("All Photos")).click();
		
		//List<WebElement> allPhotos = driver.findElements(AppiumBy.iOSClassChain("**/XCUIElementTypeCell"));
          photos.selectPhotoNumber(0);
		
		
	//	driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeCell")).click();
//		
//		for(int i = 0 ;i<allPhotos.size();i++) {
//		    WebElement ele = 	driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeImage"));
//			swipeElement("left",ele);
//			System.out.println(driver.findElement(By.xpath("//XCUIElementTypeNavigationBar")).getAttribute("name"));
//		}
		
		
		photos.getImageAndSwipe(allPhotos);
	//	driver.findElement(AppiumBy.accessibilityId("All Photos")).click();
	//	driver.findElement(AppiumBy.accessibilityId("Albums")).click();	
		photos.selectAllPhotosIcon();
		photos.selectAlbums();
		
	}
	
}
