package MobileApplication.mobile.pageObjects.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.AndroidActions;

public class PageForm extends AndroidActions {
	
	AndroidDriver driver;
	
	public PageForm(AndroidDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
	WebElement submit;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
	WebElement name;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/radioFemale")
	WebElement female;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/radiomale")
	WebElement male;
	
	@AndroidFindBy(id = "android:id/text1")
	WebElement dropdown;
	
	@AndroidFindBy(id = "(//android.widget.Toast)[1]")
	WebElement message;
	
	
	public void submit() {
		submit.click();
	}
	
	public String toast(String name) {
		return message.getAttribute(name);
	}
	
	public void setName(AndroidDriver driver,String yes) {
		name.sendKeys(yes);
		driver.hideKeyboard();
	}
	
	
	public void setGender(String gender) {
		if(gender.equalsIgnoreCase("female")) {
			female.click();
		}else if(gender.equalsIgnoreCase("male")) {
			male.click();
		}
	}
	
}



