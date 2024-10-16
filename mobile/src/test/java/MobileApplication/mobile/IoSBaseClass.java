package MobileApplication.mobile;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.net.URI;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import utils.AppiumUtils;


public class IoSBaseClass extends AppiumUtils {

	public AppiumDriverLocalService server;
	public IOSDriver  driver;
	

	String app="/Users/ayashabodele/Library/Developer/Xcode/DerivedData/UIKitCatalog-eecrsbuxnmusvofxwnrzjsvrtpds/Build/Products/Debug-iphonesimulator/UIKitCatalog.app";
	
	//String app="//Users//ayashabodele//eclipse-workspace//mobile//src//test//java//resources//TestApp 3.app";
	
	@BeforeClass
	public void setServer() throws MalformedURLException, URISyntaxException {
		server = new AppiumServiceBuilder().withAppiumJS(new File("//Users//ayashabodele//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		server.start();
		XCUITestOptions options = new XCUITestOptions();
		options.setDeviceName("Ayasha iPhone");
		options.setPlatformVersion("15.0");
		options.setWdaLaunchTimeout(Duration.ofSeconds(20));
		options.setApp(app);
		driver = new IOSDriver(new URI("http://127.0.0.1:4723").toURL(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	
	
	
	public XCUITestOptions appLaunch() throws MalformedURLException, URISyntaxException {
		server = new AppiumServiceBuilder().withAppiumJS(new File("//Users//ayashabodele//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		server.start();
		XCUITestOptions options = new XCUITestOptions();
		options.setDeviceName("Ayasha iPhone");
		options.setPlatformVersion("15.0");
		options.setWdaLaunchTimeout(Duration.ofSeconds(20));
		driver = new IOSDriver(new URI("http://127.0.0.1:4723").toURL(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		return options;
		
	}
		
	
}
