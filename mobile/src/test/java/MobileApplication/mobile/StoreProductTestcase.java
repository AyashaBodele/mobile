package MobileApplication.mobile;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import MobileApplication.mobile.pageObjects.android.PageForm;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class StoreProductTestcase extends BaseClass{
	

	@Test
	public void fillForm() throws InterruptedException {
		PageForm form = new PageForm(driver);
	    form.submit();
	    //driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		//String message = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		String message = form.toast("name");
		Assert.assertEquals(message,"Please enter your name");
		
         form.setName(driver, "Ayasha Bodele");
		
//		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Ayasha Bodele");
//		driver.hideKeyboard();
		
         form.setGender("female");
	//	driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		
		driver.findElement(By.id("android:id/text1")).click();
		
		String country = "Argentina";
        WebElement ele = driver.findElement(AppiumBy.androidUIAutomator( "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().text(\"" + country + "\"))"));

        ele.click();
		
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        Thread.sleep(2000);
        
       driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
      
       driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();

        
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        wait.until(ExpectedConditions.attributeContains(driver.findElement
        		(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
        
        List<WebElement> productPrice = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
        
        double sum =0;
        for (int i = 0; i < productPrice.size(); i++) {
        String price = 	productPrice.get(i).getText();
        String formatedprice = price.substring(1);
        double value = Double.parseDouble(formatedprice.replaceAll(" ", ""));
		sum = sum+value;
		}
     
        String totalAmount = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
        Assert.assertEquals(String.valueOf(sum),totalAmount.substring(2));
        driver.findElement(By.className("android.widget.CheckBox")).click();
        WebElement ele2=driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
        //longPress(ele2);
        driver.findElement(By.id("android:id/button1")).click();
       
        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
        Thread.sleep(6000);
        Set<String> context =driver.getContextHandles();
        for (String string : context) {
			System.out.println(string);
		}

        driver.context("WEBVIEW_com.androidsample.generalstore");
        driver.findElement(By.name("q")).sendKeys("Ayasha Bodele");
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.context("NATIVE_APP");
        Thread.sleep(2000);

        driver.findElement(AppiumBy.androidUIAutomator( "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().text(\"" + country + "\"))"));

	}		
}



