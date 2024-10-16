package MobileApplication.mobile;


import java.io.File;
import java.net.MalformedURLException;
import java.time.Duration;
import java.net.URI;
import java.net.URISyntaxException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;


public class BrowserBaseClass {
	public AppiumDriverLocalService server;
	public AndroidDriver  driver;
	

	
	
	@BeforeClass
	public void setServer() throws MalformedURLException, URISyntaxException {
		server = new AppiumServiceBuilder().withAppiumJS(new File("//Users//ayashabodele//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		server.start();
		UiAutomator2Options options = new UiAutomator2Options();
		//options.setDeviceName("Ayasha Phone");
		options.setCapability("browserName", "chrome");
		options.setChromedriverExecutable("//Users//ayashabodele//Downloads//chromedriver-mac-arm64/chromedriver");
		driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	
	
	
	
	
	@AfterClass
	public void shutdown() {
		driver.quit();;
		server.stop();
	}
	
}
