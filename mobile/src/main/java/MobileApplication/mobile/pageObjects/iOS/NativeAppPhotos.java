package MobileApplication.mobile.pageObjects.iOS;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindAll;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import utils.IoSActions;

public class NativeAppPhotos extends IoSActions {
	
	IOSDriver driver;

	public NativeAppPhotos(IOSDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	@iOSXCUITFindBy(accessibility="All Photos")
	private WebElement allPhotos;
	
	@iOSXCUITFindBy(accessibility="Albums")
	private WebElement albums;
	
	
    @iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeCell")
    private  List<WebElement>  photos;
  
      
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeImage")
    private WebElement image;
    
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar")
    private WebElement navigationBar;
	
    public void selectAllPhotosIcon() {
    	allPhotos.click();
    }
    
    public List<WebElement>  getAllPhotos() {
    	return photos;
    }
    
    public void selectAlbums() {
    	albums.click();
    }
    
    public void selectPhotoNumber(int number) {
    	photos.get(number).click();
    }
    
    
    public void getImageAndSwipe(List<WebElement>  allPhotos) {
    	for(int i = 0 ;i<allPhotos.size();i++) {
			swipeElement("left",image);
			System.out.println(navigationBar.getAttribute("name"));
		}
    }
    
}



