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
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;


public class Setup {
	public AppiumDriverLocalService server;
	public AndroidDriver  driver;
	

	
	
	@BeforeClass
	public void setServer() throws MalformedURLException, URISyntaxException {
		server = new AppiumServiceBuilder().withAppiumJS(new File("//Users//ayashabodele//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		server.start();
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Ayasha Phone");
		options.setApp("//Users//ayashabodele//eclipse-workspace//mobile//src//test//java//resources//ApiDemos-debug.apk");
		driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
	}
	
	
	@AfterClass
	public void shutdown() {
		driver.quit();;
		server.stop();
	}
	
}
