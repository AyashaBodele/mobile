package utils;

import io.appium.java_client.AppiumDriver;

public class AppiumUtils {


	public Double getFormattedAmount(String amount)
	{
		Double price = Double.parseDouble(amount.substring(1));
		return price;
		
	}
}
